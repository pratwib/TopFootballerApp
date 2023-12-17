package com.pratwib.myrecyclerview

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Footballer(
    val name: String,
    val photo: String,
    val age: String,
    val price: String,
    val position: String,
    val description: String,
    val link: String
) : Parcelable
