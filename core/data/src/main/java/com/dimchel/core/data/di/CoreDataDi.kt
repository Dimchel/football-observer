package com.dimchel.core.data.di

import android.app.Application
import androidx.room.Room
import com.dimchel.core.data.FA_DATABASE_NAME
import com.dimchel.core.data.FaDatabase
import com.dimchel.core.data.daos.CompetitionsDao
import com.dimchel.fa.core.common.di.AppScope
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides

@AppScope
@Component(modules = [DataModule::class])
internal interface CoreDataComponent : CoreDataDependency {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: Application,
        ): CoreDataComponent
    }
}

@Module
internal class DataModule {

    companion object {
        @AppScope
        @Provides
        fun provideFaDatabase(application: Application): FaDatabase =
            Room.databaseBuilder(
                context = application,
                klass = FaDatabase::class.java,
                name = FA_DATABASE_NAME,
            ).build()

        @AppScope
        @Provides
        fun provideCompetitionsDao(faDatabase: FaDatabase): CompetitionsDao =
            faDatabase.competitionsDao()
    }
}
