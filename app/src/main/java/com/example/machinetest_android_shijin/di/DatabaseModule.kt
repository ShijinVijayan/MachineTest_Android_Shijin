package com.example.machinetest_android_shijin.di

import android.content.Context
import androidx.room.Room
import com.example.machinetest_android_shijin.data.local.CartDao
import com.example.machinetest_android_shijin.data.local.ShoppingCartDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): ShoppingCartDatabase =
        Room.databaseBuilder(
            context,
            ShoppingCartDatabase::class.java,
            "shopping_cart.db"
        ).build()

    @Provides
    @Singleton
    fun provideCartDao(database: ShoppingCartDatabase): CartDao =
        database.cartDao()
}