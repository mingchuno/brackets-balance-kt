import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    extra.apply {
        set("kotestVersion", "4.4.1")
    }
}

plugins {
    kotlin("jvm") version "1.4.30"
    application
}

group = "me.mcor"
version = "1.0-SNAPSHOT"

val kotestVersion = "4.4.1"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test-junit5"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.6.0")
    testImplementation("io.kotest:kotest-runner-junit5:${kotestVersion}")
    testImplementation("io.kotest:kotest-assertions-core:${kotestVersion}")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "11"
}

application {
    mainClassName = "MainKt"
}
