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
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentShoelistBinding
import com.udacity.shoestore.models.ShoeViewModel
import kotlinx.android.synthetic.main.fragment_shoe_detail.*
import kotlinx.android.synthetic.main.fragment_shoelist.*


class ShoeListFragment : Fragment() {


    private lateinit var binding: FragmentShoelistBinding

    // ActivityViewModels can be used to share data between two fragments
    private  val viewModel: ShoeViewModel by activityViewModels()
    lateinit var shoeTitle: String


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
         binding = DataBindingUtil.inflate<FragmentShoelistBinding>(
            inflater, R.layout.fragment_shoelist, container, false)

        // onclick for  the shoelist floating action button
        binding.shoelistfloatingButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_shoeFragment_to_shoeDetail)
        )

        // The code below is what receives the details from the lifecycle observer and sends it to the
        // shoedescription textview
        viewModel.list.observe(this.viewLifecycleOwner, Observer<Any>
        {
            shoedescriptionText.text = it.toString()
        })


        Log.i("ShoeFragment", "Called viewModelProvider class")
        return binding.root

    }
}