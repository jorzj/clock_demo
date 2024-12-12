package ru.jorzj.clock_ui.api.starter

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import com.arkivanov.decompose.defaultComponentContext
import ru.jorzj.clock_ui.internal.navigation.Component
import ru.jorzj.clock_ui.internal.dagger.AppModule
import ru.jorzj.clock_ui.internal.dagger.DaggerMainDaggerComponent
import ru.jorzj.clock_ui.internal.screen.root.RootContent

@Composable
fun DrawContent(component: Component) = RootContent(component)

// билдим даггаер внутри активити - правильно перенести это в App
// но тут показывал структуру проекта и само написание кода
fun ComponentActivity.buildComponent(): Component =
    DaggerMainDaggerComponent.builder().appModule(AppModule(applicationContext)).build()
        .rootComponentFactory(defaultComponentContext())

