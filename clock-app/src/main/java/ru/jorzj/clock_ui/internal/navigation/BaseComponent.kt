package ru.jorzj.clock_ui.internal.navigation

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.subscribeAsState

abstract class BaseComponent<S : ComponentState> : Component {
    protected abstract val viewModel: BaseModel<S>


    @Composable
    override fun Render() {
        val state = viewModel.state.subscribeAsState()
        Render(state = state.value)
    }

    @Composable
    abstract fun Render(state: S)


}


interface ComponentState
