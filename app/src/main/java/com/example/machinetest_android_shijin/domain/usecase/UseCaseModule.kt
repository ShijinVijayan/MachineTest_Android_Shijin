package com.example.machinetest_android_shijin.domain.usecase

import com.example.machinetest_android_shijin.domain.repository.CartRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideCartUseCases(repo: CartRepository): CartUseCases {
        return CartUseCases(
            fetchItems = FetchItemsUseCase(repo),
            addToCart = AddItemToCartUseCase(repo),
            getCartItems = GetCartItemsUseCase(repo),
            updateQuantity = UpdateQuantityUseCase(repo),
            clearCart = ClearCartUseCase(repo)
        )
    }
}