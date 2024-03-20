package com.nagma.myrecipeapplication.data

import android.content.Context
import android.util.Log
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

//const val BASE_ENDPOINT_URL = "https://2873199.youcanlearnit.net/"
const val BASE_ENDPOINT_URL = "https://fakestoreapi.com/"

class ProductRepository {

    private val retrofit:Retrofit by lazy {
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

        Retrofit.Builder()
            .baseUrl(BASE_ENDPOINT_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    private val productApi: ProductApi by lazy {
        retrofit.create(ProductApi::class.java)
    }

    suspend fun getProducts(): List<Product> {
        val response = productApi.getProducts()
        Log.i("items","product names: ${response.body()}")
        return if (response.isSuccessful)
            response.body() ?: emptyList()
        else
            emptyList()
    }

}