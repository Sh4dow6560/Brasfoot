package com.brasfoot.reconstruction;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

final class CandidateCompileService {
  private final ProjectContext context;

  CandidateCompileService(ProjectContext context) {
    this.context = context;
  }

  void analyze() throws Exception {
    Path sourceRoot = context.buildDir().resolve("generated/decompiled");
    if (!Files.isDirectory(sourceRoot)) {
      throw new IOException("Decompiled sources not found: " + sourceRoot);
    }
    JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
    if (compiler == null) {
      throw new IllegalStateException("A full JDK is required for candidate analysis");
    }

    List<Path> sources;
    try (var paths = Files.walk(sourceRoot)) {
      sources = paths.filter(Files::isRegularFile)
          .filter(path -> path.getFileName().toString().endsWith(".java"))
          .sorted()
          .toList();
    }
    Path workRoot = context.buildDir().resolve("work/candidate-analysis");
    if (Files.exists(workRoot)) {
      ZipSupport.deleteTreeWithin(workRoot, context.buildDir().resolve("work"));
    }
    Files.createDirectories(workRoot);
    Path emptySourcePath = workRoot.resolve("empty-sourcepath");
    Files.createDirectories(emptySourcePath);
    String compileClasspath = candidateClasspath();

    int workerCount = Math.max(1, Math.min(4, Runtime.getRuntime().availableProcessors()));
    ExecutorService executor = Executors.newFixedThreadPool(workerCount);
    List<Future<CandidateResult>> futures = new ArrayList<>();
    try {
      for (int index = 0; index < sources.size(); index++) {
        Path source = sources.get(index);
        int candidateIndex = index;
        futures.add(executor.submit((Callable<CandidateResult>) () -> compileOne(
            compiler, sourceRoot, source, workRoot, emptySourcePath, compileClasspath,
            candidateIndex)));
      }
      List<CandidateResult> results = new ArrayList<>();
      for (Future<CandidateResult> future : futures) {
        results.add(future.get());
      }
      results.sort(Comparator.comparing(CandidateResult::source));
      writeReports(results, workerCount);
    } finally {
      executor.shutdownNow();
    }
  }

  private CandidateResult compileOne(
      JavaCompiler compiler,
      Path sourceRoot,
      Path source,
      Path workRoot,
      Path emptySourcePath,
      String compileClasspath,
      int index) throws IOException {
    Path output = workRoot.resolve(String.format(Locale.ROOT, "classes/%04d", index));
    Files.createDirectories(output);
    DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<>();
    boolean success;
    try (StandardJavaFileManager files = compiler.getStandardFileManager(
        diagnostics, Locale.ROOT, StandardCharsets.UTF_8)) {
      Iterable<? extends JavaFileObject> units = files.getJavaFileObjects(source.toFile());
      List<String> options = List.of(
          "--release", "8",
          "-proc:none",
          "-classpath", compileClasspath,
          "-sourcepath", emptySourcePath.toString(),
          "-d", output.toString(),
          "-Xlint:-options",
          "-Xmaxerrs", "100");
      success = Boolean.TRUE.equals(compiler.getTask(
          null, files, diagnostics, options, null, units).call());
    }

    List<CompileDiagnostic> errors = diagnostics.getDiagnostics().stream()
        .filter(item -> item.getKind() == Diagnostic.Kind.ERROR)
        .limit(10)
        .map(item -> new CompileDiagnostic(
            item.getCode(),
            item.getLineNumber(),
            item.getColumnNumber(),
            item.getMessage(Locale.ROOT)))
        .toList();
    long classFiles = 0;
    if (success) {
      try (var paths = Files.walk(output)) {
        classFiles = paths.filter(Files::isRegularFile)
            .filter(path -> path.getFileName().toString().endsWith(".class"))
            .count();
      }
    } else {
      ZipSupport.deleteTreeWithin(output, workRoot.resolve("classes"));
    }
    return new CandidateResult(
        sourceRoot.relativize(source).toString().replace('\\', '/'),
        success,
        classFiles,
        errors);
  }

