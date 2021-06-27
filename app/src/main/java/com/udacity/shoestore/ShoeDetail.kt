package com.udacity.shoestore

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoeViewModel
import kotlinx.android.synthetic.main.fragment_shoe_detail.*


/**
 * A simple [Fragment] subclass.
 * Use the [ShoeDetail.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShoeDetail : Fragment() {

    private lateinit var shoeviewModel: ShoeViewModel
    private lateinit var binding : FragmentShoeDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate<FragmentShoeDetailBinding>(
            inflater, R.layout.fragment_shoe_detail, container, false)

        Log.i("ShoeFragment", "Called viewModelProvider class")
        shoeviewModel = ViewModelProvider(this).get(ShoeViewModel::class.java)

        binding.saveButton.setOnClickListener {
            addShoe(it)
            view?.findNavController()?.navigate(R.id.action_shoeDetail_to_shoeFragment)
        }

        binding.cancelButton.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_shoeDetail_to_shoeFragment)
        }
        return binding.root
    }

    var mBrandName = ""
    var mDescription = ""
    var mSize = ""
    var mShoeName = ""


    // method for saving user input
    private fun addShoe(it: View?)
    {
        mBrandName = binding.brandName.text.toString()
        mSize = binding.size.text.toString()
        mDescription = binding.description.text.toString()
        mShoeName = binding.editName.text.toString()
    }






}