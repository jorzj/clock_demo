package ru.jorzj.clock_ui.internal.component.model

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.update
import com.arkivanov.essenty.lifecycle.doOnStart
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ru.jorzj.clock_ui.internal.component.ListComponent
import ru.jorzj.clock_ui.internal.dagger.Router
import ru.jorzj.clock_ui.internal.navigation.BaseModel
import ru.jorzj.domain.uc.GetListTimeZones
import ru.jorzj.domain.uc.SaveTimeZone

class ListModel(
    componentContext: ComponentContext,
    private val getListTimeZones: GetListTimeZones,
    private val saveTimeZone: SaveTimeZone,
    private val router: Router,
) : BaseModel<ListComponent.State>(
    initialState = ListComponent.State(emptyList()),
    componentContext = componentContext
) {
    init {
        componentContext.lifecycle.doOnStart() {
            getList()
        }
    }

    fun clickTimeZone(timeZone: String) {
        ioScope.launch {
            saveTimeZone(timeZone)
            //минимальный делей, перед возвратом на прошлый экран
            delay(200L)
            mainScope.launch {
                router.back()
            }
        }

    }

    private fun getList() {
        ioScope.launch {
            getListTimeZones().let { response ->
                state.update { it.copy(list = response) }
            }
        }
    }

}