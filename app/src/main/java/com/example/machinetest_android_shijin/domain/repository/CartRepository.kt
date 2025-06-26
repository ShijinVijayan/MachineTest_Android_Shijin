package com.example.machinetest_android_shijin.domain.repository

import com.example.machinetest_android_shijin.data.model.CartItem
import com.example.machinetest_android_shijin.data.model.Item
import kotlinx.coroutines.flow.Flow

interface CartRepository {

    suspend fun fetchAllItems(): List<Item>

    suspend fun addItemToCart(item: Item)

    fun getCartItems(): Flow<List<CartItem>>

    suspend fun updateItemQuantity(itemId: String, quantity: Int)

    suspend fun clearCart()
}
