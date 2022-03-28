package com.example.a19.data.retrofit

import com.google.gson.annotations.SerializedName

//{"fact":"Cat families usually play best in even numbers. Cats and kittens should be aquired in pairs whenever possible.",
// "length":110}

data class CatFactModelModel(
    @SerializedName("fact")
    val fact:String,
    @SerializedName("length")
    val length:Int
)