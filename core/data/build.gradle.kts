plugins {
    alias(libs.plugins.fa.feature.module)
    alias(libs.plugins.ksp)
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