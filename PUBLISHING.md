# Gradle Version Plugin Publishing


## Add
- **gradle.publish.key=**
- **gradle.publish.secret=**

inside ~/.gradle/gradle.properties → machine-wide properties for all Gradle builds.

### Publishing Tasks
- **./gradlew publishToMavenLocal** → Publish task to Maven Local
- **./gradlew publishPlugins** →  Publishes this plugin to the Gradle Plugin portal