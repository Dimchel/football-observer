plugins {
    alias(libs.plugins.fa.feature.module)
}

android {
    namespace = "com.dimchel.fa.core.navigation"
}

dependencies {
    api(libs.android.material)
}