package com.example.myapplication.data.api

import com.example.myapplication.data.db.entity.StationEntity
import com.example.myapplication.data.db.entity.SubwayEntity

interface StationApi {
    suspend fun getStationDataUpdatedTimeMillis():Long
    suspend fun getStationSubways(): List<Pair<StationEntity, SubwayEntity>>
}