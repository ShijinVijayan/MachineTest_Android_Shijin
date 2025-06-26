package com.example.machinetest_android_shijin.presentation.ui

import com.example.machinetest_android_shijin.data.model.Item

sealed class ItemListEvent {
    object LoadItems : ItemListEvent()
    data class AddToCart(val item: Item) : ItemListEvent()
}