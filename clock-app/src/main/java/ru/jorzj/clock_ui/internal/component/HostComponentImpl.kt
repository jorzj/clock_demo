package ru.jorzj.clock_ui.internal.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.stack.animation.plus
import com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.predictiveBackAnimation
import com.arkivanov.decompose.extensions.compose.stack.animation.scale
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.backhandler.BackHandlerOwner
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import ru.jorzj.clock_ui.internal.dagger.Config


class HostComponentImpl @AssistedInject constructor(
    @Assisted componentContext: ComponentContext,
    private val listFactory: ListComponent.Factory,
    private val currentComponentFactory: CurrentComponent.Factory,
    private val nav: StackNavigation<Config>
) : HostComponent, BackHandlerOwner, ComponentContext by componentContext {

    private val _stack =
        childStack(
            source = nav,
            serializer = Config.serializer(),
            initialConfiguration = Config.Current,
            childFactory = ::child,
        )
    override val stack: Value<ChildStack<*, HostComponent.Child>> = _stack

    private fun child(
        config: Config,
        componentContext: ComponentContext
    ): HostComponent.Child {
        return (when (config) {
            Config.Current -> HostComponent.Child.CurrentChild(
                currentComponentFactory(componentContext)
            )

            Config.List -> HostComponent.Child.ListChild(
                listFactory(componentContext)
            )
        })
    }

    @OptIn(ExperimentalDecomposeApi::class)
    @Composable
    override fun Render() {
        Children(
            stack = stack,
            animation = predictiveBackAnimation(
                backHandler = backHandler,
                fallbackAnimation = stackAnimation(fade() + scale()),
                onBack = nav::pop,
            ),
        ) {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                it.instance.component.Render()
            }
        }
    }

    @AssistedFactory
    fun interface Factory : HostComponent.Factory {
        override operator fun invoke(componentContext: ComponentContext): HostComponentImpl
    }
}