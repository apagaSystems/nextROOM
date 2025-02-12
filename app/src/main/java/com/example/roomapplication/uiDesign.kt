package com.example.roomapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.roomapplication.ui.theme.Pink40


@Composable
fun TestModifier(
    testText: String,
    myModifier: Modifier,
    combinedModifier: Modifier,
    testFontSize: TextUnit
) {
    Text(
        text = testText,
        modifier = combinedModifier.then(myModifier),
        fontSize = testFontSize
    )
}


@Preview
@Composable
private fun TestModifierPreview() {
    val text = listOf(
        stringResource(id = R.string.text_1),
        stringResource(id = R.string.text_2),
        stringResource(id = R.string.text_3)
    )
    val combinedModifier = listOf(
        Modifier.background(color = Color.Cyan),
        Modifier.background(color = Color.Yellow),
        Modifier.background(color = Color.Gray)
    )
    val testFontSize = listOf(28.sp, 22.sp, 18.sp)
    val paddingSize: Dp = 360.dp
    val testModifier = Modifier
        .width(paddingSize)
        .padding(24.dp)
        .border(2.dp, color = Pink40)
    Column {
        repeat(3) {i->
            TestModifier(
                testText = text[i],
                myModifier = testModifier,
                combinedModifier[i],
                testFontSize[i]
            )

        }

    }
}