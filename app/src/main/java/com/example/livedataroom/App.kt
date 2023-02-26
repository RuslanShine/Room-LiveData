package com.example.livedataroom

import android.app.Application
import androidx.room.Room

class App: Application() {
    lateinit var stringEntityDAO: StringEntityDAO

    override fun onCreate() {
        super.onCreate()
        instanse = this

        val db = Room.databaseBuilder(this,AppDatabase::class.java,"string_DB").build()
        stringEntityDAO = db.stringEntityDao()
    }

    companion object{
        lateinit var instanse:App
        private set
    }
}