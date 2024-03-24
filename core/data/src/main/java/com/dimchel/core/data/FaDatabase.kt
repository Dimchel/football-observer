package com.dimchel.core.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dimchel.core.data.daos.CompetitionsDao
import com.dimchel.core.data.daos.LeaguesDao
import com.dimchel.core.data.entities.CompetitionEntity
import com.dimchel.core.data.entities.CompetitorEntity

@Database(
    entities = [
        CompetitionEntity::class,
        CompetitorEntity::class,
    ],
    version = 3,
    exportSchema = false,
)
abstract class FaDatabase : RoomDatabase() {
    abstract fun competitionsDao() : CompetitionsDao
    abstract fun leaguesDao() : LeaguesDao
}