package com.dimchel.fa.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.Navigator
import com.dimchel.fa.feature.competitions.impl.di.CompetitionsDepsProviderImpl

class MainActivity : ComponentActivity() {

    private val competitionsScreen: Screen by lazy {
        CompetitionsDepsProviderImpl.provide(application)
            .getCompetitionsScreenProvider()
            .getCompetitionsScreen()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            Navigator(competitionsScreen) {
                AppContent()
            }
        }
    }
}