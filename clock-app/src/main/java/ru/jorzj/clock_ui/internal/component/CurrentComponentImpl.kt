package ru.jorzj.clock_ui.internal.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.instancekeeper.getOrCreate
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.serialization.Serializable
import ru.jorzj.clock_ui.internal.component.model.CurrentModel
import ru.jorzj.clock_ui.internal.dagger.Router
import ru.jorzj.clock_ui.internal.navigation.BaseComponent
import ru.jorzj.clock_ui.internal.navigation.ComponentState
import ru.jorzj.clock_ui.internal.screen.list.CurrentContent
import ru.jorzj.domain.uc.GetTime


abstract class CurrentComponent : BaseComponent<CurrentComponent.State>() {

    @Immutable
    @Serializable
    data class State(
        val timeInSeconds: Int = 0,
        val timeZone: String = ""
    ) : ComponentState


    fun interface Factory {
        operator fun invoke(componentContext: ComponentContext): CurrentComponent
    }

}

class CurrentComponentImpl @AssistedInject constructor(
    @Assisted componentContext: ComponentContext,
    private val router: Router,
    private val getTime: GetTime,
) : CurrentComponent(),
    ComponentContext by componentContext {
    override val viewModel =
        instanceKeeper.getOrCreate {
            CurrentModel(
                componentContext,
                getTime,
                router
            )
        }


    @AssistedFactory
    interface Factory : CurrentComponent.Factory {
        override fun invoke(componentContext: ComponentContext): CurrentComponentImpl
    }

    private fun openList() {
        viewModel.openList()
    }

    @Composable
    override fun Render(state: State) {
        CurrentContent(state, ::openList)
    }
}
