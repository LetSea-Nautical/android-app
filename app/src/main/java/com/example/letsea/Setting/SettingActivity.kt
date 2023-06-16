package com.example.letsea.Setting

import EditPasswordActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.letsea.Auth.LoginActivity
import com.example.letsea.LogoutResponse
import com.example.letsea.Network.ApiService
import com.example.letsea.databinding.ActivitySettingBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SettingActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySettingBinding
    private lateinit var apiService: ApiService
    private lateinit var token: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        apiService = ApiConfig.getApiService()
        token = "YOUR_TOKEN_HERE"

        binding.btnBack.setOnClickListener {
            finish()
        }
        binding.btnLogout.setOnClickListener {
            logout()
        }
        binding.btnEditPassword.setOnClickListener {
            startActivity(Intent(this, EditPasswordActivity::class.java))
        }
    }

    private fun logout() {
        val call = apiService.logout(token)
        call.enqueue(object : Callback<LogoutResponse> {
            override fun onResponse(call: Call<LogoutResponse>, response: Response<LogoutResponse>) {
                if (response.isSuccessful) {
                    Toast.makeText(this@SettingActivity, "Logout successful", Toast.LENGTH_SHORT)
                    startActivity(Intent(this@SettingActivity, LoginActivity::class.java))
                    finish()
                } else {
                    Toast.makeText(this@SettingActivity, "Failed to logout", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<LogoutResponse>, t: Throwable) {
                Toast.makeText(this@SettingActivity, "Failed to logout: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}