package com.vineesh.newsapp.domain.manager

import kotlinx.coroutines.flow.Flow

interface LoginUserManager {
    suspend fun saveIsOnBoard()
    fun readIsOnBoard(): Flow<Boolean>
}