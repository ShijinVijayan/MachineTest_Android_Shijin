package com.example.machinetest_android_shijin.data.mapper

import com.example.machinetest_android_shijin.data.model.Item
import com.example.machinetest_android_shijin.data.remote.dto.ItemDto

fun ItemDto.toDomain(): Item {
    return Item(
        itemId = this.itemID,
        itemName = this.itemName,
        sellingPrice = this.sellingPrice,
        taxPercentage = this.taxPercentage
    )
}