package ru.jorzj.data.local

import kotlinx.coroutines.flow.Flow
import ru.jorzj.data.storage.KeyValueStorage
import javax.inject.Inject

class TimeZoneRepositoryImpl @Inject constructor(private val keyValueStorage: KeyValueStorage) :
    ru.jorzj.domain.repository.TimeZoneRepository {

    override suspend fun getCurrentTimeZone(): Flow<String> = keyValueStorage.getCurrentTimeZone()
    override suspend fun save(timeZone: String) {
        keyValueStorage.saveTimeZone(timeZone)
    }
}