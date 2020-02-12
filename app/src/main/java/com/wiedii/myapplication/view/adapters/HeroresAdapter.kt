package com.wiedii.myapplication.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wiedii.myapplication.R
import com.wiedii.myapplication.classes.Heroes
import kotlinx.android.synthetic.main.item_heroe.view.*

class HeroesAdapter(val clickClosure: (Heroes) -> Unit) :
    RecyclerView.Adapter<HeroesAdapter.ViewHolder>() {

    private var listHerores: MutableList<Heroes> = mutableListOf()

    fun setData(heroes: ArrayList<Heroes>) {
        this.listHerores.clear()
        this.listHerores.addAll(heroes)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_heroe, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return this.listHerores.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val view = this.listHerores[position]
        holder.bind(view)
        holder.bindClick(view)
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(heroe: Heroes){
            itemView.nombreHeroeTextView.text = heroe.nombre
            itemView.categorieHeroreTextView.text = heroe.categoria
            itemView.tipoHeroe.text = heroe.tipo
        }

        fun bindClick(heroe: Heroes){
            itemView.item_heroe.setOnClickListener {
                clickClosure(heroe)
            }
        }
    }
}
