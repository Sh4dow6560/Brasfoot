package com.brasfoot.reconstruction;

import com.brasfoot.reconstruction.ArchiveService.ArchiveData;
import com.brasfoot.reconstruction.ArchiveService.ClassInfo;
import com.brasfoot.reconstruction.ProjectContext.VersionSpec;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

final class AtlasService {
  private final ProjectContext context;
  private final ArchiveService archives = new ArchiveService();

  AtlasService(ProjectContext context) {
    this.context = context;
  }

  void verifyInputs() throws IOException {
    List<VerificationResult> results = new ArrayList<>();
    List<String> errors = new ArrayList<>();

    for (VersionSpec expected : context.inputLock().versions()) {
      Path path = context.input(expected.id());
      ArchiveData actual = archives.analyze(path);
      List<String> mismatches = new ArrayList<>();
      compare(mismatches, "fileName", expected.fileName(), path.getFileName().toString());
      compare(mismatches, "size", expected.size(), actual.size());
      compare(mismatches, "sha256", expected.sha256(), actual.sha256());
      compare(mismatches, "entries", expected.entries(), actual.entries());
      compare(mismatches, "classes", expected.classes(), actual.classes().size());
      compare(mismatches, "javaMajor", expected.javaMajor(), actual.javaMajor());
      compare(mismatches, "mainClass", expected.mainClass(), actual.mainClass());
      if (!mismatches.isEmpty()) {
        errors.add(expected.id() + ": " + String.join(", ", mismatches));
      }
      results.add(new VerificationResult(
          expected.id(), path.toString(), actual.size(), actual.sha256(), actual.entries(),
          actual.classes().size(), actual.javaMajor(), actual.mainClass(), mismatches.isEmpty(),
          List.copyOf(mismatches)));
    }

    context.writeJson(context.reportsDir().resolve("input-verification.json"),
        new VerificationReport(errors.isEmpty(), results));
    if (!errors.isEmpty()) {
      throw new IllegalStateException("Input verification failed: " + String.join("; ", errors));
    }
    System.out.println("Verified " + results.size() + " original executables; all hashes match.");
  }

  void buildVersionAtlas() throws IOException {
    List<VersionSummary> versions = new ArrayList<>();
    List<ArchiveData> snapshots = new ArrayList<>();
    for (VersionSpec spec : context.inputLock().versions()) {
      ArchiveData archive = archives.analyze(context.input(spec.id()));
      snapshots.add(archive);
      int fields = archive.classes().values().stream()
          .mapToInt(value -> (int) value.members().stream()
              .filter(member -> "field".equals(member.kind())).count()).sum();
      int methods = archive.classes().values().stream()
          .mapToInt(value -> (int) value.members().stream()
              .filter(member -> "method".equals(member.kind())).count()).sum();
      versions.add(new VersionSummary(
          spec.id(), archive.size(), archive.sha256(), archive.entries(), archive.classes().size(),
          fields, methods, archive.resources().size(), archive.javaMajor(), archive.mainClass(),
          archive.caseCollisionGroups(), archive.illegalClasses(), archive.illegalMembers()));
    }

    List<TransitionSummary> transitions = new ArrayList<>();
    for (int index = 1; index < snapshots.size(); index++) {
      transitions.add(compare(
          context.inputLock().versions().get(index - 1).id(), snapshots.get(index - 1),
          context.inputLock().versions().get(index).id(), snapshots.get(index)));
    }

    AtlasReport report = new AtlasReport(versions, transitions);
    context.writeJson(context.reportsDir().resolve("version-atlas.json"), report);
    writeMarkdown(report, context.modkitRoot().resolve("docs/VERSION_ATLAS.md"));
    System.out.println("Version atlas generated for " + versions.size() + " releases.");
  }

