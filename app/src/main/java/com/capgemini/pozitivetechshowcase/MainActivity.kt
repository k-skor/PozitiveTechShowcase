package com.capgemini.pozitivetechshowcase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.capgemini.pozitivetechshowcase.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        title = getString(R.string.app_name)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val view = binding.root
        setContentView(view)
    }
}