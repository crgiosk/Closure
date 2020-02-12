package com.wiedii.myapplication.classes

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "heroes")
data class Heroes (

    @PrimaryKey(autoGenerate = true)
    @field:ColumnInfo(name = "id")
    var id: Int = 0,

    @field:ColumnInfo(name = "nombre")
    var nombre: String = String(),

    @field:ColumnInfo(name = "tipo")
    var tipo: String = String(),

    @field:ColumnInfo(name = "categoria")
    var categoria: String = String(),

    @field:ColumnInfo(name = "descripcion")
    var descripcion: String = String(),

    @field:ColumnInfo(name = "imageUrl")
    var imageUrl: String
): Serializable