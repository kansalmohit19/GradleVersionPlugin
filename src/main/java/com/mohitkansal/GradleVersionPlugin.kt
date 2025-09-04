package com.mohitkansal

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.provider.Provider

open class GradleVersionExtension(
    project: Project
) {
    /*val code: Provider<Int> = project.providers.provider {
        runGit("rev-list --count HEAD").toIntOrNull() ?: 1
    }

    val name: Provider<String> = project.providers.provider {
        val tag = runGit("describe --tags --abbrev=0", ignoreError = true)
        val branch = runGit("rev-parse --abbrev-ref HEAD", ignoreError = true)

        if (tag.isNotEmpty()) {
            if (branch == "HEAD") tag else "$tag-SNAPSHOT"
        } else {
            "0.1.0-SNAPSHOT"
        }
    }*/

    val code: Int = 100
    val name: String = "1.0.0-SNAPSHOT"

    private fun runGit(command: String, ignoreError: Boolean = false): String {
        return try {
            val process = ProcessBuilder("git", *command.split(" ").toTypedArray())
                .directory(java.io.File(System.getProperty("user.dir")))
                .redirectErrorStream(true)
                .start()
            val text = process.inputStream.bufferedReader().readText().trim()
            process.waitFor()
            if (process.exitValue() != 0 && !ignoreError) "" else text
        } catch (e: Exception) {
            ""
        }
    }
}

class GradleVersionPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        // register extension
        val ext = project.extensions.create(
            "gradleVersion",
            GradleVersionExtension::class.java,
            project
        )

        // Log lazily (when values are computed)
        project.logger.lifecycle("GradleVersion plugin registered")
        project.afterEvaluate {
            project.logger.lifecycle("GradleVersion: code=${ext.code}, name=${ext.name}")
        }
    }
}