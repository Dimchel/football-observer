package com.dimchel.fa.feature.competitions.impl.di

import cafe.adriel.voyager.core.screen.Screen
import com.dimchel.fa.feature.competitions.api.CompetitionsScreenProvider
import dagger.Lazy
import javax.inject.Inject

internal class CompetitionsScreenProviderImpl @Inject constructor(
    private val leagueScreen: Lazy<Screen>,
) : CompetitionsScreenProvider {

    override fun getCompetitionsScreen(): Screen {
        return leagueScreen.get()
    }
}