package com.example.letsea.Detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.letsea.Map.MapActivity
import com.example.letsea.R
import com.example.letsea.databinding.ActivityDetailShipBinding

class DetailShipActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDetailShipBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailShipBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            finish()
        }
        binding.btnTrackDetail.setOnClickListener {
            startActivity(Intent(this, MapActivity::class.java))
        }
    }
}