  private String candidateClasspath() throws IOException {
    List<String> entries = new ArrayList<>();
    entries.add(context.recoveredClassesDir().toString());
    entries.add(context.buildDir().resolve("work/named/bf22-23-compile-support.jar").toString());
    Path embedded = context.buildDir().resolve("work/embedded-libs");
    if (!Files.isDirectory(embedded)) {
      throw new IOException("Embedded game libraries not extracted: " + embedded);
    }
    try (var paths = Files.list(embedded)) {
      paths.filter(Files::isRegularFile)
          .filter(path -> path.getFileName().toString().endsWith(".jar"))
          .sorted()
          .map(Path::toString)
          .forEach(entries::add);
    }
    if (entries.size() != 6) {
      throw new IOException("Expected four embedded game libraries, got "
          + (entries.size() - 2));
    }
    return String.join(File.pathSeparator, entries);
  }

  private void writeReports(List<CandidateResult> results, int workers) throws IOException {
    long successful = results.stream().filter(CandidateResult::success).count();
    long failed = results.size() - successful;
    Map<String, Integer> categories = new TreeMap<>();
    for (CandidateResult result : results) {
      for (CompileDiagnostic diagnostic : result.errors()) {
        categories.merge(diagnostic.code(), 1, Integer::sum);
      }
    }
    List<FailureCategory> categoryList = categories.entrySet().stream()
        .map(entry -> new FailureCategory(entry.getKey(), entry.getValue()))
        .sorted(Comparator.comparing(FailureCategory::occurrences).reversed()
            .thenComparing(FailureCategory::code))
        .toList();

    CandidateCompilationReport report = new CandidateCompilationReport(
        1, results.size(), successful, failed, workers, categoryList, results);
    context.writeJson(context.reportsDir().resolve("candidate-compilation.json"), report);

    StringBuilder markdown = new StringBuilder("# Compilacao Candidata\n\n")
        .append("Analise isolada das fontes geradas pelo Vineflower. Cada arquivo usa o JAR ")
        .append("nomeado apenas como dependencia binaria.\n\n")
        .append("- Fontes analisadas: ").append(results.size()).append("\n")
        .append("- Compilam sem alteracao: ").append(successful).append("\n")
        .append("- Exigem correcao: ").append(failed).append("\n")
        .append("- Processos paralelos: ").append(workers).append("\n\n")
        .append("## Principais Bloqueios\n\n")
        .append("| Diagnostico | Ocorrencias |\n|---|---:|\n");
    categoryList.stream().limit(20).forEach(category -> markdown.append('|')
        .append(category.code()).append('|').append(category.occurrences()).append("|\n"));
    markdown.append("\n## Primeiras Fontes Com Falha\n\n")
        .append("| Fonte | Primeiro diagnostico | Linha |\n|---|---|---:|\n");
    results.stream().filter(result -> !result.success()).limit(100).forEach(result -> {
      CompileDiagnostic first = result.errors().isEmpty()
          ? new CompileDiagnostic("unknown", -1, -1, "Unknown compiler failure")
          : result.errors().get(0);
      markdown.append('|').append(result.source()).append('|')
          .append(first.code()).append('|').append(first.line()).append("|\n");
    });
    Files.writeString(
        context.modkitRoot().resolve("docs/CANDIDATE_COMPILATION.md"),
        markdown.toString(),
        StandardCharsets.UTF_8);
    System.out.println("Candidate compilation analyzed " + results.size() + " sources: "
        + successful + " compile clean, " + failed + " require repair.");
  }

  record CandidateCompilationReport(
      int schemaVersion,
      int sources,
      long successful,
      long failed,
      int workers,
      List<FailureCategory> failureCategories,
      List<CandidateResult> results) {
  }

  record FailureCategory(String code, int occurrences) {
  }

  record CandidateResult(
      String source,
      boolean success,
      long classFiles,
      List<CompileDiagnostic> errors) {
  }

  record CompileDiagnostic(String code, long line, long column, String message) {
  }
}
