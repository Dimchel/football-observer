package com.dimchel.fa.feature.league.api.presentation

import cafe.adriel.voyager.core.screen.Screen

interface LeagueScreenProvider {
    fun getLeagueScreen(leagueStartParams: LeagueScreenStartParams): Screen
}