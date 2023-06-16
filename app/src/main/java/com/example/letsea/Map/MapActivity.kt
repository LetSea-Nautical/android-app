package com.example.letsea.Map

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.letsea.Detail.DetailShipActivity
import com.example.letsea.R
import com.example.letsea.databinding.ActivityMainBinding
import com.example.letsea.databinding.ActivityMapBinding

class MapActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMapBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            finish()
        }
        binding.btnVesselDetail.setOnClickListener {
            startActivity(Intent(this,DetailShipActivity::class.java))
        }
    }
}