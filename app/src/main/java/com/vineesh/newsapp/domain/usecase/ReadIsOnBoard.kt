package com.vineesh.newsapp.domain.usecase

import com.vineesh.newsapp.domain.manager.LoginUserManager
import kotlinx.coroutines.flow.Flow

data class ReadIsOnBoard(
    private val loginUserManager: LoginUserManager
) {
    operator fun invoke(): Flow<Boolean>{
        return loginUserManager.readIsOnBoard()
    }
}