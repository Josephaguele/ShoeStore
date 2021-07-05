package com.udacity.shoestore

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.ShoeViewModel


class ShoeDetail : Fragment() {

    private val  viewModel: ShoeViewModel by activityViewModels()
    private lateinit var binding : FragmentShoeDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate<FragmentShoeDetailBinding>(inflater, R.layout.fragment_shoe_detail, container, false)


        Log.i("ShoeDETAIL", "Called viewModelProvider class")
        binding.shoeViewModel = viewModel
        binding.lifecycleOwner = this
        viewModel.list.observe(this.viewLifecycleOwner, Observer{binding.content.text =  it.toString()})

        return binding.root
    }
}