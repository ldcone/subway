package com.example.myapplication.data.repository

import com.example.myapplication.domain.Station
import kotlinx.coroutines.flow.Flow

interface StationRepository {

    val station: Flow<List<Station>>

    suspend fun refreshStations()
}