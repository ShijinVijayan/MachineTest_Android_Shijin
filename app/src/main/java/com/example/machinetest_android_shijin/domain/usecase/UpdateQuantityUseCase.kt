
package com.example.machinetest_android_shijin.domain.usecase

import com.example.machinetest_android_shijin.domain.repository.CartRepository

class UpdateQuantityUseCase(
    private val repository: CartRepository
) {
    suspend operator fun invoke(itemId: String, quantity: Int) {
        repository.updateItemQuantity(itemId, quantity)
    }
}