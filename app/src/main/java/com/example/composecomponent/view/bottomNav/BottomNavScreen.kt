package com.example.composecomponent.view.bottomNav

import android.graphics.drawable.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavScreen(
    val routes: String, val title: String, val icon: ImageVector
) {
    object DashBoard : BottomNavScreen(
        routes = "dashBoard", title = "DashBoard", icon = Icons.Default.Home
    )

    object Settings : BottomNavScreen(
        routes = "settings", title = "Settings", icon = Icons.Default.Settings
    )

    object Transaction : BottomNavScreen(
        routes = "transaction", title = "Transact", icon = Icons.Default.Person
    )
}
