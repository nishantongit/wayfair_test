package com.example.wayfairassignment.domain.usecase

import com.example.wayfairassignment.data.entitiy.ProductsDto
import com.example.wayfairassignment.domain.repository.ProductsRepository
import com.nishant.network.network.NetworkResult
import javax.inject.Inject


class GetProductListUseCase @Inject constructor(private val repository: ProductsRepository) {
    suspend fun getProducts(): NetworkResult<List<ProductsDto>> {
        return repository.getProducts()
    }
}