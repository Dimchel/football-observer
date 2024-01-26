package com.dimchel.fa.build_logic.convention

import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

class FeatureModulePlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("kotlin-android")
            }
            configure<LibraryExtension> {
                compileSdk = BuildConst.COMPILE_SDK
                defaultConfig {
                    minSdk = BuildConst.MIN_SDK

                    consumerProguardFiles("consumer-rules.pro")

                    javaCompileOptions {
                        annotationProcessorOptions {
                            argument("dagger.strictSuperficialValidation", "DISABLED")
                        }
                    }
                }
                compileOptions {
                    sourceCompatibility = JavaVersion.VERSION_17
                    targetCompatibility = JavaVersion.VERSION_17
                }
                tasks.withType<KotlinCompile>().configureEach {
                    kotlinOptions {
                        jvmTarget = JavaVersion.VERSION_17.toString()
                    }
                }
            }
        }
    }
}
