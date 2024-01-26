plugins {
    alias(libs.plugins.fa.feature.module)
}

android {
    namespace = "com.dimchel.fa.feature.leagues"
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:ui"))
}