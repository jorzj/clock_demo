package ru.jorzj.domain.uc

import ru.jorzj.domain.repository.AvailableTimeZonesRepository
import javax.inject.Inject

class GetListTimeZones @Inject constructor(
    private val repository: AvailableTimeZonesRepository
) {
    suspend operator fun invoke(): List<String> = repository.getTimeZones()
}