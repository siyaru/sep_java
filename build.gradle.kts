import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    kotlin("jvm") version "1.4.0"
    application
}
group = "com.example.talent.sep"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
   testImplementation(kotlin("test-junit5"))
//    testImplementation("org.junit.jupiter:junit-jupiter:5.6.2")
   testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.6.2")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}

application {
    mainClassName = "MainKt"
}