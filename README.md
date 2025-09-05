# 🚀 Gradle Version Plugin

[![Gradle](https://img.shields.io/badge/Gradle-7.0%2B-green?logo=gradle)](https://gradle.org/) 
[![Kotlin](https://img.shields.io/badge/Kotlin-DSL-blue?logo=kotlin)](https://kotlinlang.org/) 
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)  

A lightweight Gradle plugin that automatically generates **versionCode** and **versionName** directly from your Git history.  
Perfect for Android projects and any build setup where you want Git-driven versioning.

---

## ✨ Features

- 🔢 **versionCode** → Derived from the total number of Git commits (`git rev-list --count HEAD`).
- 🏷️ **versionName** → Dynamically generated (based on tags or commit count).
- ⚡ **Zero config** → Just apply the plugin and use the values.
- 🔒 **Safe defaults** → Falls back gracefully if Git is not available.

---

## 📦 Installation

Add the plugin to your `plugins` block:

```kotlin
plugins {
    id("com.mohitkansal.gradle-version") version "0.1.0"
}
```

## ⚙️ Usage

### Android example

```kotlin
android {
    defaultConfig {
        versionCode = gradleVersion.code.get()
        versionName = gradleVersion.name.get()
    }
}
```

### Custom task example

```kotlin
tasks.register("printVersion") {
    doLast {
        println("App Version → Code=${gradleVersion.code.get()}, Name=${gradleVersion.name.get()}")
    }
}
```

## 📋 Example Output

```kotlin
> ./gradlew printGradleVersion

GradleVersion: code=123, name=1.2.0-SNAPSHOT
```

## ⭐ If you like this plugin, don’t forget to star the repo!
[![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/kansalmohit19/GradleVersionPlugin)
