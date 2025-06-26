package com.example.machinetest_android_shijin.data.mapper

import com.example.machinetest_android_shijin.data.local.CartItemEntity
import com.example.machinetest_android_shijin.data.model.CartItem

fun CartItemEntity.toDomain(): CartItem {
    return CartItem(
        itemId = itemId,
        itemName = itemName,
        sellingPrice = sellingPrice,
        taxPercentage = taxPercentage,
        quantity = quantity
    )
}

fun CartItem.toEntity(): CartItemEntity {
    return CartItemEntity(
        itemId = itemId,
        itemName = itemName,
        sellingPrice = sellingPrice,
        taxPercentage = taxPercentage,
        quantity = quantity
    )
}