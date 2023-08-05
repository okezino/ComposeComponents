package com.example.composecomponent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composecomponent.ui.theme.ComposeComponentTheme
import com.example.composecomponent.ui.theme.Typography

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeComponentTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column {
                        Greeting("Android")
                        CustomText(name = "Okezino")
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
    Text(text = name,
    style = Typography.h5)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeComponentTheme {
        Column{
            Greeting("Android")
            CustomText(name = "Okezino")
        }

    }
}