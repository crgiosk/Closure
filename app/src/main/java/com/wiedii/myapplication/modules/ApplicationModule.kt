package com.wiedii.myapplication.modules

import androidx.room.Room
import androidx.room.RoomDatabase
import com.wiedii.myapplication.localrepo.HeroeRepository
import com.wiedii.myapplication.localrepo.HeroeRepositoryImpl
import com.wiedii.myapplication.localrepo.repositori.HeroesDataBase
import com.wiedii.myapplication.viewmodels.HeroeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val applicationModule = module {
    single {
        Room.databaseBuilder(
            get(),HeroesDataBase::class.java, "heroes_database"
        ).build()
    }

    single {
        get<HeroesDataBase>().newInstance()
    }

    factory <HeroeRepository> {
        HeroeRepositoryImpl(get())
    }

    viewModel {
        HeroeViewModel(get())
    }

}