package com.example.beginnertrainingandroid2025

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.beginnertrainingandroid2025.ui.BookmarkScreen
import com.example.beginnertrainingandroid2025.ui.HomeScreen
import kotlinx.serialization.Serializable
import org.jetbrains.compose.ui.tooling.preview.Preview

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
@Preview
fun App(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    MaterialTheme {
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
                selected = currentDestination?.hierarchy?.any { it.hasRoute(route.route::class.simpleName!!, null) } == true,
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