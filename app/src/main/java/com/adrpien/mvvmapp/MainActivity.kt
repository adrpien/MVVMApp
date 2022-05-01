package com.adrpien.mvvmapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.adrpien.mvvmapp.databinding.ActivityMainBinding

/*
    Architektura MVVM (Model--View--View Model)
    View informuje o interakcji użytkownika z aplikacją.
    Np. Mamy przycisk, który naciskamy. View odbiera tę akcję i informuje ViewModel
    o tym, że została wykonana akcja. Następnie ViewModel odnosi sie do modelu
    (np. danych, pobiera je a następnie zwraca dane spowrotem do ViewModel).
    Ostatecznie dane są wyswietlane w View dzięki Viemodel
    Fragment/Activity -> ViewModel -> Model

    Można z niej z skorzystać do przesyłania danych miedzy dwoma Fragmentami w czasie rzeczywistym.
    np. Po obróceniu ekranu, nasza aktywność jest niszczona, wtedy tracimy stan naszych zmiennych.
    W tym czasie ViewModel jest stały. Aktywoność jest niszczona i odwarzana, a Viewmodel jest cały czas ten sam.
    Dopiero, gdy aktywność definitywnie przestaje istnieć, wywoływana jest metoda onCleared.

    UWAGA!
    W momencie, gdy aktywność na nowo się odtwarza, pobiera dane z ViewModel

    Jak napisać aplikację opartą o architekturę MVVM:
    1. Dodać depencies w pliku manifest
    2. Stworzyć fragmenty
    3. Stworzyć miejsca do umieszczenia fragmentów w pliku XML aktywności Main Activity
    4. Dodać fragmenty dynamicznie w MainActivity.kt
    5. Dodać klasę dziedziczącą po ViewModel
        - utworzyć w niej MutableLiveData, oraz getter i setter
    6. Zaimplementować InputTextFragment:
        - utworzyć ViewModelProvider
        - zaimplementować aktualizację MutableLiveData w onTextChanged
    7. Zaimplementować OutputTextProvider:
        - utworzyć ViewModelProvider
        - zaimplementować aktualizację pola TextView, po każdej zmianie w MutableLiveData
        (wymaga to zaimplementowania obserwatora MutableLiveData)

 */

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Creating Fragments
        val inputFragment = InputTextFragment()
        val outputFragment = OutputTextFragment()

        // Adding Fragments
        supportFragmentManager.beginTransaction().add(R.id.inputFragmentContainer, inputFragment).commit()
        supportFragmentManager.beginTransaction().add(R.id.outputFragmentContainer,outputFragment).commit()

    }
}