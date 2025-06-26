package com.example.machinetest_android_shijin.domain.usecase

data class CartUseCases(
    val fetchItems: FetchItemsUseCase,
    val addToCart: AddItemToCartUseCase,
    val getCartItems: GetCartItemsUseCase,
    val updateQuantity: UpdateQuantityUseCase,
    val clearCart: ClearCartUseCase
)