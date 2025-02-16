package jp.co.mixi.androidtraining.todo

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import jp.co.mixi.androidtraining.todo.data.entity.Task
import org.junit.Assert.*

import org.junit.Test

class ToDoViewModelTest {

    private val viewModel = ToDoViewModel()

    @Test
    fun setInputText() {
      viewModel.setInputText("text")
        assertEquals("text",viewModel.uiState.inputText)
    }

    @Test
    fun addTask() {
        viewModel.setInputText("text")
        viewModel.addTask()
        assertEquals(listOf(Task("text")), viewModel.uiState.tasks)
    }
}