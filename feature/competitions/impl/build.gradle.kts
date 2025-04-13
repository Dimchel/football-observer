plugins {
    alias(libs.plugins.fa.feature.module)
    alias(libs.plugins.fa.compose.module)
    alias(libs.plugins.compose.compiler)
    id("com.google.devtools.ksp")
    id("kotlinx-serialization")
}

android {
    namespace = "com.dimchel.fa.feature.competitions.impl"
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:data"))
    implementation(project(":core:ui"))
    implementation(project(":core:network"))
    implementation(project(":feature:competitions:api"))
    implementation(project(":feature:league:api"))

    ksp(libs.google.dagger.compiler)
}