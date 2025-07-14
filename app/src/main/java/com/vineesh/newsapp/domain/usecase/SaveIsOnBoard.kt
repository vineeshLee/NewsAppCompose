package com.vineesh.newsapp.domain.usecase

import com.vineesh.newsapp.domain.manager.LoginUserManager

data class SaveIsOnBoard(
    private val loginUserManager: LoginUserManager
) {
    suspend operator fun invoke(){
        loginUserManager.saveIsOnBoard()
    }
}