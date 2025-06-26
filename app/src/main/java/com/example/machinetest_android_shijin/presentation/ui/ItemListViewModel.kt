package com.example.machinetest_android_shijin.presentation.ui


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.machinetest_android_shijin.domain.usecase.AddItemToCartUseCase
import com.example.machinetest_android_shijin.domain.usecase.FetchItemsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemListViewModel @Inject constructor(
    private val fetchItemsUseCase: FetchItemsUseCase,
    private val addItemToCartUseCase: AddItemToCartUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(ItemListState())
    val state: StateFlow<ItemListState> = _state

    fun onEvent(event: ItemListEvent) {
        when (event) {
            is ItemListEvent.LoadItems -> {
                viewModelScope.launch {
                    _state.value = _state.value.copy(isLoading = true)
                    try {
                        val items = fetchItemsUseCase()
                        _state.value = _state.value.copy(
                            isLoading = false,
                            items = items
                        )
                    } catch (e: Exception) {
                        _state.value = _state.value.copy(
                            isLoading = false,
                            error = e.message
                        )
                    }
                }
            }

            is ItemListEvent.AddToCart -> {
                viewModelScope.launch {
                    addItemToCartUseCase(event.item)
                }
            }
        }
    }
}
