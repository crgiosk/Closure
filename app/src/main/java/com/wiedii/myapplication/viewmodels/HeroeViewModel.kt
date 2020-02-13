package com.wiedii.myapplication.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wiedii.myapplication.classes.Heroes
import com.wiedii.myapplication.localrepo.HeroeRepository
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class HeroeViewModel(private val heroeRepository: HeroeRepository) : ViewModel() {

    private val getHeroesMutableLiveData: MutableLiveData<UiState> = MutableLiveData()

    private val saveHeroeMutableLiveData: MutableLiveData<UiState> = MutableLiveData()

    private val updateHeroeMutableLiveData: MutableLiveData<UiState> = MutableLiveData()

    private val subscriptor = CompositeDisposable()

    fun getHeroesLiveData(): LiveData<UiState> = getHeroesMutableLiveData
    fun saveHeroesLiveData(): LiveData<UiState> = saveHeroeMutableLiveData


    fun getHeroes() {
        subscriptor.add(
            heroeRepository.getHeroes()
                .doOnSubscribe {
                    getHeroesMutableLiveData.postValue(UiState.Loading)
                }.subscribeOn(Schedulers.io())
                .subscribeBy(
                    onNext = {
                        getHeroesMutableLiveData.postValue(UiState.OnSuccess(it))
                    },
                    onError = {
                        getHeroesMutableLiveData.postValue(
                            UiState.OnError(
                                it.message ?: "Error inesperado"
                            )
                        )
                    },
                    onComplete = {

                    }
                )
        )
    }

    fun saveHeroe(heroe: Heroes) {
        subscriptor.add(
            heroeRepository.insertHeroe(
                Heroes(
                    nombre = heroe.nombre,
                    tipo = heroe.tipo,
                    categoria = heroe.categoria,
                    descripcion = heroe.descripcion,
                    imageUrl = heroe.imageUrl
                )
            ).doOnSubscribe {
                saveHeroeMutableLiveData.postValue(UiState.Loading)
            }.subscribeOn(Schedulers.io())
                .subscribeBy(
                    onComplete = {
                        saveHeroeMutableLiveData.postValue(UiState.OnSuccess(true))
                    },
                    onError = {
                        saveHeroeMutableLiveData.postValue(
                            UiState.OnError(
                                it.message ?: "Error inesperado"
                            )
                        )
                    }
                )
        )
    }

    fun updateHero(heroe: Heroes) {
        subscriptor.add(
            heroeRepository.updateHeroe(
                Heroes(
                    id = heroe.id,
                    nombre = heroe.nombre,
                    tipo = heroe.tipo,
                    categoria = heroe.categoria,
                    descripcion = heroe.descripcion,
                    imageUrl = heroe.imageUrl
                )
            ).doOnSubscribe {
                updateHeroeMutableLiveData.postValue(UiState.Loading)
            }.subscribeOn(Schedulers.io())
                .subscribeBy(
                    onComplete = {
                        updateHeroeMutableLiveData.postValue(UiState.OnSuccess(true))
                    },
                    onError = {
                        updateHeroeMutableLiveData.postValue(UiState.OnError("Error inesperado ${it.message}"))
                    }
                )
        )
    }

}