package com.example.wayfairassignment.di

import com.example.wayfairassignment.data.service.ProductClient
import com.example.wayfairassignment.data.service.ProductsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ProductListModule {
    @Provides
    @Singleton
    fun provideService():ProductsService{
        return ProductClient.getService()
    }

}