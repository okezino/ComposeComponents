package com.example.composecomponent

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composecomponent.ui.theme.Shapes

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun GoogleButton(){
    var clicked by remember { mutableStateOf(false) }

        Surface(onClick = {clicked = !clicked}
        , shape = Shapes.medium,
        border = BorderStroke(width = 1.dp, color = Color.LightGray),
        color = MaterialTheme.colors.surface) {

            Row {
                Icon(painter = painterResource(id = R.drawable.ic_google_image_24dp), contentDescription = "Google Button" )
                Text(text= "Sign Up with Google")
            }

    }
}

@Composable
@Preview
private fun GoogleButtonPreview(){
    GoogleButton()
}