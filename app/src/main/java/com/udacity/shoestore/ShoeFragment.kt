package com.udacity.shoestore

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.udacity.shoestore.databinding.FragmentShoeBinding
import com.udacity.shoestore.models.ShoeViewModel


/**
 * A simple [Fragment] subclass.
 * Use the [ShoeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShoeFragment : Fragment() {

    private lateinit var viewViewModel: ShoeViewModel

    private lateinit var binding: FragmentShoeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentShoeBinding>(
            inflater, R.layout.fragment_shoe, container, false)


        Log.i("ShoeFragment", "Called viewModelProvider class")
        viewViewModel = ViewModelProvider(this).get(ShoeViewModel::class.java)



        return binding.root
    }





}