package com.example.machinetest_android_shijin.domain.usecase

import com.example.machinetest_android_shijin.data.model.CartItem
import com.example.machinetest_android_shijin.domain.repository.CartRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCartItemsUseCase @Inject constructor(
    private val repository: CartRepository
) {
    operator fun invoke(): Flow<List<CartItem>> =
        repository.getCartItems()
}