package com.dimchel.fa.feature.leagues.di

import android.app.Application
import com.dimchel.fa.core.common.di.BaseDependencyProviderImpl
import com.dimchel.fa.core.network.di.CoreNetworkDependencyProvider

internal object LeaguesDependencyProvider : BaseDependencyProviderImpl<LeaguesComponent>() {

    override fun createDependency(application: Application): LeaguesComponent =
        DaggerLeaguesComponent.factory().create(
            application,
            CoreNetworkDependencyProvider.provide(application),
        )
}