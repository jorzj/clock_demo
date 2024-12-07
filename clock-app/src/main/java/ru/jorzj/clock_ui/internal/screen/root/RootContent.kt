package ru.jorzj.clock_ui.internal.screen.root

import androidx.compose.runtime.Composable
import ru.jorzj.clock_ui.internal.navigation.Component
import ru.jorzj.clock_ui.internal.theme.Demo_ClockTheme

@Composable
internal fun RootContent(modifier: Component) {
    Demo_ClockTheme {
        modifier.Render()
    }
}