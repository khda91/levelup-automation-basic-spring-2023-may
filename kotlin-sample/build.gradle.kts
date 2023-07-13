import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.9.0"
}

group = "ru.levelp.at"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    api("commons-io:commons-io:2.12.0")
}

tasks.test {

}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}
