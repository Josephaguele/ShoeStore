package com.udacity.shoestore

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.FragmentShoelistBinding
import com.udacity.shoestore.models.ShoeViewModel
import kotlinx.android.synthetic.main.fragment_shoe_detail.*
import kotlinx.android.synthetic.main.fragment_shoelist.*


class ShoeListFragment : Fragment() {


    private lateinit var binding: FragmentShoelistBinding

    // ActivityViewModels can be used to share data between two fragments
    private  val viewModel: ShoeViewModel by activityViewModels()


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
            shoe_name.text = it.toString().capitalize()
        })

        // This tells android that there is a menu associated with this fragment
        // Without this code below, the fragment would not show those three dotted signs that indicate
        // that there is a menu to be inflated.
        setHasOptionsMenu(true)

        Log.i("ShoeFragment", "Called viewModelProvider class")
        return binding.root

    }

    // This is where menu is created. This will inflate the log_menu layout to be in the ShoeListFragment
    // It would appear only in the ShoeList fragment because that is where it it was inflated.
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.logout_menu, menu)
    }

    // Return true if NavigationUI.onNavDestinationSelected returns true, else return
    // super.onOptionsItemSelected.
    // This is what makes the menu button respond to any action.
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }
}