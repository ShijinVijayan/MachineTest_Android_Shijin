package com.example.machinetest_android_shijin.presentation.ui

import com.example.machinetest_android_shijin.data.model.Item

data class ItemListState(
    val isLoading: Boolean = false,
    val items: List<Item> = emptyList(),
    val error: String? = null
)