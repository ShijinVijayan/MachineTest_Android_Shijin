package com.example.machinetest_android_shijin.data.local


import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CartItemEntity::class], version = 1, exportSchema = false)
abstract class ShoppingCartDatabase : RoomDatabase() {
    abstract fun cartDao(): CartDao
}