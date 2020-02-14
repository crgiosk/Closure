package com.wiedii.myapplication.localrepo.repositori

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.wiedii.myapplication.classes.Heroes
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
interface HeroeDAO {

    @Query("SELECT * FROM heroes ORDER BY id DESC")
    fun getAllHeroes(): Flowable<List<Heroes>>

    @Insert
    fun insertHeroe(heroe: Heroes): Completable

    @Query("DELETE FROM heroes WHERE id = :idheroe")
    fun deleteHeroe(idheroe : Int):Completable




}

//  @Query("DELETE FROM heroes WHERE id = :idheroe")
//    fun deleteHeroe(idheroe: Heroes):