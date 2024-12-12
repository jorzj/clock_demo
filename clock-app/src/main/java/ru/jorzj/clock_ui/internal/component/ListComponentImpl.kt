package ru.jorzj.clock_ui.internal.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.instancekeeper.getOrCreate
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import ru.jorzj.clock_ui.internal.component.model.ListModel
import ru.jorzj.clock_ui.internal.dagger.Router
import ru.jorzj.clock_ui.internal.navigation.BaseComponent
import ru.jorzj.clock_ui.internal.navigation.ComponentState
import ru.jorzj.clock_ui.internal.screen.list.ListContent
import ru.jorzj.domain.uc.GetListTimeZones
import ru.jorzj.domain.uc.SaveTimeZone

abstract class ListComponent :
    BaseComponent<ListComponent.State>() {
    @Immutable
    data class State(val list: List<String>) : ComponentState

    fun interface Factory {
        operator fun invoke(componentContext: ComponentContext): ListComponent
    }
}

class ListComponentImpl @AssistedInject constructor(
    @Assisted componentContext: ComponentContext,
    getListTimeZones: GetListTimeZones,
    saveTimeZone: SaveTimeZone,
    router: Router
) : ListComponent(),
    ComponentContext by componentContext {


    @AssistedFactory
    interface Factory : ListComponent.Factory {
        override fun invoke(componentContext: ComponentContext): ListComponentImpl
    }

    override val viewModel =
        instanceKeeper.getOrCreate {
            ListModel(
                componentContext,
                getListTimeZones,
                saveTimeZone,
                router
            )
        }

    @Composable
    override fun Render(state: State) {
        ListContent(state, viewModel::clickTimeZone)
    }


}
