package com.example.composecomponent.view

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.composecomponent.data.model.Screen

@Composable
fun SetUpNavGraph(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(
            route = Screen.Home.route
        ){
            HomeScreen(navController)
        }

        composable(
            route = Screen.Detail.route,
            arguments = listOf(navArgument("id"){
                type = NavType.IntType
                defaultValue = 9
            }
            )


        ){
            Log.d("Screen", it.arguments?.getInt("id").toString())
            Log.d("Screen", it.arguments?.getString("name") ?: "done")
            DetailScreen(navController)
        }

        composable(
            route = Screen.Profile.route,
            arguments = listOf(navArgument("id"){
                type = NavType.IntType
            },
                navArgument("name"){
                    type = NavType.StringType
                }
            )
        ){
            Log.d("Screen", it.arguments?.getInt("id").toString())
            Log.d("Screen", it.arguments?.getString("name") ?: "done")
            ProfileScreen(navController)
        }
    }
}