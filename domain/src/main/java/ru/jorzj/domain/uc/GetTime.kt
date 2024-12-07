package ru.jorzj.domain.uc

import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import ru.jorzj.domain.repository.TimeRepository
import ru.jorzj.domain.repository.TimeZoneRepository
import javax.inject.Inject

class GetTime @Inject constructor(
    private val timeRepository: TimeRepository,
    private val timeZoneRepository: TimeZoneRepository
) {
    suspend operator fun invoke() = timeZoneRepository.getCurrentTimeZone()
        .distinctUntilChanged()
        .map { timeZone ->
            val currentTime = timeRepository.getTime(timeZone)

            timeZone to currentTime
        }

}