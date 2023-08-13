package com.example.composecomponent.view.nav_graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.composecomponent.data.model.Screen
import com.example.composecomponent.view.auth.LoginScreen
import com.example.composecomponent.view.auth.SignUpScreen

fun NavGraphBuilder.authNavGraph(navController: NavController){

    navigation(startDestination = Screen.Login.route, route = "auth"){
        composable(
            route = Screen.Login.route
        ) {
            LoginScreen(navController)
        }

        composable(
            route = Screen.SignUp.route
        ) {
            SignUpScreen(navController = navController)
        }
    }

}