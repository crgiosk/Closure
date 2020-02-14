package com.wiedii.myapplication.view.fragments


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.wiedii.myapplication.R
import com.wiedii.myapplication.classes.Heroes
import com.wiedii.myapplication.viewmodels.HeroeViewModel
import com.wiedii.myapplication.viewmodels.UiState
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
        setupListener()
        setHandlers()
    }

    fun setupListener() {
        guardarHeroeButton.setOnClickListener {
            if (emptyvalideFieldsFields()) {
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

    }




    fun setHandlers() {
        heroeViewModel.saveHeroesLiveData().observe(viewLifecycleOwner, Observer { state ->
            when (state) {
                is UiState.Loading -> {
                    Log.e(TAG, "Cargando...")
                }

                is UiState.OnSuccess<*> -> {
                    Log.e(TAG, "Mensaje guardado")
                    clearFields()
                    findNavController().navigate(R.id.action_nuevoHeroeFragment_to_heroesFragment2)
                }

                is UiState.OnError -> {
                    Log.e(TAG, "Error inesperado: ${state.message}")
                    clearFields()
                }
            }
        })
    }

    private fun emptyvalideFieldsFields(): Boolean {
        var valide: Boolean

        nombreHeroeEditext.run {

            if (this.text.toString().isNullOrEmpty()) {
                textInputLayout2.error = "Obligatorio"
                this.requestFocus()
                valide = false
            } else {
                textInputLayout2.error = null
                valide = true
            }
        }



            if (categorieHeroreEditext.text.toString().isNullOrEmpty()) {
            textInputLayout.error = "Obligatorio"
            valide = false
        } else {
            textInputLayout2.error = null
            valide = true
        }
            if (tipoHeroeEditext.text.toString().isNullOrEmpty()) {
            textInputLayout3.error = "Obligatorio"
            valide = false
        } else {
                textInputLayout3.error = null
            valide = true
        }
            if (descriptionEditext.text.toString().isNullOrEmpty()) {
            textInputLayout5.error = "Obligatorio"
            valide = false
        } else {
                textInputLayout5.error = null
            valide = true
        }
            if (urlImagenEditext.text.toString().isNullOrEmpty()) {
                textInputLayout5.error = "Obligatorio"
            valide = false
        } else {
            textInputLayout2.error = null
            valide = true
        }


        return valide
    }

    private fun clearFields() {
        nombreHeroeEditext.setText("")
        tipoHeroeEditext.setText("")
        categorieHeroreEditext.setText("")
        descriptionEditext.setText("")
        urlImagenEditext.setText("")
    }

    companion object {
        const val TAG = "NuevoHeroeFragment"
    }


}
