plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
    id("com.gradle.plugin-publish") version "1.2.1"
}

repositories {
    gradlePluginPortal()
    mavenCentral()
}

group = "io.github.kansalmohit19"
version = "1.0.1"

gradlePlugin {
    website.set("https://github.com/kansalmohit19/GradleVersionPlugin")
    vcsUrl.set("https://github.com/kansalmohit19/GradleVersionPlugin")

    plugins {
        create("gradleVersionPlugin") {
            id = "io.github.kansalmohit19.gradle-version"
            implementationClass = "com.mohitkansal.GradleVersionPlugin"
            displayName = "Gradle Version Plugin"
            description = "Automatically generates versionCode and versionName from Git."
            tags.set(listOf("android", "versioning", "git"))
        }
    }
}