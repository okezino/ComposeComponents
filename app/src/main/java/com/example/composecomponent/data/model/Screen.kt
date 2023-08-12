package com.example.composecomponent.data.model

sealed class Screen(val route : String){
    object Home: Screen("home")
    object Profile : Screen("profile")
}
