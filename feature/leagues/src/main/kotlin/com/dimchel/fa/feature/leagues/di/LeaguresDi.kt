package com.dimchel.fa.feature.leagues.di

import android.app.Application
import com.dimchel.fa.core.common.di.AppScope
import com.dimchel.fa.core.network.di.CoreNetworkDependency
import dagger.BindsInstance
import dagger.Component
import dagger.Module

@AppScope
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
}

@Module
internal abstract class LeaguesModule {

}
