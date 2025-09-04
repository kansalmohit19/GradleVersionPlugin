plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
    id("com.gradle.plugin-publish") version "1.2.1"
    id("signing")
}

repositories {
    gradlePluginPortal()
    mavenCentral()
}

group = "io.github.kansalmohit19"
version = "1.0.1"

gradlePlugin {
    website = "https://github.com/kansalmohit19/GradleVersionPlugin"
    vcsUrl = "https://github.com/kansalmohit19/GradleVersionPlugin.git"
    //tags = listOf("android", "gradle", "versioning", "git")

    plugins {
        create("gradleVersionPlugin") {
            id = "com.mohitkansal.gradle-version"   // plugin id used in builds
            implementationClass = "com.mohitkansal.GradleVersionPlugin"
            displayName = "Gradle Version Plugin"
            description = "Automatically generates versionCode and versionName from Git."
        }
    }
}