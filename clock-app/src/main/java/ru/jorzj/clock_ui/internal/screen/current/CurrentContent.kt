package ru.jorzj.clock_ui.internal.screen.current

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.jorzj.clock_app.R
import ru.jorzj.clock_ui.internal.component.CurrentComponent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun CurrentContent(state: CurrentComponent.State, openList: () -> Unit) {
    Column {

        TopAppBar(
            title = { Text(stringResource(R.string.text_clock_time)) }
        )

        Column(
            modifier = Modifier.padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            CityCard(name = state.timeZone, time = state.timeInSeconds.format())

            Button(onClick = openList, modifier = Modifier.fillMaxWidth()) {
                Text(text = stringResource(R.string.text_clock_select_city))
            }
        }

    }
}

@Composable
private fun CityCard(name: String, time: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.background,
                shape = MaterialTheme.shapes.medium
            )
            .padding(horizontal = 12.dp, vertical = 12.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = name,
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = time,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.secondary
        )
    }

}

private fun Int.format(): String {
    val hours = this / 3600
    val minutes = (this % 3600) / 60
    val secs = this % 60
    return String.format("%02d:%02d:%02d", hours, minutes, secs)
}