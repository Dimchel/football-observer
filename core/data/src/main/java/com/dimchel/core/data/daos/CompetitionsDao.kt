package com.dimchel.core.data.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.dimchel.core.data.entities.CompetitionEntity

@Dao
interface CompetitionsDao {

    @Query("SELECT * FROM competitions")
    suspend fun getAll(): List<CompetitionEntity>

    @Insert
    suspend fun insertAll(competitions: List<CompetitionEntity>)

    @Query("DELETE FROM competitions")
    suspend fun deleteAll()
}