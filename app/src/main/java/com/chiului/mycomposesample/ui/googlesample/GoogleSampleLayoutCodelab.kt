package com.chiului.mycomposesample.ui.googlesample

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.chiului.mycomposesample.ui.theme.MyComposeSampleTheme
import kotlinx.coroutines.launch

/**
 * https://developer.android.google.cn/codelabs/jetpack-compose-layouts$
 * @author    Lei
 * @date      2022/05/19 17:41
 */

@Composable
fun GoogleSampleLayoutsCodelab() {
    MyComposeSampleTheme {
        LayoutsCodelab()
    }
}

@Composable
fun LayoutsCodelab() {
    Scaffold(topBar = {
        TopAppBar(title = {
            Text(text = "LayoutsCodelab")
        }, actions = {
            IconButton({}) {
                Icon(Icons.Filled.Favorite, contentDescription = null)
            }
        })
    }) { innerPadding ->
        BodyContent(
            Modifier
                .padding(innerPadding)
                .padding(8.dp))
    }
}

@Composable
private fun BodyContent(modifier: Modifier) {
    Column(modifier) {
        Text(text = "Hi there!")
        Text(text = "Thanks for going through the Layouts codelab")
        Text("Hi there!", Modifier.padding(top = 32.dp))
        Text("Hi there!", Modifier.firstBaselineToTop(32.dp))
        LazyList()
    }
}


@Preview(showBackground = true)
@Composable
fun GoogleSampleLayoutsCodelabPreview() {
    MyComposeSampleTheme {
        GoogleSampleLayoutsCodelab()
    }
}

//@Preview(showBackground = true)
@Composable
fun SimpleList() {
    val scrollState = rememberScrollState()
    Column (Modifier.verticalScroll(scrollState)) {
        repeat(100) {
            Text("Item #$it")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LazyList() {
    val listSize = 100
    val scrollState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    Column {

        Row{
            Button(onClick = {
                coroutineScope.launch {
                    scrollState.animateScrollToItem(0)
                }
            }) {
                Text(text = "Scroll to the top")
            }
            Button(onClick = {
                coroutineScope.launch {
                    scrollState.animateScrollToItem(listSize - 1)
                }
            }) {
                Text(text = "Scroll to the end")
            }
        }
        LazyColumn(state = scrollState){
            items(100){
                ImageListItem(it)
            }
        }
    }


}

@Composable
fun ImageListItem(index: Int){
    Row(verticalAlignment = Alignment.CenterVertically) {

        Image(
            painter = rememberImagePainter(
                data = "https://developer.android.com/images/brand/Android_Robot.png"
            ),
            contentDescription = "Android Logo",
            modifier = Modifier.size(50.dp)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = "Item #$index", style = MaterialTheme.typography.subtitle1)
    }
}
