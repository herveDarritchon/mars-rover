import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.31"
}

group = "com.orange.kata"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val junitVersion = "5.4.2"

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    compile(kotlin("reflect"))

    testCompile("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    testCompile("org.junit.jupiter:junit-jupiter-params:$junitVersion")

    testCompile("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
    testCompile ("org.assertj:assertj-core:3.12.2")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}