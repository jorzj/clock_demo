package ru.jorzj.data.storage

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class KeyValueStorage @Inject constructor(context: Context) {
    private val dataStore = context.dataStore
    suspend fun saveTimeZone(timeZone: String) = dataStore.edit { preferences ->
        preferences[TimeZone] = timeZone
    }

    fun getCurrentTimeZone(defaultValue: String = "Europe/Amsterdam"): Flow<String> =
        dataStore.data.map { preferences ->
            preferences[TimeZone] ?: defaultValue
        }
}

// Расширение для доступа к DataStore
val Context.dataStore by preferencesDataStore(name = "clock")

// Ключ для сохранения времени
val TimeZone = stringPreferencesKey("time_zone")