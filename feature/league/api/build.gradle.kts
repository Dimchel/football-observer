plugins {
    alias(libs.plugins.fa.feature.module)
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.dimchel.fa.feature.league.api"
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:ui"))

    ksp(libs.google.dagger.compiler)
}