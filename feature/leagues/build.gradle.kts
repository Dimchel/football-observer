plugins {
    alias(libs.plugins.fa.feature.module)
}

android {
    namespace = "com.dimchel.fa.feature.leagues"
}

dependencies {
    implementation(libs.androidx.fragment.ktx)
}