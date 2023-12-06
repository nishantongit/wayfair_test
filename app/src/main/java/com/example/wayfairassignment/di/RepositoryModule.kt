package com.example.wayfairassignment.di

import com.example.wayfairassignment.data.repositroy.ProductRepositoryImpl
import com.example.wayfairassignment.domain.repository.ProductsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindsRepo(repo:ProductRepositoryImpl): ProductsRepository
}