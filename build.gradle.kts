plugins {
    `java-library`
    checkstyle
}

checkstyle {
    toolVersion = "10.3.3"
    configFile = File("config/checkstyle/checkstyle.xml")
}

repositories {
    mavenLocal()
    maven {
        url = uri("https://repo.maven.apache.org/maven2/")
    }
}

dependencies {
    api("commons-io:commons-io:2.12.0")
}

group = "ru.levelp.at"
version = "1.0-SNAPSHOT"
description = "levelup-automation-basic-spring-2023-may"
java.sourceCompatibility = JavaVersion.VERSION_11
java.targetCompatibility = JavaVersion.VERSION_11

tasks.withType<JavaCompile>() {
    options.encoding = "UTF-8"
}

tasks.withType<Javadoc>() {
    options.encoding = "UTF-8"
}
