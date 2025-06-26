package com.example.machinetest_android_shijin.data.remote.api

import com.example.machinetest_android_shijin.data.remote.dto.ItemDto
import retrofit2.http.GET



interface ItemApi {
    @GET("/")
    suspend fun getItems(): List<ItemDto>
}