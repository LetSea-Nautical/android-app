package com.example.letsea.Network

import com.example.letsea.ChangePasswordRequest
import com.example.letsea.ChangePasswordResponse
import com.example.letsea.LogoutResponse
import com.example.letsea.UserResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @FormUrlEncoded
    @POST("login")
    fun loginUser(
        @Field("username") username: String,
        @Field("password") password: String
    ): Call<UserResponse>

    fun changePassword(
        @Header("TOKEN") token: String,
        @Body request: ChangePasswordRequest
    ): Call<ChangePasswordResponse>

    @DELETE("/logout")
    fun logout(@Header("TOKEN") token: String): Call<LogoutResponse>
}

