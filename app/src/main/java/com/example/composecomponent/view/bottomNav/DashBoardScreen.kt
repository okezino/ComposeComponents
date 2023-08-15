package com.example.composecomponent.view.bottomNav

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.composecomponent.data.model.Screen

@Composable
fun DashBoardScreen(navController: NavController) {

    Box(
        modifier = Modifier.fillMaxSize()
            .background(Color.Magenta),
        contentAlignment = Alignment.Center
    ) {

        Text(
            modifier = Modifier.clickable {
                navController.navigate(route = Screen.Home.route)
            }, text = "DashBoardScreen",
            fontSize = MaterialTheme.typography.h4.fontSize,
            fontWeight = FontWeight.Bold
        )


    }

}

@Composable
@Preview(showBackground = true)
fun DashBoardScreenPreview() {
    DashBoardScreen(navController = rememberNavController())
}