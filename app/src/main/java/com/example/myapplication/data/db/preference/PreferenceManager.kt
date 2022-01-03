package com.example.myapplication.data.db.preference

interface PreferenceManager {
    fun getLong(key:String):Long?
    fun putLong(key:String, value:Long)
}