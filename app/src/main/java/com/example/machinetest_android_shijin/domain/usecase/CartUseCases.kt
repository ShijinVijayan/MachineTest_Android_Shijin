package com.example.machinetest_android_shijin.domain.usecase

import javax.inject.Inject

data class CartUseCases @Inject constructor(
    val fetchItems: FetchItemsUseCase,
    val addToCart: AddItemToCartUseCase,
    val getCartItems: GetCartItemsUseCase,
    val updateQuantity: UpdateQuantityUseCase,
    val clearCart: ClearCartUseCase
)