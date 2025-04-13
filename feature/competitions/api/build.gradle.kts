plugins {
    alias(libs.plugins.fa.feature.module)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.dimchel.fa.feature.competitions.api"
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:ui"))

    ksp(libs.google.dagger.compiler)
}