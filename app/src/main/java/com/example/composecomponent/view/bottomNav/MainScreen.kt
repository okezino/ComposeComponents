package com.example.composecomponent.view.bottomNav

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentColor
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen() {

    val navController = rememberNavController()

    Scaffold(bottomBar = { BottomBar(navController = navController)}) {

        BottomNavGraph(navController = navController)

    }
}

@Composable
fun BottomBar(navController: NavHostController) {

    val screens = listOf(
        BottomNavScreen.DashBoard,
        BottomNavScreen.Settings,
        BottomNavScreen.Transaction
    )

    val navBarBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBarBackStackEntry?.destination

    BottomNavigation {

        screens.forEach {
            AddItem(
                screen = it,
                currentDestination = currentDestination,
                navController = navController
            )
        }

    }

}

@Composable
fun RowScope.AddItem(
    screen: BottomNavScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {

    BottomNavigationItem(selected = currentDestination?.hierarchy?.any {
        it.route == screen.routes
    } == true,
        label = {
            Text(text = screen.title)
        },
        icon = {
            Icon(
                imageVector = screen.icon,
                contentDescription = "navigations"
            )
        },

        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),

        onClick = {
            navController.navigate(screen.routes){
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        })

}


@Composable
fun BottomNavGraph(navController: NavHostController) {

    NavHost(navController = navController, startDestination = BottomNavScreen.DashBoard.routes) {

        composable(route = BottomNavScreen.DashBoard.routes) {
            DashBoardScreen()
        }

        composable(route = BottomNavScreen.Settings.routes) {
            SettingsScreen()
        }

        composable(route = BottomNavScreen.Transaction.routes) {
            TransactionScreen()
        }

    }

}