package com.example.caesarzonapplication.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun NavigationBottomBar(navController: NavHostController) {

    val currentDestination = navController.currentBackStackEntryAsState().value?.destination

    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Profile,
        BottomBarScreen.Cart,
        BottomBarScreen.Friends,
        BottomBarScreen.Wishlist
    )

    NavigationBar(
        containerColor = Color(100, 104, 208)
    ) {
        screens.forEach { screen ->
            NavigationBarItem(
                selected = currentDestination?.route == screen.route,
                icon = {
                    Icon(
                        imageVector = screen.icon,
                        contentDescription = screen.title,
                    )
                },
                onClick = {
                    if (currentDestination?.route != screen.route){
                        navController.navigate(screen.route) {
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color(238, 137, 60, 129),
                    selectedIconColor = Color(238, 137, 60, 255),
                    unselectedIconColor = Color.Black,
                    selectedTextColor = Color(238, 137, 60, 255),
                    unselectedTextColor = Color.Black
                )
            )
        }
    }
}