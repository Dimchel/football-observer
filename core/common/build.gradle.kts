plugins {
    alias(libs.plugins.fa.feature.module)
}

android {
    namespace = "com.dimchel.fa.core.common"
}

dependencies {
    api(libs.google.dagger)
    api(libs.kotlinx.coroutines.core)
    api(libs.kotlinx.coroutines.android)
}