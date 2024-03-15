package com.nagma.myrecipeapplication.data

import retrofit2.Response
import retrofit2.http.GET

interface ProductApi {

    @GET("olive_oil_data.json")
    suspend fun getProducts(): Response<List<Product>>
}