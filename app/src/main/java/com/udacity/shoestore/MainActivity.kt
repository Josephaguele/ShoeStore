package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Using DataBindingUtil to inflate layout
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        // Find the navController from myNavHostFragment
        val navController = this.findNavController(R.id.myNavHostFragment)
        // Link the navController to our ActionBar by calling NavigationUI.setupActionBarWithNavController
        NavigationUI.setupActionBarWithNavController(this, navController)

        Timber.plant(Timber.DebugTree())
    }

    // Override onSupportNavigateUp
    // Find the navController and then call navController.navigateUp
    // This is where we need the navigation to handle what happens when up is pressed, otherwise
    // nothing will happen when we press the navigation button
    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return navController.navigateUp()
    }
}
