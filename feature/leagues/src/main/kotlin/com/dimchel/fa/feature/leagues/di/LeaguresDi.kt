package com.dimchel.fa.feature.leagues.di

import android.app.Application
import com.dimchel.fa.core.common.di.FeatureScope
import com.dimchel.fa.core.network.di.CoreNetworkDependency
import com.dimchel.fa.feature.leagues.data.api.LeaguesApiService
import com.dimchel.fa.feature.leagues.data.repositories.LeaguesRepository
import com.dimchel.fa.feature.leagues.data.repositories.LeaguesRepositoryImpl
import com.dimchel.fa.feature.leagues.ui.LeaguesFragment
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@FeatureScope
@Component(
    modules = [LeaguesModule::class],
    dependencies = [CoreNetworkDependency::class]
)
internal interface LeaguesComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: Application,
            coreNetworkDependency: CoreNetworkDependency,
        ): LeaguesComponent
    }

    fun inject(fragment: LeaguesFragment)
}

@Module
internal abstract class LeaguesModule {

    companion object {

        @FeatureScope
        @Provides
        fun provideLeaguesApiService(retrofit: Retrofit): LeaguesApiService =
            retrofit.create(LeaguesApiService::class.java)
    }

    @FeatureScope
    @Binds
    abstract fun provideLeaguesRepository(
        leaguesRepository: LeaguesRepositoryImpl
    ): LeaguesRepository
}
