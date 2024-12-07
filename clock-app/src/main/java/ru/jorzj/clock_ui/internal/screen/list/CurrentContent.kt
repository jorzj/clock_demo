package ru.jorzj.clock_ui.internal.screen.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.jorzj.clock_ui.internal.component.CurrentComponent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun CurrentContent(state: CurrentComponent.State, openList: () -> Unit) {
    Column {

        TopAppBar(
            title = { Text(state.timeInSeconds.format()) }
        )
        Button(onClick = openList, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Main Button")
        }
    }
}

private fun Int.format(): String {
    val hours = this / 3600
    val minutes = (this % 3600) / 60
    val secs = this % 60
    return String.format("%02d:%02d:%02d", hours, minutes, secs)
}