package com.example.myapplication.data.db.entity

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.data.db.entity.mapper.StationEntity
import com.example.myapplication.data.db.entity.mapper.StationSubwayCrossRefEntity
import com.example.myapplication.data.db.entity.mapper.SubwayEntity

@Database(
    entities = [StationEntity::class, SubwayEntity::class, StationSubwayCrossRefEntity::class],
    version = 1,
)
abstract class AppDatabase:RoomDatabase() {
    abstract fun stationDao(): StationDao
    companion object{
        private const val DATABASE_NAME = "station.db"

        fun build(context:Context):AppDatabase =
            Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME).build()
    }
}