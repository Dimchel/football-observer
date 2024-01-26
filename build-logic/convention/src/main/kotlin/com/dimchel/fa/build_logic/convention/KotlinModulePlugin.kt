package com.dimchel.fa.build_logic.convention

import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

class KotlinModulePlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("java-library")
                apply("kotlin")
            }
            configure<JavaPluginExtension> {
                sourceCompatibility = JavaVersion.VERSION_18
                targetCompatibility = JavaVersion.VERSION_18
            }
            tasks.withType<KotlinCompile>().configureEach {
                kotlinOptions {
                    jvmTarget = JavaVersion.VERSION_18.toString()
                }
            }
        }
    }
}
