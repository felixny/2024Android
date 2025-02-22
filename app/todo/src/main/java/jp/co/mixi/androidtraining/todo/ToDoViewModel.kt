package jp.co.mixi.androidtraining.todo

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import jp.co.mixi.androidtraining.todo.data.entity.Task

class ToDoViewModel : ViewModel() {

    var uiState by mutableStateOf(ToDoUiState())

    fun setInputText(text: String){
        uiState = uiState.copy(inputText = text)
    }

    fun addTask() {
        uiState = uiState.copy(
            tasks = listOf(Task(uiState.inputText)) + uiState.tasks,
            inputText = ""
        )
    }
}