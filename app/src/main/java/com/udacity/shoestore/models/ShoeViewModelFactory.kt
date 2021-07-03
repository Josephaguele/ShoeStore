package com.udacity.shoestore.models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException
/*The ShoeViewModelFactory will throw an Exception in case the ViewModel is not found.*/
class ShoeViewModelFactory(): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ShoeViewModel::class.java))
        {
            return ShoeViewModel() as T
        }
        throw IllegalArgumentException( "UnknownViewModel")
    }
}