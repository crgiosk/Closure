package com.wiedii.myapplication.classes

import java.io.Serializable

data class Heroes (
    var nombre: String = String(),
    var tipo: String = String(),
    var categoria: String = String(),
    var descripcion: String = String(),
    var imageUrl: String
): Serializable