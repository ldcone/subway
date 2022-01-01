package com.example.myapplication.data.db.entity.mapper

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class StationEntity (
    @PrimaryKey val stationName: String,
    val isFavorite:Boolean = false
        )