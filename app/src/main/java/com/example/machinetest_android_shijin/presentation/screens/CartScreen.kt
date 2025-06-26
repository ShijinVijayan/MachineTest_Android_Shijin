package com.example.machinetest_android_shijin.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.machinetest_android_shijin.data.model.CartItem
import com.example.machinetest_android_shijin.presentation.ui.CartEvent
import com.example.machinetest_android_shijin.presentation.ui.CartViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen(
    viewModel: CartViewModel = hiltViewModel(),
    onBackClick: () -> Unit
) {
    val state = viewModel.state.collectAsState().value

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Your Cart") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = {
                        viewModel.onEvent(CartEvent.ClearCart)
                    }) {
                        Icon(Icons.Default.Delete, contentDescription = "Clear Cart")
                    }
                }
            )
        }
    ) { padding ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(padding)) {

            // Cart Items List
            LazyColumn(modifier = Modifier.weight(1f)) {
                items(state.cartItems) { item: CartItem ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(text = item.itemName, style = MaterialTheme.typography.titleMedium)
                            Text(text = "₹${item.sellingPrice} x ${item.quantity}")
                        }
                        Row {
                            IconButton(onClick = {
                                val newQty = (item.quantity - 1).coerceAtLeast(1)
                                viewModel.onEvent(CartEvent.UpdateQuantity(item.itemId, newQty))
                            }) {
                                Icon(Icons.Default.Delete, contentDescription = "Remove")
                            }
                            Text("${item.quantity}", modifier = Modifier.align(Alignment.CenterVertically))
                            IconButton(onClick = {
                                viewModel.onEvent(CartEvent.UpdateQuantity(item.itemId, item.quantity + 1))
                            }) {
                                Icon(Icons.Default.Add, contentDescription = "Add")
                            }
                        }
                    }
                }
            }

            Divider()

            // Summary
            Column(Modifier.padding(16.dp)) {
                Text("Subtotal: ₹${state.subtotal}")
                Text("Tax: ₹${state.tax}")
                Text("Total: ₹${state.total}", style = MaterialTheme.typography.titleLarge)
            }
        }
    }
}