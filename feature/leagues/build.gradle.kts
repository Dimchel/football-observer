plugins {
    alias(libs.plugins.fa.feature.module)
    id("com.google.devtools.ksp")
    id("kotlinx-serialization")
}

android {
    namespace = "com.dimchel.fa.feature.leagues"
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:ui"))
    implementation(project(":core:network"))

    ksp(libs.google.dagger.compiler)
}