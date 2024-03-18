package com.nagma.myrecipeapplication

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.nagma.myrecipeapplication.data.Product
import com.nagma.myrecipeapplication.data.ProductRepository

class MainViewModel(app: Application): AndroidViewModel(app) {

    private val productRepository: ProductRepository = ProductRepository()

    val products: LiveData<List<Product>> = liveData {
        val data = productRepository.getProducts()
        Log.i("data", "data: $data")
        emit(data)
    }
}