package com.dimchel.fa.build_logic.convention

import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class ComposeModulePlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("com.android.library")

            val extension = extensions.getByType<LibraryExtension>()
            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

            extension.apply {
                buildFeatures {
                    compose = true
                }
                dependencies {
                    add("implementation", platform(libs.findLibrary("androidx-compose-bom").get()))
                }
            }
        }
    }
}