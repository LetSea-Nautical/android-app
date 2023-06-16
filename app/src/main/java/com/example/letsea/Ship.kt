package com.example.letsea

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Ship(
    val name: String,
    val mmsi: String
) : Parcelable
