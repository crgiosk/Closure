package com.wiedii.myapplication.view.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.wiedii.myapplication.R
import com.wiedii.myapplication.classes.Heroes
import kotlinx.android.synthetic.main.fragment_update_hero.*

class UpdateHeroFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_update_hero, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments.let {
            val heroe = it?.getSerializable("heroe") as Heroes
            bind(heroe)
        }
    }

    fun bind(heroe: Heroes){
        nombreHeroeEditext.setText(heroe.nombre)
        categorieHeroreEditext.setText(heroe.categoria)
        tipoHeroeEditext.setText(heroe.tipo)
        descriptionEditext.setText(heroe.descripcion)
        urlImagenEditext.setText(heroe.imageUrl)
    }


}
