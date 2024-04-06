package com.dimchel.fa.feature.league.impl.di

import cafe.adriel.voyager.core.screen.Screen
import com.dimchel.fa.feature.league.api.presentation.LeagueScreenProvider
import com.dimchel.fa.feature.league.api.presentation.LeagueScreenStartParams
import dagger.Lazy
import javax.inject.Inject

internal class LeagueScreenProviderImpl @Inject constructor(
    private val startParamsHolder: StartParamsHolder,
    private val leagueScreen: Lazy<Screen>,
) : LeagueScreenProvider {

    override fun getLeagueScreen(leagueStartParams: LeagueScreenStartParams): Screen {
        startParamsHolder.leagueStartParams = leagueStartParams
        return leagueScreen.get()
    }
}