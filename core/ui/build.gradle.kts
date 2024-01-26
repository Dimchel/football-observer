plugins {
    alias(libs.plugins.fa.feature.module)
}

android {
    namespace = "com.dimchel.fa.core.ui"
}

dependencies {
    api(libs.androidx.fragment.ktx)
    api(libs.android.material)
}