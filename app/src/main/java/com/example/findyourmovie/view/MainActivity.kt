package com.example.findyourmovie.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.findyourmovie.R
import com.example.findyourmovie.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.container)

        if(savedInstanceState == null){
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.container,MainFragment.newInstance())
                .commit()
        }

        binding.bottomNav.setOnItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.action_home -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.container, MainFragment.newInstance())
                        .commit()
                    return@setOnItemSelectedListener true
                }
                R.id.action_favorite -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.container, MainFavoriteFilmsFragment.newInstance())
                        .commit()
                    return@setOnItemSelectedListener true
                }
                R.id.action_rating -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.container, MainRatingFilmsFragment.newInstance())
                        .commit()
                    return@setOnItemSelectedListener true
                }
            }
            false
        }
    }

}


