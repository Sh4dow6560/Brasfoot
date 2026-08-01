import org.gradle.api.tasks.JavaExec
import org.gradle.api.tasks.compile.JavaCompile
import org.gradle.jvm.tasks.Jar

plugins {
    java
}

group = "com.brasfoot.reconstruction"
version = "0.1.0"

repositories {
    mavenCentral()
    maven("https://maven.fabricmc.net")
}

val vineflower = configurations.create("vineflower")
val embeddedLibrariesDir = layout.buildDirectory.dir("work/embedded-libs")

dependencies {
    implementation("com.google.code.gson:gson:2.13.2")
    implementation("net.fabricmc:tiny-remapper:0.14.0")
    implementation("org.ow2.asm:asm:9.9.1")
    implementation("org.ow2.asm:asm-tree:9.9.1")

    vineflower("org.vineflower:vineflower:1.12.0")

    testImplementation(platform("org.junit:junit-bom:5.13.4"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

sourceSets {
    main {
        java.setSrcDirs(listOf("src/tooling/java"))
    }
}

val recovered = sourceSets.create("recovered") {
    java.setSrcDirs(listOf(layout.buildDirectory.dir("generated/recovered-sources")))
    compileClasspath += files(
        layout.buildDirectory.file("work/named/bf22-23-compile-support.jar")
    )
}
recovered.compileClasspath += fileTree(embeddedLibrariesDir) {
    include("*.jar")
}

val agent = sourceSets.create("agent") {
    java.setSrcDirs(listOf("src/agent/java"))
}
agent.compileClasspath += fileTree(embeddedLibrariesDir) {
    include("*.jar")
}

val candidate = sourceSets.create("candidate") {
    java.setSrcDirs(listOf(layout.buildDirectory.dir("generated/decompiled")))
    java.exclude(
        "bf22/intermediary/C1033.java",
        "bf22/intermediary/C1034.java",
        "bf22/intermediary/C1035.java",
        "bf22/intermediary/C1036.java",
        "bf22/intermediary/C1037.java",
        "bf22/intermediary/C1038.java"
    )
    compileClasspath += files(layout.buildDirectory.file("work/named/bf22-23-named.jar"))
}
candidate.compileClasspath += fileTree(embeddedLibrariesDir) {
    include("*.jar")
}

tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
}

tasks.named<JavaCompile>("compileJava") {
    options.release.set(17)
}

tasks.named<JavaCompile>(recovered.compileJavaTaskName) {
    dependsOn(
        "prepareRecoveredSources",
        "buildSyntheticCompileClasspath",
        "extractEmbeddedLibraries"
    )
    options.release.set(8)
    options.compilerArgs.add("-Xlint:-options")
}

tasks.named<JavaCompile>(agent.compileJavaTaskName) {
    options.release.set(8)
    options.compilerArgs.add("-Xlint:-options")
}

tasks.named<JavaCompile>(candidate.compileJavaTaskName) {
    options.release.set(8)
    options.compilerArgs.addAll(listOf("-Xlint:-options", "-Xmaxerrs", "5000"))
}

tasks.test {
    useJUnitPlatform()
}

fun registerToolTask(
    taskName: String,
    command: String,
    configuration: JavaExec.() -> Unit = {}
) = tasks.register<JavaExec>(taskName) {
    group = "reconstruction"
    dependsOn("classes")
    classpath = sourceSets.main.get().runtimeClasspath
    mainClass.set("com.brasfoot.reconstruction.ReconstructionTool")
    args(command, projectDir.absolutePath)
    configuration()
}

val verifyInputs = registerToolTask("verifyInputs", "verify-inputs")

val normalizeGame = registerToolTask("normalizeGame", "normalize-game") {
    dependsOn(verifyInputs)
}

val extractEmbeddedLibraries = tasks.register<Copy>("extractEmbeddedLibraries") {
    group = "reconstruction"
    dependsOn(normalizeGame)
    from({ zipTree(layout.buildDirectory.file("work/normalized/bf22-23.jar").get().asFile) })
    include("*.jar")
    into(embeddedLibrariesDir)
}

tasks.named<JavaCompile>(agent.compileJavaTaskName) {
    dependsOn(extractEmbeddedLibraries)
}

val buildVersionAtlas = registerToolTask("buildVersionAtlas", "build-version-atlas") {
    dependsOn(verifyInputs)
}

registerToolTask("captureReferenceSave", "capture-reference-save")

registerToolTask("verifyReferenceSave", "verify-reference-save")

val buildSerializationAtlas = registerToolTask(
    "buildSerializationAtlas", "build-serialization-atlas"
) {
    dependsOn(normalizeGame, generateMappings)
}

val generateMappings = registerToolTask("generateMappings", "generate-mappings") {
    dependsOn(verifyInputs)
}

val remapGame = registerToolTask("remapGame", "remap-game") {
    dependsOn(normalizeGame, generateMappings)
}

val prepareRecoveredSources = registerToolTask(
    "prepareRecoveredSources", "prepare-recovered-sources"
) {
    dependsOn(remapGame)
    inputs.dir(layout.projectDirectory.dir("src/recovered/java"))
    inputs.file(layout.buildDirectory.file("work/named/bf22-23-named.jar"))
    outputs.dir(layout.buildDirectory.dir("generated/recovered-sources"))
}

val buildSyntheticCompileClasspath = registerToolTask(
    "buildSyntheticCompileClasspath", "build-synthetic-compile-classpath"
) {
    dependsOn(remapGame)
    inputs.file(layout.buildDirectory.file("work/named/bf22-23-named.jar"))
    outputs.file(layout.buildDirectory.file("work/named/bf22-23-compile-support.jar"))
}

tasks.register<JavaExec>("decompileGame") {
    group = "reconstruction"
    dependsOn(remapGame)
    classpath = vineflower
    mainClass.set("org.jetbrains.java.decompiler.main.decompiler.ConsoleDecompiler")
    val input = layout.buildDirectory.file("work/named/bf22-23-named.jar")
    val output = layout.buildDirectory.dir("generated/decompiled-raw")
    inputs.file(input)
    outputs.dir(output)
    doFirst {
        delete(output)
        output.get().asFile.mkdirs()
        args("-log=ERROR", input.get().asFile.absolutePath,
            output.get().asFile.absolutePath)
    }
}

val repairDecompiledSources = registerToolTask(
    "repairDecompiledSources", "repair-decompiled-sources"
) {
    dependsOn("decompileGame")
    inputs.dir(layout.buildDirectory.dir("generated/decompiled-raw"))
    inputs.file(layout.projectDirectory.file("config/decompiler-repairs.json"))
    outputs.dir(layout.buildDirectory.dir("generated/decompiled"))
}

tasks.named<JavaCompile>(candidate.compileJavaTaskName) {
    dependsOn(repairDecompiledSources, extractEmbeddedLibraries)
}

tasks.register("compileAllDecompiled") {
    group = "reconstruction"
    dependsOn(tasks.named(candidate.classesTaskName))
    doLast {
        val sourceCount = candidate.allJava.files.size
        val classCount = candidate.output.classesDirs.files.sumOf { directory ->
            if (!directory.exists()) 0L else directory.walkTopDown().count { it.isFile && it.extension == "class" }.toLong()
        }
        println("Compiled $sourceCount decompiled Java sources into $classCount class files.")
    }
}

val analyzeCandidateCompilation = registerToolTask(
    "analyzeCandidateCompilation", "analyze-candidate-compilation"
) {
    dependsOn(
        repairDecompiledSources,
        tasks.named(recovered.classesTaskName),
        extractEmbeddedLibraries,
        buildSyntheticCompileClasspath
    )
    inputs.dir(layout.buildDirectory.dir("generated/decompiled"))
    inputs.files(recovered.output.classesDirs)
    inputs.file(layout.projectDirectory.file("mappings/brasfoot-22-23.tiny"))
    outputs.file(layout.buildDirectory.file("reports/candidate-compilation.json"))
    outputs.file(layout.projectDirectory.file("../docs/CANDIDATE_COMPILATION.md"))
}

registerToolTask("promoteCandidateBatch", "promote-candidate-batch") {
    dependsOn(analyzeCandidateCompilation)
}

registerToolTask("applySemanticSourceMappings", "apply-semantic-source-mappings")
registerToolTask("applySemanticMemberMappings", "apply-semantic-member-mappings")

tasks.register("compileRecovered") {
    group = "reconstruction"
    dependsOn(tasks.named(recovered.classesTaskName))
}

val agentJar = tasks.register<Jar>("agentJar") {
    group = "reconstruction"
    dependsOn(tasks.named(agent.classesTaskName))
    archiveFileName.set("brasfoot-runtime-probe.jar")
    from(agent.output)
    manifest {
        attributes(
            "Premain-Class" to "com.brasfoot.reconstruction.agent.RuntimeProbeAgent",
            "Can-Redefine-Classes" to "false",
            "Can-Retransform-Classes" to "false"
        )
    }
}

val assembleHybrid = registerToolTask("assembleHybrid", "assemble-hybrid") {
    dependsOn(tasks.named(recovered.classesTaskName), remapGame)
}

val staticSmokeTest = registerToolTask("staticSmokeTest", "static-smoke") {
    dependsOn(assembleHybrid)
}

val runtimeSmokeTest = registerToolTask("runtimeSmokeTest", "runtime-smoke") {
    dependsOn(assembleHybrid, agentJar)
}

val saveCompatibilityTest = registerToolTask("saveCompatibilityTest", "save-compatibility") {
    dependsOn(assembleHybrid, agentJar)
}

val fullSaveCompatibilityTest = registerToolTask(
    "fullSaveCompatibilityTest", "full-save-compatibility"
) {
    dependsOn(assembleHybrid, agentJar, extractEmbeddedLibraries)
}

val teamRoundTrip = tasks.register<Exec>("teamRoundTrip") {
    group = "verification"
    dependsOn(assembleHybrid)
    commandLine(
        "powershell.exe", "-NoProfile", "-ExecutionPolicy", "Bypass", "-File",
        projectDir.resolve("scripts/team-roundtrip.ps1").absolutePath
    )
}

tasks.register("smokeTest") {
    group = "verification"
    dependsOn(
        staticSmokeTest,
        runtimeSmokeTest,
        saveCompatibilityTest,
        fullSaveCompatibilityTest,
        teamRoundTrip
    )
}

registerToolTask("runHybrid", "run-hybrid") {
    dependsOn(assembleHybrid)
}

tasks.named("check") {
    dependsOn(buildVersionAtlas, buildSerializationAtlas, generateMappings)
}
