package com.dimchel.core.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dimchel.core.data.daos.CompetitionsDao
import com.dimchel.core.data.entities.CompetitionEntity

@Database(entities = [CompetitionEntity::class], version = 1)
abstract class FaDatabase : RoomDatabase() {
    abstract fun competitionsDao() : CompetitionsDao
}