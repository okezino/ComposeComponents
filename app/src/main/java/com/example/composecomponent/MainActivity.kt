package com.example.composecomponent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composecomponent.ui.theme.ComposeComponentTheme
import com.example.composecomponent.ui.theme.Typography

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeComponentTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        modifier = Modifier
                            .height(500.dp)
                            .width(500.dp)
                            .background(Color.LightGray),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        CustomBuild(weight = 1f, MaterialTheme.colors.secondary)
                        CustomBuild(weight = 1f)
                        CustomBuild(weight = 1f, MaterialTheme.colors.secondary)
                        CustomBuild(weight = 1f)


                    }

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun CustomText(name: String) {
    Text(
        text = name,
        style = Typography.h5
    )
}

@Composable
fun ColumnScope.CustomBuild(weight: Float, color: Color = MaterialTheme.colors.primary) {
    Surface(
        modifier = Modifier
            .width(200.dp)
            .weight(weight),
        color = color
    ) {}

}

@Composable
fun RowScope.CustomBuild(weight: Float, color: Color = MaterialTheme.colors.primary) {
    Surface(
        modifier = Modifier
            .width(50.dp)
            .height(50.dp)
            .weight(weight),
        color = color
    ) {}

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeComponentTheme {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment =  Alignment.CenterVertically
        ) {
            CustomBuild(weight = 1f, MaterialTheme.colors.secondary)
            CustomBuild(weight = 1f)
            CustomBuild(weight = 1f, MaterialTheme.colors.secondary)
            CustomBuild(weight = 1f)


        }

    }
}