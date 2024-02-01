plugins {
    alias(libs.plugins.fa.feature.module)

    id("com.google.devtools.ksp")
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