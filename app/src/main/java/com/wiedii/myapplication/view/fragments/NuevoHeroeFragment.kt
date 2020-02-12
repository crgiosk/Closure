package com.wiedii.myapplication.view.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel

import com.wiedii.myapplication.R
import com.wiedii.myapplication.classes.Heroes
import com.wiedii.myapplication.viewmodels.HeroeViewModel
import com.wiedii.myapplication.viewmodels.UiState
import kotlinx.android.synthetic.main.fragment_heroes.*
import kotlinx.android.synthetic.main.fragment_nuevo_heroe.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class NuevoHeroeFragment : Fragment() {

    private val heroeViewModel: HeroeViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nuevo_heroe, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //setupListener()
    }

    fun setupListener(){
        nuevoHeroeFabButton.setOnClickListener {
            heroeViewModel.saveHeroe(
                Heroes(
                    nombre = nombreHeroeEditext.text.toString(),
                    tipo = tipoHeroeEditext.text.toString(),
                    categoria = categorieHeroreEditext.text.toString(),
                    descripcion = descriptionEditext.text.toString(),
                    imageUrl = urlImagenEditext.text.toString()
                )
            )
        }
    }

    fun setHandlers(){

    }




}
