package com.example.machinetest_android_shijin.domain.usecase

import com.example.machinetest_android_shijin.domain.repository.CartRepository
import javax.inject.Inject

class ClearCartUseCase @Inject constructor(
    private val repository: CartRepository
) {
    suspend operator fun invoke() {
        repository.clearCart()
    }
}