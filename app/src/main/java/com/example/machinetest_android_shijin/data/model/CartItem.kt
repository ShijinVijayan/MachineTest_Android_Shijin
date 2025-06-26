package com.example.machinetest_android_shijin.data.model


data class CartItem(
    val itemId: String,
    val itemName: String,
    val sellingPrice: Double,
    val taxPercentage: Double,
    val quantity: Int
)