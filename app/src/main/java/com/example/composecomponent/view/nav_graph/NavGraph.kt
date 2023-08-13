package com.example.composecomponent.view.nav_graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.composecomponent.view.nav_graph.authNavGraph
import com.example.composecomponent.view.nav_graph.homeNavGraph

@Composable
fun SetUpNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = "home",
        route = "root"
    ) {
        homeNavGraph(navController = navController)

        authNavGraph(navController = navController)
    }
}