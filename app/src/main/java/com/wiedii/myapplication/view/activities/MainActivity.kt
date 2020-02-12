package com.wiedii.myapplication.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import com.wiedii.myapplication.R
import com.wiedii.myapplication.view.fragments.HeroesFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(
            R.id.containerMain,
            HeroesFragment.newInstance(),
            HeroesFragment.TAG
        )
        fragmentTransaction.commit()
    }
}
