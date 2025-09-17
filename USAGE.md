## Installation

Add the plugin to your `plugins` block:

```kotlin
plugins {
    id("com.mohitkansal.gradle-version") version "0.1.0"
}
```

## Usage

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

## Example Output

```kotlin
./gradlew printGradleVersion

GradleVersion: code=123, name=1.2.0-SNAPSHOT
```
