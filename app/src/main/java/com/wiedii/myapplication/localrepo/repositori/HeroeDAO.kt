package com.wiedii.myapplication.localrepo.repositori

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.wiedii.myapplication.classes.Heroes
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
interface HeroeDAO {

    @Query("SELECT * FROM heroes ORDER BY id DESC")
    fun getAllHeroes(): Flowable<List<Heroes>>

    @Insert
    fun insertHeroe(heroe: Heroes): Completable

    @Update
    fun updateHeroe(heroe: Heroes): Completable
}