package com.example.letsea

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.letsea.databinding.ActivityRegisterShipBinding

class RegisterShipActivity : AppCompatActivity() {
    private lateinit var binding : ActivityRegisterShipBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterShipBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            finish()
        }
        binding.btnRegisterShip.setOnClickListener {
            registerShip()
        }
    }

    private fun registerShip() {
        startActivity(Intent(this,HomeActivity::class.java))
    }
}