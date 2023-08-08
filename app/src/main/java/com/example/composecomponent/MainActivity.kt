package com.example.composecomponent

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composecomponent.data.domain.PersonRepository
import com.example.composecomponent.ui.theme.ComposeComponentTheme
import com.example.composecomponent.ui.theme.Typography

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            var section = listOf<String>("John","Peter", "Mark")

            ComposeComponentTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(color = Color.LightGray),
                        horizontalAlignment = Alignment.CenterHorizontally

                    ) {
                      //  GoogleButton(onClicked = {})
                       // CoilImageLoaderNew()
                       // TextFieldCard()
//                        GradientButton {
//                            Log.d("", "")
//                        }
//                        LazyColumn(
//                            contentPadding = PaddingValues(all = 12.dp),
//                            verticalArrangement = Arrangement.spacedBy(12.dp)
//                        ){
//                            itemsIndexed(items = PersonRepository.getPersons(),
//                            key = {index , person ->
//                                person.id
//                            }){ index, person ->
//                                PersonItemView(person = person)
//                            }
//
//                        }

                        LazyColumn(
                            contentPadding = PaddingValues(all = 12.dp),
                            verticalArrangement = Arrangement.spacedBy(12.dp)
                        ){
                            section.forEach{ sec ->
                                stickyHeader {
                                    Text(
                                        modifier = Modifier.fillMaxWidth()
                                            .background(Color.White)
                                            .padding(12.dp),
                                        text = "Section $sec")

                                }

                                items(10){ value->
                                    Text(
                                        modifier = Modifier.fillMaxWidth()
                                            .padding(12.dp),
                                        text = "item  $value from section $sec")
                                }
                            }


                        }
                    }

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "I Love Android", fontSize = 40.sp)
}

/**
 * Learn about Box and nested Box
 */
@Composable
fun BoxBuilding(name: String) {
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

/**
 * Learn about Custom Text
 */
@Composable
fun CustomText(name: String) {
    Text(
        text = name,
        style = Typography.h5
    )
}

/**
 * Learn about Text Selectable and DisableSelectable
 */
@Composable
fun TextSelectable() {
    SelectionContainer {
        Column {
            Text(text = "Hello World!!")
            DisableSelection {
                Text(text = "Hello World!!")
            }
            Text(text = "Hello World!!")
        }
    }
}

/**
 * Learn about Column and extended Column functions
 */
@Composable
fun ColumnScope.CustomBuild(weight: Float, color: Color = MaterialTheme.colors.primary) {
    Surface(
        modifier = Modifier
            .width(200.dp)
            .weight(weight),
        color = color
    ) {}

}

/**
 * Learn about Row and extended Row functions
 */
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

/**
 * Learn about Custom text using build annotation using with style paragraphStyle or SpanStyle
 */
//@Composable
//fun CustomTextView() {
//    Text(
//        buildAnnotatedString {
//            withStyle(style = ParagraphStyle(textAlign = TextAlign.Center)) {
//                withStyle(
//                    style = SpanStyle(
//                        color = Color.Blue,
//                        fontSize = MaterialTheme.typography.h5.fontSize
//                    )
//                ) {
//                    append("A")
//                }
//
//                append("B")
//                append("C")
//                append("D")
//            }
//        }, modifier = Modifier.width(200.dp)
//    )
//
//}

/**
 * Learn about Custom text using build annotation using with style paragraphStyle or SpanStyle
 */
@Composable
fun CustomTextView3() {
    Text(text = "Hello World".repeat(30), maxLines = 3, overflow = TextOverflow.Ellipsis)

}

/**
 * Learn about Super and SubScript
 */
@Composable
fun SuperScripText(normalText: String, superText: String, subText : String) {
    Text(buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                fontSize = MaterialTheme.typography.subtitle1.fontSize
            )
        ) {
            append(normalText)
        }
        withStyle(
            style = SpanStyle(
                fontSize = MaterialTheme.typography.overline.fontSize,
                fontWeight = FontWeight.Normal,
                baselineShift = BaselineShift.Subscript
        )) {
            append(superText)
        }

        withStyle(
            style = SpanStyle(
                fontSize = MaterialTheme.typography.overline.fontSize,
                fontWeight = FontWeight.Normal,
                baselineShift = BaselineShift.Superscript
            )) {
            append(subText)
        }
    }, modifier = Modifier)

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeComponentTheme {
        TextFieldCard()
    }
}