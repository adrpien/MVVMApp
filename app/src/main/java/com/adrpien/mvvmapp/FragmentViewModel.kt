package com.adrpien.mvvmapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FragmentViewModel: ViewModel() {

    val ld: MutableLiveData<String> = MutableLiveData()

    fun setString(s: String){
        ld.value = s
    }
    fun getString(): MutableLiveData<String>{
        return ld
    }
}