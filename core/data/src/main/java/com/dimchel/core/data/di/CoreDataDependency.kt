package com.dimchel.core.data.di

import com.dimchel.core.data.daos.CompetitionsDao
import com.dimchel.fa.core.common.di.Dependencies

interface CoreDataDependency : Dependencies {
    fun provideCompetitionsDao(): CompetitionsDao
}