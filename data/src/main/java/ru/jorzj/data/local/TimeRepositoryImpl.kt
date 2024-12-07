package ru.jorzj.data.local

import ru.jorzj.domain.model.TimeDomain
import ru.jorzj.domain.repository.TimeRepository
import ru.jorzj.network.api.TimeApi
import ru.jorzj.network.api.model.TimeDto
import javax.inject.Inject

class TimeRepositoryImpl @Inject constructor(private val timeApi: TimeApi) :
    TimeRepository {
    override suspend fun getTime(timeZone: String): TimeDomain {
        return timeApi.getCurrentTime(timeZone).toDomain()
    }
}

private fun TimeDto.toDomain() = TimeDomain(
    year = year,
    month = month,
    day = day,
    hour = hour,
    minute = minute,
    seconds = seconds,
    milliSeconds = milliSeconds,
    dateTime = dateTime,
    date = date,
    timeZone = timeZone,
    dayOfWeek = dayOfWeek,
    dstActive = dstActive
)