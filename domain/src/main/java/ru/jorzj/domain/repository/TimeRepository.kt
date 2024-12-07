package ru.jorzj.domain.repository

import ru.jorzj.domain.model.TimeDomain

interface TimeRepository {
    suspend fun getTime(timeZone: String): TimeDomain
}