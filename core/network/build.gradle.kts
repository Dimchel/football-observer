plugins {
    alias(libs.plugins.fa.feature.module)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.dimchel.fa.core.network"
}

dependencies {
    implementation(project(":core:common"))

    api(libs.squareup.retrofit)
    api(libs.kotlinx.serialization.json)
    implementation(libs.kotlinx.serialization.core)
    implementation(libs.kotlinx.serialization.converter)
    implementation(libs.squareup.okhttp.logging)

    ksp(libs.google.dagger.compiler)
}