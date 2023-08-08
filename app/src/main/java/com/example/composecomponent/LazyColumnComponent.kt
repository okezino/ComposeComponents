package com.example.composecomponent

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composecomponent.data.model.Person

@Composable
fun PersonItemView(person: Person) {

    Row(
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth()
            .padding(24.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(text = "${person.age}")
        Text(text = person.firstName)
        Text(text = person.lastName)
    }

}


@Composable
@Preview
fun PersonItemPreView() {
    PersonItemView(person = Person("okeh", "joseph", 31))
}
