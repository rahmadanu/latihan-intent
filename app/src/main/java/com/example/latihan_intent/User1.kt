package com.example.latihan_intent

import java.io.Serializable

data class User1(
    val fullName: String,
    val nickName: String,
    val age: Int,
    val address: String
) : Serializable
