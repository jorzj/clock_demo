package ru.jorzj.clock_ui.internal.dagger

import dagger.Binds
import dagger.Module
import ru.jorzj.clock_ui.internal.component.CurrentComponent
import ru.jorzj.clock_ui.internal.component.CurrentComponentImpl
import ru.jorzj.clock_ui.internal.component.HostComponent
import ru.jorzj.clock_ui.internal.component.HostComponentImpl
import ru.jorzj.clock_ui.internal.component.ListComponent
import ru.jorzj.clock_ui.internal.component.ListComponentImpl
import ru.jorzj.data.dagger.RepositoryModule

@Module(includes = [NavigationModule::class, RepositoryModule::class])
interface ComponentModule {


    @Binds
    fun bindCurrentComponentFactory(factory: CurrentComponentImpl.Factory): CurrentComponent.Factory

    @Binds
    fun bindHostComponentFactory(factory: HostComponentImpl.Factory): HostComponent.Factory

    @Binds
    fun bindListComponentFactory(factory: ListComponentImpl.Factory): ListComponent.Factory
}

