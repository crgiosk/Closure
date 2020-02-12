package com.wiedii.myapplication.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import com.wiedii.myapplication.classes.Heroes
import com.wiedii.myapplication.view.adapters.HeroesAdapter
import com.wiedii.myapplication.R
import kotlinx.android.synthetic.main.fragment_heroes.*

class HeroesFragment : Fragment() {

    private lateinit var adapterHeroes: HeroesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_heroes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()

        adapterHeroes.setData(heroes())
    }

    fun heroes(): ArrayList<Heroes> {
        val heroes: ArrayList<Heroes> = arrayListOf()

        heroes.add(
            Heroes(
                nombre = "Crystal Maiden",
                categoria = "Inteligencia",
                tipo = "Support",
                imageUrl = "https://1.bp.blogspot.com/-CmOHigi1enU/VCWszms3z_I/AAAAAAAAAmY/upOxtsyesFY/s1600/crystal_maiden_full.jpg"
            )
        )
        heroes.add(
            Heroes(
                nombre = "Lina",
                categoria = "Inteligencia",
                tipo = "Support/Hc",
                imageUrl = "https://wallpaperstock.net/dota-2---lina-wallpapers_30520_1920x1440.jpg"
            )
        )
        heroes.add(
            Heroes(
                nombre = "Luna",
                categoria = "Agilidad",
                tipo = "Hc/Medio",
                imageUrl = "https://i2.wp.com/firstblood.io/pages/wp-content/uploads/2018/09/luna-hero-guide-970x570.jpg?resize=970%2C570&ssl=1"
            )
        )
        heroes.add(
            Heroes(
                nombre = "Axe",
                categoria = "Fuerza",
                tipo = "Tanque/Hc",
                imageUrl = "https://s1.1zoom.me/big3/67/DOTA_2_Axe_Warriors_436709.jpg"
            )
        )
        heroes.add(
            Heroes(
                nombre = "Sniper",
                categoria = "Agilidad",
                tipo = "Hc/Medio",
                imageUrl = "https://i.pinimg.com/originals/28/ab/6e/28ab6e70c138f3b49a8d0bc725fbe171.jpg"
            )
        )
        heroes.add(
            Heroes(
                nombre = "Drow Ranger",
                categoria = "Agilidad",
                tipo = "Hc/Medio",
                imageUrl = "https://4.bp.blogspot.com/-9QW6p1H58LA/V0XDfYA-pHI/AAAAAAAAfXU/HJIb4OjIwPwA9dfn-UeHZi2LvaQVPLTQgCLcB/s1600-d/Drow_Ranger_DOTA_2_Wallpaper_Fondo_Loading_screen_2.jpg"
            )
        )
        return heroes
    }

    fun initUi() {
        adapterHeroes = HeroesAdapter {
            val bundle = Bundle()
            bundle.putSerializable("heroe",it)
            launchFragment(DetailHeroeFragment.newInstance(bundle),DetailHeroeFragment.TAG)
        }

        recyclerViewHeroes.run {
            layoutManager = LinearLayoutManager(context!!, LinearLayoutManager.VERTICAL, false)
            setHasFixedSize(true)
            adapter = adapterHeroes
        }
    }

    companion object {
        const val TAG = "HeroesFragment"

        fun newInstance(bundle: Bundle? = null): HeroesFragment {
            var fragment = HeroesFragment()
            if (bundle != null) {
                fragment.arguments = bundle
            }
            return fragment
        }
    }

    private fun launchFragment(fragment: Fragment, tag: String) {
        val fragmentTransaction: FragmentTransaction = activity!!.supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.containerMain, fragment, tag)
        fragmentTransaction.addToBackStack(tag)
        fragmentTransaction.commit()
    }


}
