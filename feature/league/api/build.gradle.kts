plugins {
    alias(libs.plugins.fa.feature.module)
    alias(libs.plugins.fa.compose.module)
    id("com.google.devtools.ksp")
    id("kotlinx-serialization")
}

android {
    namespace = "com.dimchel.fa.feature.league.api"
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:data"))
    implementation(project(":core:ui"))
    implementation(project(":core:network"))

    ksp(libs.google.dagger.compiler)
}