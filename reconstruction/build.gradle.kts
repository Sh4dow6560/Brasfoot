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
    java.setSrcDirs(listOf("src/recovered/java"))
    compileClasspath += files(layout.buildDirectory.file("work/named/bf22-23-named.jar"))
}

val agent = sourceSets.create("agent") {
    java.setSrcDirs(listOf("src/agent/java"))
}

tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
}

tasks.named<JavaCompile>("compileJava") {
    options.release.set(17)
}

tasks.named<JavaCompile>(recovered.compileJavaTaskName) {
    dependsOn("remapGame")
    options.release.set(8)
    options.compilerArgs.add("-Xlint:-options")
}

tasks.named<JavaCompile>(agent.compileJavaTaskName) {
    options.release.set(8)
    options.compilerArgs.add("-Xlint:-options")
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

tasks.register<JavaExec>("decompileGame") {
    group = "reconstruction"
    dependsOn(remapGame)
    classpath = vineflower
    mainClass.set("org.jetbrains.java.decompiler.main.decompiler.ConsoleDecompiler")
    val input = layout.buildDirectory.file("work/named/bf22-23-named.jar")
    val output = layout.buildDirectory.dir("generated/decompiled")
    inputs.file(input)
    outputs.dir(output)
    doFirst {
        delete(output)
        output.get().asFile.mkdirs()
        args("-log=ERROR", input.get().asFile.absolutePath,
            output.get().asFile.absolutePath)
    }
}

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
    dependsOn(staticSmokeTest, runtimeSmokeTest, saveCompatibilityTest, teamRoundTrip)
}

registerToolTask("runHybrid", "run-hybrid") {
    dependsOn(assembleHybrid)
}

tasks.named("check") {
    dependsOn(buildVersionAtlas, buildSerializationAtlas, generateMappings)
}
