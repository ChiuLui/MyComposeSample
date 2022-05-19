package com.chiului.mycomposesample.ui.googlesample

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.layout
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * https://developer.android.google.cn/codelabs/jetpack-compose-layouts$
 * @author    Lei
 * @date      2022/05/19 17:41
 */

@Composable
fun GoogleSampleSimpleCustomLayout() {
    Column {
        Text("Hi there!", Modifier.padding(top = 32.dp))
        Text("Hi there!", Modifier.firstBaselineToTop(32.dp))
        MyOwnColumn() {
            Text("MyOwnColumn")
            Text("places items")
            Text("vertically.")
            Text("We've done it by hand!")
        }
    }

}



fun Modifier.firstBaselineToTop(
    firstBaselineToTop: Dp
) = this.then(
    layout {measurable, constraints ->
        val placeable = measurable.measure(constraints)

        check(placeable[FirstBaseline] != AlignmentLine.Unspecified)
        val firstBaseline = placeable[FirstBaseline]

        val placeableY = firstBaselineToTop.roundToPx() - firstBaseline
        val height = placeable.height + placeableY

        layout(placeable.width, height){
            placeable.placeRelative(0, placeableY)
        }

    }
)

@Composable
fun MyOwnColumn(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
){
    Layout(modifier = modifier, content = content) {measurables, constraints ->
        val placeables = measurables.map { measurable ->
            measurable.measure(constraints)
        }

        var yPosition = 0

        layout(constraints.maxWidth, constraints.maxHeight){
            placeables.forEach{ placeable ->
                placeable.placeRelative(x = 0, y = yPosition)
                yPosition += placeable.height
            }
        }

    }
}
