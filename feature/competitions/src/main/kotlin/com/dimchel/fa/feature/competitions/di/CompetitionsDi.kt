package com.dimchel.fa.feature.competitions.di

import android.app.Application
import com.dimchel.fa.core.common.di.FeatureScope
import com.dimchel.fa.core.network.di.CoreNetworkDependency
import com.dimchel.fa.feature.competitions.data.api.CompetitionsApiService
import com.dimchel.fa.feature.competitions.data.repositories.CompetitionsRepository
import com.dimchel.fa.feature.competitions.data.repositories.CompetitionsRepositoryImpl
import com.dimchel.fa.feature.competitions.presentation.CompetitionsViewModel
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@FeatureScope
@Component(
    modules = [CompetitionsModule::class],
    dependencies = [CoreNetworkDependency::class]
)
internal interface CompetitionsComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: Application,
            coreNetworkDependency: CoreNetworkDependency,
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
}
