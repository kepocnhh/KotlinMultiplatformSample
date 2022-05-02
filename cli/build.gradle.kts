repositories.mavenCentral()

plugins {
    id("org.jetbrains.kotlin.jvm")
    id("org.gradle.application")
}

application {
    mainClass.set("test.kmp.cli.AppKt")
}

dependencies {
    implementation(project(":common"))
}

tasks.getByName<JavaCompile>("compileJava") {
    targetCompatibility = Version.jvmTarget
}

tasks.getByName<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>("compileKotlin") {
    kotlinOptions.jvmTarget = Version.jvmTarget
}

task<Jar>("assembleJar") {
    with(tasks.getByName<Jar>("jar"))
    archiveBaseName.set("test.kmp.cli") // todo
    archiveVersion.set("0.0.1") // todo
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    manifest {
        attributes(mapOf("Main-Class" to application.mainClass))
    }
    from(configurations.compileClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
}
