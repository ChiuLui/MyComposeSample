package com.chiului.mycomposesample.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.chiului.mycomposesample.data.TodoItem

/**
 * $
 * @author    Lei
 * @date      2022/05/20 10:40
 */
class TodoViewModel: ViewModel() {
    // state: todoItems
//    private var _todoItems = MutableLiveData(listOf<TodoItem>())
//    val todoItems: LiveData<List<TodoItem>> = _todoItems
    var todoItems = mutableStateListOf<TodoItem>()

    // event: addItem
    fun addItem(item: TodoItem) {
        todoItems.add(item)
    }

    // event: removeItem
    fun removeItem(item: TodoItem) {
        todoItems.remove(item)
    }

}