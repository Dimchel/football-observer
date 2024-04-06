package com.dimchel.fa.feature.league.impl.di

import android.app.Application
import cafe.adriel.voyager.core.screen.Screen
import com.dimchel.core.data.di.CoreDataDependency
import com.dimchel.fa.core.common.di.FeatureScope
import com.dimchel.fa.core.network.di.CoreNetworkDependency
import com.dimchel.fa.feature.league.api.di.LeagueOutDeps
import com.dimchel.fa.feature.league.api.presentation.LeagueScreenProvider
import com.dimchel.fa.feature.league.impl.data.api.LeagueApiService
import com.dimchel.fa.feature.league.impl.data.repositories.LeagueRepository
import com.dimchel.fa.feature.league.impl.data.repositories.LeagueRepositoryImpl
import com.dimchel.fa.feature.league.impl.presentation.LeagueScreen
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
internal interface LeagueComponent : LeagueOutDeps {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: Application,
            coreNetworkDependency: CoreNetworkDependency,
            coreDataDependency: CoreDataDependency,
        ): LeagueComponent
    }
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
        repository: LeagueRepositoryImpl
    ): LeagueRepository

    @Binds
    abstract fun provideLeagueScreen(screen: LeagueScreen): Screen

    @Binds
    abstract fun provideLeagueScreenProvider(
        provider: LeagueScreenProviderImpl
    ): LeagueScreenProvider
}
