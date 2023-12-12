package com.example.lrrip1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lrrip1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        supportFragmentManager.beginTransaction().replace(R.id.place_holder, Fragment1.newInstance()).commit()
    }
}