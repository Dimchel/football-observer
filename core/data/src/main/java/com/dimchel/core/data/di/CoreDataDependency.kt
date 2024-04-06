package com.dimchel.core.data.di

import com.dimchel.core.data.daos.CompetitionsDao
import com.dimchel.core.data.daos.LeaguesDao
import com.dimchel.fa.core.common.di.OutDeps

interface CoreDataDependency : OutDeps {
    fun provideCompetitionsDao(): CompetitionsDao
    fun provideLeaguesDao(): LeaguesDao
}