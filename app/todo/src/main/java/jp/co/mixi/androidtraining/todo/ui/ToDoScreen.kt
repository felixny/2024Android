package jp.co.mixi.androidtraining.todo.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import jp.co.mixi.androidtraining.todo.R
import jp.co.mixi.androidtraining.todo.data.entity.Task

@Composable
fun ToDoScreen(
    modifier: Modifier = Modifier,
) {
    // TODO UiStateクラスにする
    var tasks by remember { mutableStateOf(emptyList<Task>()) }
    var inputText by remember { mutableStateOf("") }

    Column(modifier = modifier) {
        TaskList(
            tasks = tasks,
            modifier = Modifier.weight(1f),
        )

        TaskTextField(
            value = inputText,
            onValueChange = { value ->
                // TODO ViewModelにイベントを送る
                inputText = value
            },
            onAddButtonClick = {
                // TODO ViewModelにイベントを送る
                tasks = listOf(Task(title = inputText)) + tasks
                inputText = ""
            },
            modifier = Modifier.fillMaxWidth(),
        )
    }
}

@Composable
private fun TaskList(
    tasks: List<Task>,
    modifier: Modifier = Modifier,
) {
    LazyColumn(modifier = modifier) {
        items(tasks) { task ->
            TaskItem(task = task)
            HorizontalDivider()
        }
    }
}

@Composable
private fun TaskTextField(
    value: String,
    onValueChange: (String) -> Unit,
    onAddButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        trailingIcon = {
            IconButton(onClick = onAddButtonClick) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = stringResource(id = R.string.add),
                )
            }
        },
    )
}

@Preview
@Composable
private fun ToDoScreenPreview() {
    MaterialTheme {
        ToDoScreen()
    }
}
