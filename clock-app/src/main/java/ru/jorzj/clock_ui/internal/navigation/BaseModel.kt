package ru.jorzj.clock_ui.internal.navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.essenty.instancekeeper.InstanceKeeper
import com.arkivanov.essenty.lifecycle.doOnDestroy
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.plus

abstract class BaseModel<S : ComponentState>(
    initialState: S,
    private val componentContext: ComponentContext
) : InstanceKeeper.Instance {
    open val state: MutableValue<S> = MutableValue(initialState)

    protected val mainScope = MainScope() + SupervisorJob()
    protected val ioScope: CoroutineScope = mainScope + Dispatchers.IO

    override fun onDestroy() {
        super.onDestroy()
        componentContext.lifecycle.doOnDestroy { mainScope.cancel() }
    }

    fun interface Factory<S : ComponentState> {
        operator fun invoke(initialState: S): BaseModel<S>
    }
}