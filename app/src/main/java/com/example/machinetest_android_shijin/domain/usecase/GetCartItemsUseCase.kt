package com.example.machinetest_android_shijin.domain.usecase

import com.example.machinetest_android_shijin.data.model.CartItem
import com.example.machinetest_android_shijin.domain.repository.CartRepository
import kotlinx.coroutines.flow.Flow

class GetCartItemsUseCase(
    private val repository: CartRepository
) {
    operator fun invoke(): Flow<List<CartItem>> =
        repository.getCartItems()
}