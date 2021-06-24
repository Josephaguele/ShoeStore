package com.udacity.shoestore.models

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeViewModel : ViewModel() {

    init{
        Log.i("ShoeModel:", "ShoeViewModel created")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("ShoeModel: ", "ShoeViewlModel destroyed")
    }


    // The current shoebrandName
    private val _shoebrandName = MutableLiveData<String>()
    val shoeBrandName: LiveData<String>
        get() = _shoebrandName


}