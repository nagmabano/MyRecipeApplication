package com.nagma.myrecipeapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.nagma.myrecipeapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        // created the binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Adding the Fragment in this view
        supportFragmentManager.commit {
            add<HomeFragment>(R.id.container, null)
        }

        binding.navigation.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.home -> goToHomeFragment()
                R.id.products -> goToProductsFragment()
                R.id.settings -> goToSettingsFragment()
                else -> false
            }
        }
    }
    private fun goToSettingsFragment(): Boolean {
        supportFragmentManager.commit {
            replace<SettingsFragment>(R.id.container, null, null)
        }
        return true
    }
    private fun goToProductsFragment(): Boolean {
        supportFragmentManager.commit {
            replace<ProductsFragment>(R.id.container, null, null)
        }
        return true
    }
    private fun goToHomeFragment(): Boolean {
        supportFragmentManager.commit {
            replace<HomeFragment>(R.id.container, null, null)
        }
        return true
    }
}