package ru.jorzj.clock_ui.internal.screen.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEach
import ru.jorzj.clock_app.R
import ru.jorzj.clock_ui.internal.component.ListComponent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun ListContent(state: ListComponent.State, click: (String) -> Unit) {
    Column {
        TopAppBar(
            title = { Text(stringResource(R.string.text_clock_list)) }
        )
        Column(modifier = Modifier.fillMaxWidth()) {
            state.list.fastForEach {
                key(it) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable(onClick = { click(it) })
                            .padding(horizontal = 24.dp, vertical = 12.dp),
                        text = it
                    )
                }
            }
            HorizontalDivider()
        }
    }

}