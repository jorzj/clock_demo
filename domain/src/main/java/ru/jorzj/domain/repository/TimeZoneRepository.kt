package ru.jorzj.domain.repository

import kotlinx.coroutines.flow.Flow

interface TimeZoneRepository {
    suspend fun getCurrentTimeZone(): Flow<String>
    suspend fun save(timeZone: String)
}