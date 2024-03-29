package com.dimchel.fa.league.di

import android.app.Application
import com.dimchel.core.data.di.CoreDataDependency
import com.dimchel.fa.core.common.di.Dependencies
import com.dimchel.fa.core.common.di.FeatureScope
import com.dimchel.fa.core.network.di.CoreNetworkDependency
import com.dimchel.fa.league.data.api.LeagueApiService
import com.dimchel.fa.league.data.repositories.LeagueRepository
import com.dimchel.fa.league.data.repositories.LeagueRepositoryImpl
import com.dimchel.fa.league.presentation.LeagueViewModel
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@FeatureScope
@Component(
    modules = [LeagueModule::class],
    dependencies = [
        CoreNetworkDependency::class,
        CoreDataDependency::class,
    ]
)
internal interface LeagueComponent : Dependencies {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: Application,
            @BindsInstance leagueStartParams: LeagueStartParams,
            coreNetworkDependency: CoreNetworkDependency,
            coreDataDependency: CoreDataDependency,
        ): LeagueComponent
    }

    fun getViewModel(): LeagueViewModel
}

@Module
internal abstract class LeagueModule {

    companion object {

        @FeatureScope
        @Provides
        fun provideLeaguesApiService(retrofit: Retrofit): LeagueApiService =
            retrofit.create(LeagueApiService::class.java)
    }

    @FeatureScope
    @Binds
    abstract fun provideLeaguesRepository(
        leagueRepository: LeagueRepositoryImpl
    ): LeagueRepository
}
