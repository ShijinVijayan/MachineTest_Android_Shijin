package com.example.machinetest_android_shijin.presentation.ui

sealed class CartEvent {
    data class UpdateQuantity(val itemId: String, val quantity: Int) : CartEvent()
    object ClearCart : CartEvent()
}