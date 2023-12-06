package com.example.wayfairassignment.data.service

import com.example.wayfairassignment.data.entitiy.ProductsDto
import com.nishant.network.network.NetworkResult
import retrofit2.http.GET

interface ProductsService {
    @GET("interview-sandbox/android/json-to-list/products.v1.json")
    suspend fun getProducts(): NetworkResult<List<ProductsDto>>
}