package com.dimchel.fa.feature.competitions.impl.di

import android.app.Application
import cafe.adriel.voyager.core.screen.Screen
import com.dimchel.core.data.di.CoreDataDependency
import com.dimchel.fa.core.common.di.FeatureScope
import com.dimchel.fa.core.network.di.CoreNetworkDependency
import com.dimchel.fa.feature.competitions.api.CompetitionsOutDeps
import com.dimchel.fa.feature.competitions.api.CompetitionsScreenProvider
import com.dimchel.fa.feature.competitions.impl.CompetitionsScreen
import com.dimchel.fa.feature.competitions.impl.data.api.CompetitionsApiService
import com.dimchel.fa.feature.competitions.impl.data.repositories.CompetitionsRepository
import com.dimchel.fa.feature.competitions.impl.data.repositories.CompetitionsRepositoryImpl
import com.dimchel.fa.feature.competitions.impl.presentation.CompetitionsViewModel
import com.dimchel.fa.feature.league.api.di.LeagueOutDeps
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@FeatureScope
@Component(
    modules = [CompetitionsModule::class],
    dependencies = [
        CoreNetworkDependency::class,
        CoreDataDependency::class,
        LeagueOutDeps::class,
    ]
)
internal interface CompetitionsComponent : CompetitionsOutDeps {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: Application,
            coreNetworkDependency: CoreNetworkDependency,
            coreDataDependency: CoreDataDependency,
            leagueOutDeps: LeagueOutDeps,
        ): CompetitionsComponent
    }

    fun getViewModel(): CompetitionsViewModel
}

@Module
internal abstract class CompetitionsModule {

    companion object {

        @FeatureScope
        @Provides
        fun provideCompetitionsApiService(retrofit: Retrofit): CompetitionsApiService =
            retrofit.create(CompetitionsApiService::class.java)
    }

    @FeatureScope
    @Binds
    abstract fun provideCompetitionsRepository(
        competitionsRepository: CompetitionsRepositoryImpl
    ): CompetitionsRepository

    @Binds
    abstract fun provideCompetitionsScreen(
        competitionsScreen: CompetitionsScreen
    ): Screen

    @Binds
    abstract fun provideCompetitionsScreenProvider(
        competitionsScreenProvider: CompetitionsScreenProviderImpl
    ): CompetitionsScreenProvider
}
