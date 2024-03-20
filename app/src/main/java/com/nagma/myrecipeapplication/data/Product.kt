package com.nagma.myrecipeapplication.data

import com.squareup.moshi.Json

//data class Product(
//    @Json(name = "productName") val name: String,
//    val imageFile:String,
//    val description:String,
//    val size: Int,
//    val price: Double
//)

data class Product(
    @Json(name = "title") val name: String,
    @Json(name = "image")val imageFile:String,
    val description:String,
    val category: String,
    val price: Double
)
