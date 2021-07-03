package com.udacity.shoestore.welcome

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R

import com.udacity.shoestore.databinding.FragmentLoginBinding
class LogInFragment : Fragment() {

    //Inflating and Returning the View with DataBindingUtil
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentLoginBinding>(
            inflater, R.layout.fragment_login, container, false)

        // set button action
        binding.loginButton.setOnClickListener (
            Navigation.createNavigateOnClickListener(R.id.action_logInFragment_to_welcomeFragment))

        // This tells android that there is a menu associated with this fragment
        setHasOptionsMenu(true)
        return binding.root
    }

    // This is where menu is created. This will inflate the overflow_menu layout
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.overflow_menu, menu)
    }

    // Return true if NavigationUI.onNavDestinationSelected returns true, else return
    // super.onOptionsItemSelected
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!, view!!.findNavController())
                || super.onOptionsItemSelected(item)
    }
}