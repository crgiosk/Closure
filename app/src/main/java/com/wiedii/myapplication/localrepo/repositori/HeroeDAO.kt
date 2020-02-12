package com.wiedii.myapplication.localrepo.repositori

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.wiedii.myapplication.classes.Heroes
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
interface HeroeDAO {

    @Query("SELECT * FROM heroes")
    fun getAllHeroes(): Flowable<List<Heroes>>

    @Insert
    fun insertHeroe(heroe: Heroes): Completable
}