plugins {
    alias(libs.plugins.fa.feature.module)
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.dimchel.fa.core.data"
}

dependencies {
    implementation(project(":core:common"))

    api(libs.androidx.room.runtime)
    api(libs.androidx.room.ktx)

    ksp(libs.androidx.room.compiler)
    ksp(libs.google.dagger.compiler)
}