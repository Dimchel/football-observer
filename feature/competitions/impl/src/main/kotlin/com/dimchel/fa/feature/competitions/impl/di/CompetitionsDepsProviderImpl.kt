package com.dimchel.fa.feature.competitions.impl.di

import android.app.Application
import com.dimchel.core.data.di.CoreDataDependencyProvider
import com.dimchel.fa.core.common.di.BaseDepsProviderImpl
import com.dimchel.fa.core.network.di.CoreNetworkDependencyProvider
import com.dimchel.fa.feature.competitions.api.CompetitionsDepsProvider
import com.dimchel.fa.feature.competitions.api.CompetitionsOutDeps
import com.dimchel.fa.feature.league.api.LeagueFeatureProvider

object CompetitionsDepsProviderImpl :
    BaseDepsProviderImpl<CompetitionsOutDeps>(), CompetitionsDepsProvider {

    override fun createDependency(application: Application): CompetitionsOutDeps =
        DaggerCompetitionsComponent.factory().create(
            application,
            CoreNetworkDependencyProvider.provide(application),
            CoreDataDependencyProvider.provide(application),
            (application as LeagueFeatureProvider).getLeagueDepsProvider().provide(application),
        )
}