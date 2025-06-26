package com.example.machinetest_android_shijin.domain.usecase
import com.example.machinetest_android_shijin.data.model.Item
import com.example.machinetest_android_shijin.domain.repository.CartRepository
import javax.inject.Inject


class AddItemToCartUseCase @Inject constructor(
    private val repository: CartRepository
) {
    suspend operator fun invoke(item: Item) {
        repository.addItemToCart(item)
    }
}