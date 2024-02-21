package com.dimchel.fa.league.di

import android.app.Application
import com.dimchel.fa.core.common.di.BaseDependencyProviderParametrizedImpl
import com.dimchel.fa.core.common.di.DependencyStartParams
import com.dimchel.fa.core.network.di.CoreNetworkDependencyProvider

class LeagueStartParams(val leagueId: String) : DependencyStartParams

internal object LeagueDependencyProvider :
    BaseDependencyProviderParametrizedImpl<LeagueComponent, LeagueStartParams>() {

    override fun createDependency(
        application: Application,
        startParams: LeagueStartParams
    ): LeagueComponent =
        DaggerLeagueComponent.factory().create(
            application = application,
            leagueStartParams = startParams,
            coreNetworkDependency = CoreNetworkDependencyProvider.provide(application),
        )
}