import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "com.dimchel.fa.build_logic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    compileOnly(libs.android.gradle.plugin)
    compileOnly(libs.kotlin.gradle.plugin)
}

gradlePlugin {
    plugins {
        register("kotlin-module") {
            id = "kotlin-module"
            implementationClass = "com.dimchel.fa.build_logic.convention.KotlinModulePlugin"
        }
        register("feature-module") {
            id = "feature-module"
            implementationClass = "com.dimchel.fa.build_logic.convention.FeatureModulePlugin"
        }
        register("compose-module") {
            id = "compose-module"
            implementationClass = "com.dimchel.fa.build_logic.convention.ComposeModulePlugin"
        }
    }
}