  private TransitionSummary compare(String fromId, ArchiveData from, String toId, ArchiveData to) {
    Set<String> common = new TreeSet<>(from.classes().keySet());
    common.retainAll(to.classes().keySet());
    Set<String> added = new TreeSet<>(to.classes().keySet());
    added.removeAll(from.classes().keySet());
    Set<String> removed = new TreeSet<>(from.classes().keySet());
    removed.removeAll(to.classes().keySet());
    List<String> changed = new ArrayList<>();
    int unchanged = 0;
    int membersAdded = 0;
    int membersRemoved = 0;

    for (String name : common) {
      ClassInfo left = from.classes().get(name);
      ClassInfo right = to.classes().get(name);
      if (left.sha256().equals(right.sha256())) {
        unchanged++;
      } else {
        changed.add(name);
      }
      Set<String> leftMembers = new HashSet<>();
      left.members().forEach(member -> leftMembers.add(member.signature()));
      Set<String> rightMembers = new HashSet<>();
      right.members().forEach(member -> rightMembers.add(member.signature()));
      Set<String> memberDelta = new HashSet<>(rightMembers);
      memberDelta.removeAll(leftMembers);
      membersAdded += memberDelta.size();
      memberDelta = new HashSet<>(leftMembers);
      memberDelta.removeAll(rightMembers);
      membersRemoved += memberDelta.size();
    }

    Set<String> resourceCommon = new TreeSet<>(from.resources().keySet());
    resourceCommon.retainAll(to.resources().keySet());
    int resourceChanged = 0;
    for (String name : resourceCommon) {
      if (!from.resources().get(name).sha256().equals(to.resources().get(name).sha256())) {
        resourceChanged++;
      }
    }
    Set<String> resourcesAdded = new TreeSet<>(to.resources().keySet());
    resourcesAdded.removeAll(from.resources().keySet());
    Set<String> resourcesRemoved = new TreeSet<>(from.resources().keySet());
    resourcesRemoved.removeAll(to.resources().keySet());

    return new TransitionSummary(
        fromId, toId, common.size(), unchanged, changed.size(), List.copyOf(added),
        List.copyOf(removed), List.copyOf(changed), membersAdded, membersRemoved,
        resourcesAdded.size(), resourcesRemoved.size(), resourceChanged);
  }

  private void writeMarkdown(AtlasReport report, Path output) throws IOException {
    StringBuilder markdown = new StringBuilder();
    markdown.append("# Atlas De Versoes\n\n");
    markdown.append("Relatorio deterministico gerado a partir dos executaveis locais.\n\n");
    markdown.append("| Versao | Classes | Campos | Metodos | Recursos | Java | Colisoes | SHA256 |\n");
    markdown.append("|---|---:|---:|---:|---:|---:|---:|---|\n");
    for (VersionSummary version : report.versions()) {
      markdown.append("|").append(version.id()).append("|")
          .append(version.classes()).append("|")
          .append(version.fields()).append("|")
          .append(version.methods()).append("|")
          .append(version.resources()).append("|")
          .append(version.javaMajor()).append("|")
          .append(version.caseCollisionGroups()).append("|`")
          .append(version.sha256()).append("`|\n");
    }
    markdown.append("\n| Transicao | Comuns | Identicas | Alteradas | Adicionadas | Removidas |\n");
    markdown.append("|---|---:|---:|---:|---:|---:|\n");
    for (TransitionSummary transition : report.transitions()) {
      markdown.append("|").append(transition.from()).append(" -> ").append(transition.to())
          .append("|").append(transition.commonClasses())
          .append("|").append(transition.unchangedClasses())
          .append("|").append(transition.changedClasses())
          .append("|").append(transition.addedClassNames().size())
          .append("|").append(transition.removedClassNames().size()).append("|\n");
    }
    Files.createDirectories(output.getParent());
    Files.writeString(output, markdown.toString(), StandardCharsets.UTF_8);
  }

  private void compare(List<String> mismatches, String name, Object expected, Object actual) {
    if (!String.valueOf(expected).equalsIgnoreCase(String.valueOf(actual))) {
      mismatches.add(name + " expected=" + expected + " actual=" + actual);
    }
  }

  record VerificationReport(boolean ok, List<VerificationResult> versions) {
  }

  record VerificationResult(
      String id, String path, long size, String sha256, int entries, int classes,
      int javaMajor, String mainClass, boolean ok, List<String> mismatches) {
  }

  record AtlasReport(List<VersionSummary> versions, List<TransitionSummary> transitions) {
  }

  record VersionSummary(
      String id, long size, String sha256, int entries, int classes, int fields, int methods,
      int resources, int javaMajor, String mainClass, long caseCollisionGroups,
      long illegalClasses, long illegalMembers) {
  }

  record TransitionSummary(
      String from, String to, int commonClasses, int unchangedClasses, int changedClasses,
      List<String> addedClassNames, List<String> removedClassNames, List<String> changedClassNames,
      int membersAdded, int membersRemoved, int resourcesAdded, int resourcesRemoved,
      int resourcesChanged) {
  }
}
