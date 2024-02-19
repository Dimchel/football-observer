package com.dimchel.fa.league.di

import android.app.Application
import com.dimchel.fa.core.common.di.BaseDependencyProviderImpl
import com.dimchel.fa.core.network.di.CoreNetworkDependencyProvider

internal object LeagueDependencyProvider : BaseDependencyProviderImpl<LeagueComponent>() {

    override fun createDependency(application: Application): LeagueComponent =
        DaggerLeagueComponent.factory().create(
            application,
            CoreNetworkDependencyProvider.provide(application),
        )
}