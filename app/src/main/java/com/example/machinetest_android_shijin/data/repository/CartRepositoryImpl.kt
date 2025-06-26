package com.example.machinetest_android_shijin.data.repository


import com.example.machinetest_android_shijin.data.local.CartDao
import com.example.machinetest_android_shijin.data.mapper.toDomain
import com.example.machinetest_android_shijin.data.mapper.toEntity
import com.example.machinetest_android_shijin.data.model.CartItem
import com.example.machinetest_android_shijin.data.model.Item
import com.example.machinetest_android_shijin.data.remote.api.ItemApi
import com.example.machinetest_android_shijin.domain.repository.CartRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CartRepositoryImpl @Inject constructor(
    private val api: ItemApi,
    private val dao: CartDao
) : CartRepository {

    override suspend fun fetchAllItems(): List<Item> {
        return api.getItems().map { it.toDomain() }
    }

    override suspend fun addItemToCart(item: Item) {
        val currentItems = dao.getCartItems()
        val existingItem = currentItems.firstOrNull()?.find { it.itemId == item.itemId }

        val newQuantity = (existingItem?.quantity ?: 0) + 1

        val cartItem = CartItem(
            itemId = item.itemId,
            itemName = item.itemName,
            sellingPrice = item.sellingPrice,
            taxPercentage = item.taxPercentage,
            quantity = newQuantity
        )

        dao.insertCartItem(cartItem.toEntity())
    }

    override fun getCartItems(): Flow<List<CartItem>> {
        return dao.getCartItems().map { list -> list.map { it.toDomain() } }
    }

    override suspend fun updateItemQuantity(itemId: String, quantity: Int) {
        dao.updateQuantity(itemId, quantity)
    }

    override suspend fun clearCart() {
        dao.clearCart()
    }
}