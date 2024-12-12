package ru.jorzj.clock_ui.internal.component.model

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.update
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import ru.jorzj.clock_ui.internal.component.CurrentComponent
import ru.jorzj.clock_ui.internal.dagger.Router
import ru.jorzj.clock_ui.internal.navigation.BaseModel
import ru.jorzj.domain.uc.GetTime

class CurrentModel(
    componentContext: ComponentContext,
    private val getTime: GetTime,
    private val router: Router,
) : BaseModel<CurrentComponent.State>(
    initialState = CurrentComponent.State(),
    componentContext = componentContext
) {
    init {
        requestTime()
    }


    private var timerJob: Job? = null


    private fun startTimer(scope: CoroutineScope, initialValue: Int, onTick: (Int) -> Unit): Job =
        scope.launch {
            var timeInSeconds = initialValue
            while (isActive) {
                onTick(timeInSeconds)
                // следим за переполнением дня
                timeInSeconds = timeInSeconds % 86400 + 1
                delay(1000L)
            }
        }

    private fun requestTime() {
        ioScope.launch {
            getTime().collectLatest { (timeZone, time) ->
                state.update {
                    it.copy(timeZone = timeZone)
                }
                timerJob?.cancel()
                timerJob = null
                timerJob = startTimer(
                    this,
                    initialValue = time.hour * 60 * 60 + time.minute * 60 + time.seconds
                ) { timeInSeconds ->
                    state.update {
                        it.copy(timeInSeconds = timeInSeconds)
                    }
                }
            }
        }
    }

    fun openList() {
        router.openList()
    }
}
