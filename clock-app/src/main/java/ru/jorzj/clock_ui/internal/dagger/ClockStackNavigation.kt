package ru.jorzj.clock_ui.internal.dagger

import com.arkivanov.decompose.DelicateDecomposeApi
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.push
import dagger.Binds
import dagger.Module
import kotlinx.serialization.Serializable
import javax.inject.Inject
import javax.inject.Singleton

@Module
interface NavigationModule {
    @Binds
    @Singleton
    fun bindNavigationStack(stack: ClockStackNavigation): StackNavigation<Config>
}

class ClockStackNavigation @Inject constructor() : StackNavigation<Config> by StackNavigation()

class Router @Inject constructor(private val navigation: StackNavigation<Config>) {

    @OptIn(DelicateDecomposeApi::class)
    fun openList() = navigation.push(Config.List)
    fun back() {
        navigation.pop()
    }
}

@Serializable
sealed interface Config {
    @Serializable
    data object List : Config

    @Serializable
    data object Current : Config
}
