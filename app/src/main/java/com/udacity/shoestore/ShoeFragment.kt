package com.udacity.shoestore

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentShoelistBinding
import com.udacity.shoestore.models.ShoeViewModel
import kotlinx.android.synthetic.main.fragment_shoe_detail.*


/**
 * A simple [Fragment] subclass.
 * Use the [ShoeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShoeFragment : Fragment() {


    private lateinit var binding: FragmentShoelistBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         binding = DataBindingUtil.inflate<FragmentShoelistBinding>(
            inflater, R.layout.fragment_shoelist, container, false)

        // onclick for  the shoelist floating action button
        binding.shoelistfloatingButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_shoeFragment_to_shoeDetail)
        )



        return binding.root
    }

}