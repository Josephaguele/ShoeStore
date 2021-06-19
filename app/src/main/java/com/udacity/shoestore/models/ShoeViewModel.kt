package com.udacity.shoestore.models

import android.util.Log
import androidx.lifecycle.ViewModel

class ShoeViewModel : ViewModel() {

    init{
        Log.i("ShoeModel:", "ShoeViewModel created")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("ShoeModel: ", "ShoeViewlModel destroyed")
    }


    // the list of shoes
    private lateinit var shoeList: MutableList<String>



}