# Gradle Version Plugin

A simple Gradle plugin that generates version information from Git.

## Features
- **versionCode** → Based on the total number of Git commits (`git rev-list --count HEAD`).
- **versionName** → Based on the latest Git tag, with `-SNAPSHOT` appended if not on a tag.

## Usage

### Apply the plugin
```kotlin
plugins {
    id("com.mohitkansal.gradle-version") version "0.1.0"
}
```
### Accessing values
```kotlin
android {
    defaultConfig {
        versionCode = gradleVersion.code.get()
        versionName = gradleVersion.name.get()
    }
}
```
### Example output
```kotlin
GradleVersion: code=123, name=1.2.0-SNAPSHOT
```
