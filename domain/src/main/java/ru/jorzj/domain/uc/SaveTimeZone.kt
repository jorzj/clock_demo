package ru.jorzj.domain.uc

import ru.jorzj.domain.repository.TimeZoneRepository
import javax.inject.Inject

class SaveTimeZone @Inject constructor(
    private val timeZoneRepository: TimeZoneRepository
) {
    suspend operator fun invoke(timeZone: String) = timeZoneRepository.save(timeZone)
}