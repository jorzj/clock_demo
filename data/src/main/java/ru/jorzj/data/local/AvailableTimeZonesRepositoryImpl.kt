package ru.jorzj.data.local

import javax.inject.Inject

class AvailableTimeZonesRepositoryImpl @Inject constructor() :
    ru.jorzj.domain.repository.AvailableTimeZonesRepository {

    private val hardcodedTimeZones: List<String> = listOf(
        "Europe/Amsterdam",
        "Hongkong",
        "Asia/Tashkent",
        "Asia/Novokuznetsk",
        "America/Mexico_City"
    )

    //suspend тут не обязателен, оставил для моковых данных
    override suspend fun getTimeZones(): List<String> = hardcodedTimeZones
}