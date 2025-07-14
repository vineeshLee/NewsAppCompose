package com.vineesh.newsapp.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStoreFile
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.vineesh.newsapp.domain.manager.LoginUserManager
import com.vineesh.newsapp.utils.Constants
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LoginUserManagerImpl(private val context: Context): LoginUserManager {

    override suspend fun saveIsOnBoard() {
        context.dataStore.edit { settings ->
            settings[PreferenceKeys.isOnBoardingShown] = true
        }
    }

    override fun readIsOnBoard(): Flow<Boolean> {
        return context.dataStore.data.map { preferences ->
            preferences[PreferenceKeys.isOnBoardingShown] ?: false
        }
    }
}
val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = Constants.USER_DATA)
private object PreferenceKeys {
    val isOnBoardingShown = booleanPreferencesKey(Constants.isOnBoardShown)
}