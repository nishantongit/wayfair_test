package com.example.wayfairassignment.domain.repository

import com.example.wayfairassignment.data.entitiy.ProductsDto
import com.nishant.network.network.NetworkResult

interface ProductsRepository {
    suspend fun getProducts(): NetworkResult<List<ProductsDto>>
}