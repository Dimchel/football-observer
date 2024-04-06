package com.dimchel.fa.feature.league.api.di

import com.dimchel.fa.core.common.di.DepsProvider
import com.dimchel.fa.core.common.di.OutDeps
import com.dimchel.fa.feature.league.api.presentation.LeagueScreenProvider

interface LeagueOutDeps: OutDeps {
    fun getLeagueScreenProvider(): LeagueScreenProvider
}

interface LeagueDepsProvider : DepsProvider<LeagueOutDeps>