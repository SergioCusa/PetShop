package com.prueba.petsop.repository

import com.prueba.petsop.data.FavoriteDao
import com.prueba.petsop.model.FavoriteEntity
import com.prueba.petsop.model.Product
import com.prueba.petsop.model.ProductResponse
import com.prueba.petsop.network.ProductApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val favoriteDao: FavoriteDao,
    private val apiService: ProductApiService
) {
    suspend fun getProducts(): List<Product> {
        try {
            val response: ProductResponse = apiService.getProducts()
            val favorites = favoriteDao.getAllFavorites().first()
            return response.products.map { product ->
                product.copy(
                    isFavorite = favorites.any { it.productId == product.id }
                )
            }
        } catch (e: Exception) {
            throw e
        }
    }

    fun getFavoriteProducts(): Flow<List<Product>> = flow {
        try {
            val allProducts = apiService.getProducts().products
            favoriteDao.getAllFavorites().collect { favorites ->
                val favoriteIds = favorites.map { it.productId }

                val favoriteProducts = allProducts
                    .filter { favoriteIds.contains(it.id) }
                    .map { it.copy(isFavorite = true) } 

                emit(favoriteProducts)
            }
        } catch (e: Exception) {
            emit(emptyList())
        }
    }

    suspend fun toggleFavorite(product: Product) {
        if (product.isFavorite) {
            favoriteDao.removeFromFavorites(FavoriteEntity(product.id))
        } else {
            favoriteDao.addToFavorites(FavoriteEntity(product.id))
        }
    }
}