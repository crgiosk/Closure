package com.wiedii.myapplication.view.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso

import com.wiedii.myapplication.R
import com.wiedii.myapplication.classes.Heroes
import kotlinx.android.synthetic.main.fragment_detail_heroe.*

class DetailHeroeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_heroe, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments.let {
            val heroe = it?.getSerializable("heroe") as Heroes
            bind(heroe)
        }
    }

    fun bind(heroe: Heroes){
        nombreHeroeTextView.text = heroe.nombre
        categorieHeroreTextView.text = heroe.categoria
        tipoHeroe.text = heroe.tipo
        Picasso.get()
            .load(heroe.imageUrl)
            .into(imageHeroeImageView)
    }


    companion object {
        const val TAG = "DetailHeroeFragment"
        fun newInstance(bundle: Bundle? = null): DetailHeroeFragment {
            var fragment = DetailHeroeFragment()
            if (bundle != null) {
                fragment.arguments = bundle
            }
            return fragment
        }
    }


}
