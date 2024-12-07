package ru.jorzj.network.internal

import ru.jorzj.network.api.TimeApi
import ru.jorzj.network.api.model.TimeDto
import ru.jorzj.network.api.model.TimeZoneParam
import javax.inject.Inject

/*
class TimeApiService @Inject constructor(
     private val client: HttpClient
    //private val timeDto: TimeDto
) : TimeApi {
    override suspend fun getCurrentTime(timeZone: TimeZoneParam): TimeDto =
      client.get("time/current/zone") {
          parameter("timeZone", timeZone) // Pass timezone as query parameter
      }.body()

}*/
