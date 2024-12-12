package ru.jorzj.data.dagger

import dagger.Binds
import dagger.Module
import ru.jorzj.data.local.AvailableTimeZonesRepositoryImpl
import ru.jorzj.data.local.TimeRepositoryImpl
import ru.jorzj.data.local.TimeZoneRepositoryImpl

@Module
interface RepositoryModule {
    @Binds
    fun bindTimeRepository(repository: TimeRepositoryImpl): ru.jorzj.domain.repository.TimeRepository

    @Binds
    fun bindTimeZoneRepository(repository: TimeZoneRepositoryImpl): ru.jorzj.domain.repository.TimeZoneRepository

    @Binds
    fun bindAvailableTimeZonesRepository(repository: AvailableTimeZonesRepositoryImpl): ru.jorzj.domain.repository.AvailableTimeZonesRepository
}