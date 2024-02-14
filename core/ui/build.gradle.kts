plugins {
    alias(libs.plugins.fa.feature.module)
    alias(libs.plugins.fa.compose.module)
}

android {
    namespace = "com.dimchel.fa.core.ui"
}

dependencies {
    api(libs.androidx.fragment.ktx)
    api(libs.androidx.compose.material3)
    api(libs.androidx.navigation.compose)
    api(libs.android.material)
}