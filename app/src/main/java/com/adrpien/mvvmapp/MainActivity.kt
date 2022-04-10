package com.adrpien.mvvmapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.adrpien.mvvmapp.databinding.ActivityMainBinding

/*
    Architektura MVVM (Model-View-View Model)
    View informuje o interakcji użytkownika z aplikacją.
    Np. Mamy przycisk, który naciskamy. View odbiera tę akcję i informuje ViewModel
    o tym, że została wykonana akcja. Następnie ViewModel odnosi sie do modelu ,
    który zwraca dane spowrotem do ViewModel.
    Ostatecznie dane są wyswietlane w View dzięki Viemodel
 */

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val inputFragment = InputTextFragment()
        val outputFragment = OutputTextFragment()

        supportFragmentManager.beginTransaction().add(R.id.inputFragmentContainer, inputFragment).commit()
        supportFragmentManager.beginTransaction().add(R.id.outputFragmentContainer,outputFragment).commit()

    }
}