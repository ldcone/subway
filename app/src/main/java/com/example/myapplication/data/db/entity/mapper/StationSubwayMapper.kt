package com.example.myapplication.data.db.entity.mapper

import com.example.myapplication.data.db.entity.StationWithSubwaysEntity
import com.example.myapplication.data.db.entity.SubwayEntity
import com.example.myapplication.domain.Station
import com.example.myapplication.domain.Subway

fun StationWithSubwaysEntity.toStation() = Station(
    name = station.stationName,
    isFavorite = station.isFavorite,
    connectedSubways = subways.toSubways()
)

fun List<StationWithSubwaysEntity>.toStations() = map{ it.toStation()}

fun List<SubwayEntity>.toSubways(): List<Subway> =map{ Subway.findById(it.subwayId)}