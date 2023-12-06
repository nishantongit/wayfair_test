package com.example.wayfairassignment.data.repositroy

import com.example.wayfairassignment.data.entitiy.ProductsDto
import com.example.wayfairassignment.data.service.ProductsService
import com.example.wayfairassignment.domain.repository.ProductsRepository
import com.nishant.network.network.NetworkResult
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(private val service:ProductsService):ProductsRepository {
    override suspend fun getProducts(): NetworkResult<List<ProductsDto>> {
        return service.getProducts()
    }
}