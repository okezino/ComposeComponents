package com.example.composecomponent.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.composecomponent.data.model.Screen

@Composable
fun HomeScreen(navController: NavController) {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Column{

            Text(
                modifier = Modifier.clickable {
                    navController.navigate(route = Screen.Profile.passNameAndId(3, "sandra"))
                },
                text = "Home",
                color = MaterialTheme.colors.primary,
                fontSize = MaterialTheme.typography.h2.fontSize,
                fontWeight = FontWeight.Bold
            )

            Text(
                modifier = Modifier.clickable {
                    navController.navigate(route = Screen.Detail.passNameAndId(6, "okezino"))
                },
                text = "Detail",
                color = MaterialTheme.colors.primary,
                fontSize = MaterialTheme.typography.h5.fontSize,
                fontWeight = FontWeight.Bold
            )

            Text(
                modifier = Modifier.clickable {
                    navController.navigate(route = "auth")
                },
                text = "Auth feature",
                color = MaterialTheme.colors.primary,
                fontSize = MaterialTheme.typography.h5.fontSize,
                fontWeight = FontWeight.Bold
            )

        }


    }

}

@Composable
@Preview(showBackground = true)
fun HomeScreenPreview() {
    HomeScreen(navController = rememberNavController())
}