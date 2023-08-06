package com.example.composecomponent

import android.inputmethodservice.Keyboard
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composecomponent.ui.theme.Shapes


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ExpandableCard(
    title : String
) {
    var expandableState by remember { mutableStateOf(false) }
    val rotationState by animateFloatAsState(targetValue = if (expandableState) 180f else 0f)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .animateContentSize(
                animationSpec = tween(durationMillis = 300, easing = LinearOutSlowInEasing)
            ),
        shape = Shapes.medium,
        onClick = {
            expandableState = !expandableState
        }
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically,

                ) {
                Text(
                    modifier = Modifier.weight(6f),
                    text = title,
                    fontSize = MaterialTheme.typography.h6.fontSize,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                IconButton(
                    modifier = Modifier
                        .alpha(ContentAlpha.medium)
                        .weight(1f)
                        .rotate(rotationState),
                    onClick = { expandableState = !expandableState }) {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Drop Down Arrow"
                    )

                }
            }

            if (expandableState) {
                Text(
                    text = "’m currently working on Android JetPack Compose " +
                            "i’m currently working on Android JetPack Compose " +
                            "’m currently working on Android JetPack Compose m currently working on Android JetPack Compose",
                    fontSize = MaterialTheme.typography.subtitle1.fontSize,
                    fontWeight = FontWeight.Bold,
                    maxLines = 4,
                    overflow = TextOverflow.Ellipsis
                )
            }

        }

    }
}

@Composable
@Preview
fun ExpandableCardPreview() {
    ExpandableCard("my title")
}