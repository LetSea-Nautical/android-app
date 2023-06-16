import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.letsea.ChangePasswordRequest
import com.example.letsea.ChangePasswordResponse
import com.example.letsea.UserResponse
import com.example.letsea.databinding.ActivityEditPasswordBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EditPasswordActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            finish()
        }

        binding.btnChangePassword.setOnClickListener {
            changePassword()
        }
    }

    private fun changePassword() {
        val newPassword = binding.newPassword.text.toString()

        if (newPassword.isNotEmpty()) {
            val apiService = ApiConfig.getApiService()
            val token = "YOUR_TOKEN_HERE" // Replace with your actual token

            val request = ChangePasswordRequest(newPassword)
            val call = apiService.changePassword(token, request)
            call.enqueue(object : Callback<ChangePasswordResponse> {
                override fun onResponse(call: Call<ChangePasswordResponse>, response: Response<ChangePasswordResponse>) {
                    if (response.isSuccessful) {
                        val changePasswordResponse = response.body()
                        if (changePasswordResponse?.success == true) {
                            Toast.makeText(this@EditPasswordActivity, "Password changed successfully", Toast.LENGTH_SHORT).show()
                            finish()
                        } else {
                            Toast.makeText(this@EditPasswordActivity, "Failed to change password", Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        Toast.makeText(this@EditPasswordActivity, "Failed to change password", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<ChangePasswordResponse>, t: Throwable) {
                    Toast.makeText(this@EditPasswordActivity, "Failed to change password: ${t.message}", Toast.LENGTH_SHORT).show()
                }
            })
        } else {
            Toast.makeText(this, "Please enter a new password", Toast.LENGTH_SHORT).show()
        }
    }
}