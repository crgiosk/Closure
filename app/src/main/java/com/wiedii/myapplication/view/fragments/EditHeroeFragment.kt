package com.wiedii.myapplication.view.fragments


import android.os.Bundle
import android.system.Os.bind
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController

import com.wiedii.myapplication.R
import com.wiedii.myapplication.classes.Heroes
import com.wiedii.myapplication.viewmodels.HeroeViewModel
import com.wiedii.myapplication.viewmodels.UiState
import kotlinx.android.synthetic.main.fragment_edit_heroe.*
import kotlinx.android.synthetic.main.fragment_edit_heroe.categorieHeroreEditext
import kotlinx.android.synthetic.main.fragment_edit_heroe.descriptionEditext
import kotlinx.android.synthetic.main.fragment_edit_heroe.guardarHeroeButton
import kotlinx.android.synthetic.main.fragment_edit_heroe.nombreHeroeEditext
import kotlinx.android.synthetic.main.fragment_edit_heroe.tipoHeroeEditext
import kotlinx.android.synthetic.main.fragment_edit_heroe.urlImagenEditext
import org.koin.android.ext.android.bind
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.Observer

class EditHeroeFragment : Fragment() {
    private val heroeViewModel: HeroeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit_heroe, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        arguments.let {
            val heroe = it?.getSerializable("heroe") as Heroes

            bind(heroe)
            upListener()
            updaHandlers()
        }


    }

    fun updaHandlers() {
        heroeViewModel.updateHeroesLiveData()
            .observe(viewLifecycleOwner, androidx.lifecycle.Observer { state ->
                when (state) {

                    is UiState.Loading -> {

                        Log.e(TAG, "cargando")

                    }
                    is UiState.OnSuccess<*> -> {
                        Log.e(TAG, "mensaje guardado")

                        findNavController().navigate(R.id.action_editHeroeFragment_to_heroesFragment)

                    }
                    is UiState.OnError -> {

                        Log.e(TAG, "error inesperado: ${state.message}")


                    }
                }


            })

    }


    fun upListener() {
        guardarHeroeButton.setOnClickListener {
            if (emptyvalideFieldsFields()) {
                heroeViewModel.updateHeroe(
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

    }

    fun bind(heroe: Heroes) {
        nombreHeroeEditext.setText(heroe.nombre)
        categorieHeroreEditext.setText(heroe.categoria)
        tipoHeroeEditext.setText(heroe.tipo)
        descriptionEditext.setText(heroe.descripcion)
        urlImagenEditext.setText(heroe.imageUrl)
    }

    private fun emptyvalideFieldsFields(): Boolean {
        var valide: Boolean

        nombreHeroeEditext.run {
            if (this.text.toString().isNullOrEmpty()) {
                nombreHeroeEditextLayout.error = "Obligatorio"
                this.requestFocus()
                valide = false
            } else {
                categorieHeroreEditextLayout.error = null
                valide = true
            }
        }

        categorieHeroreEditext.run {
            if (categorieHeroreEditext.text.toString().isNullOrEmpty()) {
                tipoHeroeEditextLayout.error = "Obligatorio"
                valide = false
            } else {
                descriptionEditextLayoout.error = null
                valide = true
            }
        }

        tipoHeroeEditextLayout.run {
            if (tipoHeroeEditext.text.toString().isNullOrEmpty()) {
                tipoHeroeEditextLayout.error = "Obligatorio"
                valide = false
            } else {
                descriptionEditextLayoout.error = null
                valide = true
            }
        }

        descriptionEditextLayoout.run {
            if (descriptionEditext.text.toString().isNullOrEmpty()) {
                tipoHeroeEditextLayout.error = "Obligatorio"
                valide = false
            } else {
                descriptionEditextLayoout.error = null
                valide = true
            }
        }


        urlImagenEditextLayout.run {
            if (urlImagenEditext.text.toString().isNullOrEmpty()) {
                tipoHeroeEditextLayout.error = "Obligatorio"
                valide = false
            } else {
                descriptionEditextLayoout.error = null
                valide = true
            }
        }





        return valide

    }


    companion object {
        const val TAG = "NuevoHeroeFragment"
    }

}













