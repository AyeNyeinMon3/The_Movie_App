package com.example.themovieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.example.themovieapp.databinding.ActivityMainBinding
import com.example.themovieapp.fragments.FavoriteFragment
import com.example.themovieapp.fragments.HomeFragment
import com.example.themovieapp.fragments.MovieDetailsFragment
import com.example.themovieapp.fragments.ProfileFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        binding.chipNavBar.setItemSelected(R.id.chip_navBar,true)

        binding.chipNavBar.setItemSelected(R.id.home)
        binding.chipNavBar.setOnItemSelectedListener {
            when(it) {
                R.id.home -> {
                    switchFragment(HomeFragment())
                }

                R.id.favorite -> {
                    switchFragment(FavoriteFragment())
                }

                R.id.profile -> {
                    switchFragment(ProfileFragment())
                }
            }
        }





    }
    private fun switchFragment(fragment:Fragment){
        supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(R.id.nav_host_fragment, fragment)
            .commit()

    }
}