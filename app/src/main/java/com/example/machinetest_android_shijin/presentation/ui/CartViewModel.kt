package com.example.machinetest_android_shijin.presentation.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.machinetest_android_shijin.domain.usecase.CartUseCases
import com.example.machinetest_android_shijin.domain.usecase.ClearCartUseCase
import com.example.machinetest_android_shijin.domain.usecase.GetCartItemsUseCase
import com.example.machinetest_android_shijin.domain.usecase.UpdateQuantityUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CartViewModel @Inject constructor(
    private val useCases: CartUseCases
) : ViewModel() {

    private val _state = MutableStateFlow(CartState())
    val state: StateFlow<CartState> = _state

    init {
        getCartItems()
    }

    private fun getCartItems() {
        viewModelScope.launch {
            useCases.getCartItems().collect { items ->
                val subtotal = items.sumOf { it.sellingPrice * it.quantity }
                val tax = items.sumOf { (it.sellingPrice * it.taxPercentage / 100) * it.quantity }
                val total = subtotal + tax

                _state.value = CartState(
                    cartItems = items,
                    subtotal = subtotal,
                    tax = tax,
                    total = total
                )
            }
        }
    }

    fun onEvent(event: CartEvent) {
        when (event) {
            is CartEvent.UpdateQuantity -> {
                viewModelScope.launch {
                    useCases.updateQuantity(event.itemId, event.quantity)
                }
            }

            is CartEvent.ClearCart -> {
                viewModelScope.launch {
                    useCases.clearCart()
                }
            }
        }
    }
}