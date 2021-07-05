package com.udacity.shoestore.models

import android.util.Log
import android.widget.EditText
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*
import kotlin.collections.ArrayList

class ShoeViewModel : ViewModel() {
    /*The purpose of the ViewModel is to acquire and keep the information that is necessary
    for an Activity or a Fragment. The Activity or the Fragment should be able to observe changes in the ViewModel.
     ViewModels usually expose this information via LiveData or Android Data Binding.*/

    // this helps determine whether or not the user's input is empty
    val isStringEmpty = MutableLiveData<Boolean>()

    /*The shoeBrand and shoeDescription variables will store the user's data.
    * The value stored in these variables will change according to the user's input;
    * hence we use MutableLiveData*/
    val mShoeDescription = MutableLiveData<String>()
    val mShoeName = MutableLiveData<String>()
    val mShoeBrand = MutableLiveData<String>()
    val mShoeSize = MutableLiveData<String>()

    // The list will store the ShoeItem arraylst. It's capable of refreshing itself when it detects
    // a change in its content.
    val list = MutableLiveData<ArrayList<Shoe>>()
    private val arraylst = ArrayList<Shoe>()

    /* The ShoeViewModel also contains three important methods: init, addData and clearData.
    / The init method will initialize the isStringEmpty variable to false. This method launches
    automatically once the ShoeViewModel is created*/
    init{
        Log.i("ShoeModel:", "ShoeViewModel created")
        isStringEmpty.value = false
    }

    // The addData method takes the user input and checks if it's empty.
    // The isStringEmpty variable is updated to true if the data is empty.
    // Otherwise, the data is entered into a ShoeItem object and passed to the arraylst.
    // The arraylst is then stored in list.
    fun addData()
    {
        val title = mShoeName.value!!
        val description = mShoeDescription.value!!
        val size = mShoeSize.value!!
        val ss = size.toDouble() // converting size to double
        val company = mShoeBrand.value!!
        if(title.isBlank() || description.isBlank())
        {
            isStringEmpty.value = true
        }else{
            mShoeName.value = " "
            mShoeDescription.value = " "
            mShoeBrand.value= ""
            mShoeSize.value = ""
            var shoeItem = Shoe(title, ss ,company, description)
            arraylst.add(shoeItem)
            list.value = arraylst
        }
    }

    fun clearData(){
        arraylst.clear()
        list.value = arraylst
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("ShoeModel: ", "ShoeViewlModel destroyed")
    }


}