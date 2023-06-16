package com.example.letsea

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.letsea.Adapter.ShipAdapter
import com.example.letsea.Setting.SettingActivity
import com.example.letsea.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding : ActivityHomeBinding
    private lateinit var shipAdapter: ShipAdapter
    private lateinit var token: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        token = intent.getStringExtra("token") ?: ""

        // Create dummy ship list
        val shipList = listOf(
            Ship("Ship 1", "MMSI 123456789"),
            Ship("Ship 2", "MMSI 987654321"),
            Ship("Ship 3", "MMSI 456789123")
        )

        // Initialize ShipAdapter with the ship list
        shipAdapter = ShipAdapter(shipList)

        // Set the adapter for the RecyclerView
        binding.listItem.adapter = shipAdapter

        binding.btnRegisterShip.setOnClickListener{
            startActivity(Intent(this, RegisterShipActivity::class.java))
        }
        binding.btnSetting.setOnClickListener {
            startActivity(Intent(this, SettingActivity::class.java))
        }
    }
}