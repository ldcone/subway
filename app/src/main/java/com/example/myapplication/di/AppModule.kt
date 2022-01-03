package com.example.myapplication.di

import android.app.Activity
import com.example.myapplication.data.api.StationApi
import com.example.myapplication.data.api.StationStorageApi
import com.example.myapplication.data.db.AppDatabase
import com.example.myapplication.data.preference.PreferenceManager
import com.example.myapplication.data.preference.SharedPreferenceManager
import com.example.myapplication.data.repository.StationRepository
import com.example.myapplication.data.repository.StationRepositoryImpl
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module{

    single{Dispatchers.IO}

    //Database
    single { AppDatabase.build(androidApplication()) }
    single { get<AppDatabase>().stationDao() }

    //Preference
    single { androidContext().getSharedPreferences("preference",Activity.MODE_PRIVATE) }
    single<PreferenceManager> { SharedPreferenceManager(get())  }

    //Api
    single<StationApi> { StationStorageApi(FirebaseStorage.getInstance())  }

    //Repository
    single<StationRepository> {StationRepositoryImpl(get(),get(),get(),get())  }

}