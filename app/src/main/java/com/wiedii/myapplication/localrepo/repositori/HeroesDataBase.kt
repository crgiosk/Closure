package com.wiedii.myapplication.localrepo.repositori

import androidx.room.Database
import androidx.room.RoomDatabase
import com.wiedii.myapplication.classes.Heroes

@Database(entities = [Heroes::class],version = 1,exportSchema = false)
abstract class HeroesDataBase: RoomDatabase() {
    abstract fun newInstance(): HeroeDAO
}