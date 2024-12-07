package ru.jorzj.domain.model

data class TimeDomain(
    val year: Int,
    val month: Int,
    val day: Int,
    val hour: Int,
    val minute: Int,
    val seconds: Int,
    val milliSeconds: Int,
    val dateTime: String,
    val date: String,
    val timeZone: String,
    val dayOfWeek: String,
    val dstActive: Boolean,
)

