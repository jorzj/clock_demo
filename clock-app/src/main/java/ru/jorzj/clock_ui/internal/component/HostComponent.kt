package ru.jorzj.clock_ui.internal.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import ru.jorzj.clock_ui.internal.navigation.Component


interface HostComponent : Component {

    val stack: Value<ChildStack<*, Child>>

    sealed class Child {
        abstract val component: Component

        class ListChild(override val component: ListComponent) : Child()
        class CurrentChild(override val component: CurrentComponent) : Child()
    }

    fun interface Factory {
        operator fun invoke(componentContext: ComponentContext): HostComponent
    }
}
