package com.dimchel.fa.feature.league.impl.di

import android.app.Application
import com.dimchel.core.data.di.CoreDataDependencyProvider
import com.dimchel.fa.core.common.di.BaseDependencyProviderParametrizedImpl
import com.dimchel.fa.core.common.di.DependencyStartParams
import com.dimchel.fa.core.network.di.CoreNetworkDependencyProvider

class LeagueStartParams(val leagueCode: String) : DependencyStartParams

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
            coreDataDependency = CoreDataDependencyProvider.provide(application),
        )
}