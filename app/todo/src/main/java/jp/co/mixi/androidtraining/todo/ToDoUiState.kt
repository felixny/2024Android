package jp.co.mixi.androidtraining.todo

import jp.co.mixi.androidtraining.todo.data.entity.Task

data class ToDoUiState(
    val tasks: List<Task> = emptyList(),
    val inputText: String = ""
)
