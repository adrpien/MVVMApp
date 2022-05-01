package com.adrpien.mvvmapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FragmentViewModel: ViewModel() {


    /*
    LiveData is an observable data holder class. Unlike a regular observable, LiveData is lifecycle-aware,
    meaning it respects the lifecycle of other app components, such as activities, fragments, or services.
     */
    val ld: MutableLiveData<String> = MutableLiveData()

    fun setString(s: String){
        ld.value = s
    }
    fun getMutableLiveData(): MutableLiveData<String>{
        return ld
    }
}