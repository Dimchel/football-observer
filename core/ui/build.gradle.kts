plugins {
    alias(libs.plugins.fa.feature.module)
}

android {
    namespace = "com.dimchel.fa.core.ui"
}

dependencies {
    api(platform("androidx.compose:compose-bom:2024.02.00"))

    api(libs.androidx.fragment.ktx)
    api(libs.androidx.compose.material3)
    api(libs.androidx.navigation.compose)
    api(libs.android.material)
}