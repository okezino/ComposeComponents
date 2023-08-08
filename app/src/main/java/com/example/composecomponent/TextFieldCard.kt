package com.example.composecomponent


import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp


@Composable
fun TextFieldCard() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        var text by remember {
            mutableStateOf("Type here")
        }
        var password by rememberSaveable {
            mutableStateOf("")
        }

        var visibility by remember {
            mutableStateOf(false)
        }

        var icon =
            if (visibility) R.drawable.baseline_visibility_24 else R.drawable.baseline_visibility_off_24


        OutlinedTextField(value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            placeholder = { Text("Password") },
            leadingIcon = {
                IconButton(onClick = { Log.d("Something Sub", "for here") }) {
                    Icon(imageVector = Icons.Filled.Lock, contentDescription = "Email Box")

                }
            },
            trailingIcon = {
                IconButton(onClick = { visibility = !visibility }) {
                    Icon(painter = painterResource(id = icon), contentDescription = "Mark")
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = { Log.d("Something Sub", "Search here") }
            ),
            visualTransformation = if (visibility) VisualTransformation.None else PasswordVisualTransformation()


        )

        TextField(value = text, onValueChange = { newText ->
            text = newText
        }, label = { Text("Title") },
            leadingIcon = {
                IconButton(onClick = { Log.d("Something Sub", "for here") }) {
                    Icon(imageVector = Icons.Filled.Email, contentDescription = "Email Box")

                }
            },
            trailingIcon = {
                IconButton(onClick = { Log.d("Something Sub", "for here too") }) {
                    Icon(imageVector = Icons.Filled.Check, contentDescription = "Mark")
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = { Log.d("Something Sub", "Search here") }
            )


        )

        OutlinedTextField(value = text, onValueChange = { newText ->
            text = newText
        }, label = { Text("Title") },
            leadingIcon = {
                IconButton(onClick = { Log.d("Something Sub", "for here") }) {
                    Icon(imageVector = Icons.Filled.Email, contentDescription = "Email Box")

                }
            },
            trailingIcon = {
                IconButton(onClick = { Log.d("Something Sub", "for here too") }) {
                    Icon(imageVector = Icons.Filled.Check, contentDescription = "Mark")
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = { Log.d("Something Sub", "Search here") }
            )


        )

        BasicTextField(modifier = Modifier
            .background(Color.DarkGray)
            .padding(16.dp), value = text, onValueChange = { newText ->
            text = newText
        },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = { Log.d("Something Sub", "Search here") }
            )


        )
    }
}

