package com.dimchel.fa.feature.competitions.di

import android.app.Application
import cafe.adriel.voyager.navigator.Navigator
import com.dimchel.fa.core.common.di.BaseDependencyProviderParametrizedImpl
import com.dimchel.fa.core.common.di.DependencyStartParams
import com.dimchel.fa.core.network.di.CoreNetworkDependencyProvider

internal class CompetitionsStartParams(val navigator: Navigator) : DependencyStartParams

internal object CompetitionsDependencyProvider :
    BaseDependencyProviderParametrizedImpl<CompetitionsComponent, CompetitionsStartParams>() {

    override fun createDependency(
        application: Application,
        startParams: CompetitionsStartParams
    ): CompetitionsComponent =
        DaggerCompetitionsComponent.factory().create(
            application,
            startParams.navigator,
            CoreNetworkDependencyProvider.provide(application),
        )
}