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
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoeViewModel
import com.udacity.shoestore.models.ShoeViewModelFactory
import kotlinx.android.synthetic.main.fragment_shoe_detail.*
import kotlin.properties.ReadOnlyProperty



class ShoeDetail : Fragment() {

    private lateinit var  viewModel: ShoeViewModel
    private lateinit var binding : FragmentShoeDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate<FragmentShoeDetailBinding>(inflater, R.layout.fragment_shoe_detail, container, false)
        val factory = ShoeViewModelFactory()

        viewModel = ViewModelProvider(this).get(ShoeViewModel::class.java)

        Log.i("ShoeDETAIL", "Called viewModelProvider class")
        binding.shoeViewModel = viewModel
        binding.lifecycleOwner = this
        viewModel.list.observe(this.viewLifecycleOwner, Observer{binding.content.text = it.toString()})


        return binding.root
    }
}