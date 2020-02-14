package com.wiedii.myapplication.localrepo

import com.wiedii.myapplication.classes.Heroes
import com.wiedii.myapplication.localrepo.repositori.HeroeDAO
import io.reactivex.Completable
import io.reactivex.Flowable

class HeroeRepositoryImpl(private val heroeDAO: HeroeDAO): HeroeRepository {
    override fun getHeroes(): Flowable<List<Heroes>> = heroeDAO.getAllHeroes()

    override fun insertHeroe(heroe: Heroes): Completable = heroeDAO.insertHeroe(heroe)

    override fun deleteHeroe(idheroe : Int): Completable = heroeDAO.deleteHeroe(idheroe)

}