plugins {
    alias(libs.plugins.fa.feature.module)
    alias(libs.plugins.fa.compose.module)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "com.dimchel.fa.core.ui"
}

dependencies {
    api(libs.androidx.compose.material)
    api(libs.androidx.compose.material3)
    api(libs.androidx.compose.ui.tooling)
    api(libs.androidx.navigation.compose)
    api(libs.androidx.lifecycle.compose)
    api(libs.android.material)
    api(libs.coil.compose)
    api(libs.coil.svg)
    api(libs.cafeadriel.voyager.navigator)
}