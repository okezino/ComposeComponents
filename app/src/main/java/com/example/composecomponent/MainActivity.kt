package com.example.composecomponent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                    Greeting(name = "Meaning")

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {

        Box(
            modifier = Modifier
                .background(Color.Blue)
        ) {

            Text(text = "I Love Android", fontSize = 40.sp)

        }

    }

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
        Greeting(name = "Meaning")

    }
}