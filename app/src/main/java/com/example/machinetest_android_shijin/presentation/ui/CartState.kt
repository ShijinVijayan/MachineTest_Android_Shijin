package com.example.machinetest_android_shijin.presentation.ui

import com.example.machinetest_android_shijin.data.model.CartItem

data class CartState(
    val cartItems: List<CartItem> = emptyList(),
    val subtotal: Double = 0.0,
    val tax: Double = 0.0,
    val total: Double = 0.0
)