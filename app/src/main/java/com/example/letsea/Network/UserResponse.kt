package com.example.letsea

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserResponse(
    @SerializedName("data")
    val data: Data,

    @SerializedName("success")
    val success: Boolean,

    @SerializedName("message")
    val message: String,

    @SerializedName("token")
    var token: String
) : Parcelable

@Parcelize
data class Data(
    @SerializedName("username")
    var username: String,

    @SerializedName("password")
    var password: String,
) : Parcelable

data class LogoutResponse(
    @SerializedName("payload")
    val payload: LogoutPayload
)

data class LogoutPayload(
    @SerializedName("messages")
    val messages: String,
    @SerializedName("status_Code")
    val statusCode: Int,
    @SerializedName("datas")
    val datas: Any?
)
data class ChangePasswordRequest(
    @SerializedName("new_password")
    val newPassword: String
)

data class ChangePasswordResponse(
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("message")
    val message: String
)
