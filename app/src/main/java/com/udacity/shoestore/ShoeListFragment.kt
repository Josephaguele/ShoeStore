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


class ShoeListFragment : Fragment() {


    private lateinit var binding: FragmentShoelistBinding
    private lateinit var viewModel: ShoeViewModel
    lateinit var shoeTitle: String


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
         binding = DataBindingUtil.inflate<FragmentShoelistBinding>(
            inflater, R.layout.fragment_shoelist, container, false)

        // onclick for  the shoelist floating action button
        binding.shoelistfloatingButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_shoeFragment_to_shoeDetail)
        )
        Log.i("ShoeFragment", "Called viewModelProvider class")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ViewModelProvider(this).get(ShoeViewModel::class.java)

    }


}