plugins {
    `kotlin-dsl`              // for plugin written in Kotlin
    `java-gradle-plugin`      // marks this as a Gradle plugin
    `maven-publish`           // allows publishing to mavenLocal
}

group = "com.mohitkansal"         // Maven groupId
version = "1.0.0"             // Maven version

gradlePlugin {
    plugins {
        create("gradleVersionPlugin") {
            id = "com.mohitkansal.gradle-version"   // plugin id used in builds
            implementationClass = "com.mohitkansal.GradleVersionPlugin"
        }
    }
}

repositories {
    mavenCentral()
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
        }
    }
}