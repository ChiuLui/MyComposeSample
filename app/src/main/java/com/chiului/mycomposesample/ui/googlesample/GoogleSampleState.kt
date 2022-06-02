package com.chiului.mycomposesample.ui.googlesample

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusOrder
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.chiului.mycomposesample.data.TodoItem
import com.chiului.mycomposesample.ui.theme.MyDefaultTheme
import com.chiului.mycomposesample.viewmodel.TodoViewModel
import kotlinx.coroutines.delay

/**
 * https://developer.android.google.cn/codelabs/jetpack-compose-state
 * @author    Lei
 * @date      2022/05/19 17:41
 */

@Composable
fun GoogleSampleState() {
    MyDefaultTheme {
        val viewModel: TodoViewModel = viewModel()
        TodoPage(viewModel)
    }

}

@Composable
fun TodoPage(viewModel: TodoViewModel) {
    var todoItems = viewModel.todoItems

    TodoScreen(
        items = todoItems,
        onAddItem = { viewModel.addItem(it) },
        onRemoveItem = { viewModel.removeItem(it) })
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TodoScreen(
    items: List<TodoItem>,
    onAddItem: (TodoItem) -> Unit,
    onRemoveItem: (TodoItem) -> Unit
) {


    Column(Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier
            .fillMaxWidth()
            .weight(1f)) {
            items(items) {

                Text(text = it.name, modifier = Modifier
                    .clickable { onRemoveItem(it) }
                    .padding(10.dp))
            }
        }

        var edit by remember {
            mutableStateOf("简单的TextField")
        }

        var focusRequester = FocusRequester()

        LaunchedEffect(Unit) {
            delay(1000)
            focusRequester.requestFocus()
        }

        TextField(
            value = edit,
            onValueChange = {edit = it},
            colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.Transparent),
            maxLines = 1,
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = androidx.compose.ui.text.input.ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = {
                onAddItem(TodoItem(edit))
            }),
            modifier = Modifier.focusOrder{
                this.previous
            }.focusRequester(focusRequester)
        )

        TextButton(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            onClick = { onAddItem(TodoItem("item")) }) {
            Text(text = "Add")
        }
    }
}



@Preview
@Composable
fun GoogleSampleStatePreview() {
    GoogleSampleState()
}