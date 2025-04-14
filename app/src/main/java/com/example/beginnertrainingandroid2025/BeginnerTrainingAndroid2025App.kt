package com.example.beginnertrainingandroid2025

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.beginnertrainingandroid2025.ui.BookmarkScreen
import com.example.beginnertrainingandroid2025.ui.HomeScreen
import com.example.beginnertrainingandroid2025.ui.theme.BeginnerTrainingAndroid2025Theme
import kotlinx.serialization.Serializable

@Serializable
object Home // ホーム画面

@Serializable
object Bookmark // ブックマーク画面

data class TopLevelRoute<T : Any>(val route: T, val icon: ImageVector)

val topLevelRoutes = listOf(
    TopLevelRoute(Home, Icons.Outlined.Home),
    TopLevelRoute(Bookmark, Icons.Outlined.FavoriteBorder)
)

@Composable
fun BeginnerTrainingAndroid2025(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    BeginnerTrainingAndroid2025Theme {
        Scaffold(
            modifier = modifier,
            bottomBar = {
                BottomNavigationBar(navController = navController)
            },
        ) { padding ->
            NavHost(navController = navController, startDestination = Home) {
                // ホーム画面
                composable<Home> {
                    HomeScreen(modifier = Modifier.padding(bottom = padding.calculateBottomPadding()))
                }

                // ブックマーク画面
                composable<Bookmark> {
                    BookmarkScreen(modifier = Modifier.padding(bottom = padding.calculateBottomPadding()))
                }
            }
        }
    }
}

@Composable
fun BottomNavigationBar(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar(modifier = modifier) {
        topLevelRoutes.forEach { route ->
            NavigationBarItem(
                selected = currentDestination?.hierarchy?.any { it.hasRoute(route.route::class) } == true,
                onClick = {
                    navController.navigate(route.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        imageVector = route.icon,
                        contentDescription = null,
                    )
                },
            )
        }
    }
}