package com.brasfoot.reconstruction;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;

final class RecoveredSourcePreparationService {
  private final ProjectContext context;

  RecoveredSourcePreparationService(ProjectContext context) {
    this.context = context;
  }

  void prepare() throws IOException {
    Path source = context.projectDir().resolve("src/recovered/java");
    Path target = context.buildDir().resolve("generated/recovered-sources");
    if (Files.exists(target)) {
      ZipSupport.deleteTreeWithin(target, context.buildDir().resolve("generated"));
    }
    Files.walkFileTree(source, new SimpleFileVisitor<>() {
      @Override
      public FileVisitResult preVisitDirectory(Path directory, BasicFileAttributes attributes)
          throws IOException {
        Files.createDirectories(target.resolve(source.relativize(directory).toString()));
        return FileVisitResult.CONTINUE;
      }

      @Override
      public FileVisitResult visitFile(Path file, BasicFileAttributes attributes)
          throws IOException {
        Path destination = target.resolve(source.relativize(file).toString());
        Files.createDirectories(destination.getParent());
        Files.copy(file, destination, StandardCopyOption.REPLACE_EXISTING,
            StandardCopyOption.COPY_ATTRIBUTES);
        return FileVisitResult.CONTINUE;
      }
    });
    int methods = new SyntheticMethodSourceService(context).augment(target);
    System.out.println("Prepared recovered sources with " + methods
        + " synthetic method signatures for compilation.");
  }
}
