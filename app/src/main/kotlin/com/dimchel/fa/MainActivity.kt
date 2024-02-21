package com.dimchel.fa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.dimchel.fa.core.theme.FaTheme
import com.dimchel.fa.feature.competitions.CompetitionsNavigation

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            FaTheme(dynamicColor = true) {
                Surface(Modifier.fillMaxSize().padding()) {
                    CompetitionsNavigation.getScreen().Content()
                }
            }
        }
    }
}