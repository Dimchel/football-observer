package com.dimchel.fa.feature.competitions.api

import cafe.adriel.voyager.core.screen.Screen

interface CompetitionsScreenProvider {
    fun getCompetitionsScreen() : Screen
}