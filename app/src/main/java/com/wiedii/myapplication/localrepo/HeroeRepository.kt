package com.wiedii.myapplication.localrepo

import com.wiedii.myapplication.classes.Heroes
import io.reactivex.Completable
import io.reactivex.Flowable

interface HeroeRepository {

    fun getHeroes(): Flowable<List<Heroes>>

    fun insertHeroe(heroe: Heroes): Completable

    fun deleteHeroe(idheroe: Int): Completable

    fun updateHeroe(heroe: Heroes): Completable

}
