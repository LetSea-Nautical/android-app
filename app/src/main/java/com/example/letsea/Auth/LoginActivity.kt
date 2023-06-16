package com.example.letsea.Auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.letsea.HomeActivity
import com.example.letsea.UserResponse
import com.example.letsea.databinding.ActivityLoginBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private var username: String = ""
    private var password: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLoginToHome.setOnClickListener {
            moveHome()
        }
    }

    private fun moveHome() {
        username = binding.username.text.toString()
        password = binding.password.text.toString()

        val apiService = ApiConfig.getApiService()
        val call = apiService.loginUser(username, password)
        call.enqueue(object : Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                if (response.isSuccessful) {
                    val userResponse = response.body()
                    if (userResponse?.success == true) {
                        val token = userResponse.token
                        Toast.makeText(this@LoginActivity, "Login Successful", Toast.LENGTH_SHORT)
                            .show()
                        val intent = Intent(this@LoginActivity, HomeActivity::class.java)
                        intent.putExtra("token", token) // Pass the token as an intent extra
                        startActivity(intent)
                        finish()
                    } else {
                        Toast.makeText(this@LoginActivity, "Login Failed", Toast.LENGTH_SHORT)
                            .show()
                    }
                } else {
                    Toast.makeText(this@LoginActivity, "API Error", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                Toast.makeText(this@LoginActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
                Log.e("LoginActivity", "Login API failed", t)
            }
        })
    }
}