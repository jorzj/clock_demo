package ru.jorzj.clock_ui.internal.dagger

import dagger.Component
import ru.jorzj.clock_ui.internal.component.HostComponent
import ru.jorzj.network.internal.NetworkModule
import javax.inject.Singleton

@Singleton
@Component(modules = [ComponentModule::class, NetworkModule::class, AppModule::class])
interface MainDaggerComponent {

    val rootComponentFactory: HostComponent.Factory
}

