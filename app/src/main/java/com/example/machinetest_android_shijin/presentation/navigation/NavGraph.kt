package com.example.machinetest_android_shijin.presentation.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.machinetest_android_shijin.presentation.screens.CartScreen
import com.example.machinetest_android_shijin.presentation.screens.ItemListScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController, startDestination = "item_list") {
        composable("item_list") {
            ItemListScreen(onCartClick = {
                navController.navigate("cart")
            })
        }
        composable("cart") {
            CartScreen(onBackClick = {
                navController.popBackStack()
            })
        }
    }
}