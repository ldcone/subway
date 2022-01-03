package com.example.myapplication.domain

data class Station (
    val name :String,
    val isFavorite:Boolean,
    val connectedSubways:List<Subway>
        )