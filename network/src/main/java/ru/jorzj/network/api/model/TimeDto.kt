package ru.jorzj.network.api.model

import kotlinx.serialization.Serializable

@Serializable
data class TimeDto(
    val year: Int,
    val month: Int,
    val day: Int,
    val hour: Int,
    val minute: Int,
    val seconds: Int,
    val milliSeconds: Int,
    val dateTime: String,
    val date: String,
    val time: String,
    val timeZone: String,
    val dayOfWeek: String,
    val dstActive: Boolean,
)
// Example
//{
//    "year": 2020,
//    "month": 12,
//    "day": 13,
//    "hour": 9,
//    "minute": 30,
//    "seconds": 17,
//    "milliSeconds": 0,
//    "dateTime": "2020-12-13T09:30:17",
//    "date": "13/12/2020",
//    "time": "09:30",
//    "timeZone": "America/Los_Angeles",
//    "dayOfWeek": "Sunday",
//    "dstActive": false
//}