package com.dimchel.fa.feature.league.api

import com.dimchel.fa.feature.league.api.di.LeagueDepsProvider

interface LeagueFeatureProvider {
    fun getLeagueDepsProvider(): LeagueDepsProvider
}