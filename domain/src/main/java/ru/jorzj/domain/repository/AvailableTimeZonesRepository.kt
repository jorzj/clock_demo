package ru.jorzj.domain.repository

interface AvailableTimeZonesRepository {
    suspend fun getTimeZones(): List<String>
}