package ru.jorzj.network.api

import retrofit2.http.GET
import retrofit2.http.Query
import ru.jorzj.network.api.model.TimeDto
import ru.jorzj.network.api.model.TimeZoneParam

interface TimeApi {

    @GET("/api/time/current/zone")
    suspend fun getCurrentTime(@Query("timeZone") timeZone: TimeZoneParam): TimeDto
}