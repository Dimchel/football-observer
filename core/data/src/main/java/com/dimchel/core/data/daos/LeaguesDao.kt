package com.dimchel.core.data.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dimchel.core.data.entities.CompetitorEntity
import com.dimchel.core.data.entities.LeagueEntity


@Dao
interface LeaguesDao {

    @Query("SELECT * FROM competitions WHERE code = :code")
    suspend fun getLeague(code: String): LeagueEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCompetitors(competitors: List<CompetitorEntity>)

}