package com.example.machinetest_android_shijin.domain.usecase

import com.example.machinetest_android_shijin.data.model.Item
import com.example.machinetest_android_shijin.domain.repository.CartRepository

class FetchItemsUseCase(
    private val repository: CartRepository
) {
    suspend operator fun invoke(): List<Item> {
        return repository.fetchAllItems()
    }
}