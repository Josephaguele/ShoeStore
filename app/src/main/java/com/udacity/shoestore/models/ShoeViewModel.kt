package com.udacity.shoestore.models

import android.util.Log
import android.widget.EditText
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class ShoeViewModel : ViewModel() {

    var mBrandName = MutableLiveData<String>()

    // The list of shoes and details
    private lateinit var shoes:MutableLiveData<String>

    fun select(item: String) {
        shoes.value = item
    }

    init{
        Log.i("ShoeModel:", "ShoeViewModel created")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("ShoeModel: ", "ShoeViewlModel destroyed")
    }
}