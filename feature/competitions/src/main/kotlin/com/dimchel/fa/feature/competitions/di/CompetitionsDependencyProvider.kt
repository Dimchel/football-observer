package com.dimchel.fa.feature.competitions.di

import android.app.Application
import com.dimchel.fa.core.common.di.BaseDependencyProviderImpl
import com.dimchel.fa.core.network.di.CoreNetworkDependencyProvider

internal object CompetitionsDependencyProvider :
    BaseDependencyProviderImpl<CompetitionsComponent>() {

    override fun createDependency(application: Application): CompetitionsComponent =
        DaggerCompetitionsComponent.factory().create(
            application,
            CoreNetworkDependencyProvider.provide(application),
        )
}