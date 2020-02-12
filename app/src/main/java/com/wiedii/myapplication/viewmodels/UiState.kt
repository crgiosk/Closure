package com.wiedii.myapplication.viewmodels

//controlador class
sealed class UiState {
    object Loading: UiState()
    class OnSuccess<T> (val data: T): UiState()
    class OnError(val message: String): UiState()
}