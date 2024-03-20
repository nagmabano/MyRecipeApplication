package com.nagma.myrecipeapplication.data

import retrofit2.Response
import retrofit2.http.GET

interface ProductApi {

//    @GET("olive_oils_with_images_data.json")
//    suspend fun getProducts(): Response<List<Product>>

    @GET("products")
    suspend fun getProducts(): Response<List<Product>>
}