package com.example.composecomponent.view.nav_graph

import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.composecomponent.data.model.Screen
import com.example.composecomponent.view.DetailScreen
import com.example.composecomponent.view.HomeScreen
import com.example.composecomponent.view.ProfileScreen

fun NavGraphBuilder.homeNavGraph(navController: NavController){

    navigation(startDestination = Screen.Home.route, route = "home"){
        composable(
            route = Screen.Home.route
        ) {
            HomeScreen(navController)
        }

        composable(
            route = Screen.Detail.route,
            arguments = listOf(navArgument("id") {
                type = NavType.IntType
                defaultValue = 9
            }
            )


        ) {
            Log.d("Screen", it.arguments?.getInt("id").toString())
            Log.d("Screen", it.arguments?.getString("name").toString())
            DetailScreen(navController)
        }

        composable(
            route = Screen.Profile.route,
            arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                },
                navArgument("name") {
                    type = NavType.StringType
                }
            )
        ) {
            Log.d("Screen", it.arguments?.getInt("id").toString())
            Log.d("Screen", it.arguments?.getString("name") ?: "done")
            ProfileScreen(navController)
        }
    }
}