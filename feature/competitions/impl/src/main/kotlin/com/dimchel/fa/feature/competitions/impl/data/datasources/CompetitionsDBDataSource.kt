package com.dimchel.fa.feature.competitions.impl.data.datasources

import com.dimchel.core.data.daos.CompetitionsDao
import com.dimchel.core.data.entities.CompetitionEntity
import javax.inject.Inject

internal class CompetitionsDBDataSource @Inject constructor(
    private val dao: CompetitionsDao,
) {
    suspend fun getAll(): List<CompetitionEntity> = dao.getAll()

    suspend fun updateAll(competitions: List<CompetitionEntity>) {
        dao.deleteAll()
        dao.insertAll(competitions)
    }
}