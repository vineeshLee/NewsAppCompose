package com.vineesh.newsapp.di

import android.content.Context
import com.vineesh.newsapp.data.LoginUserManagerImpl
import com.vineesh.newsapp.domain.manager.LoginUserManager
import com.vineesh.newsapp.domain.usecase.IsOnBoardUseCase
import com.vineesh.newsapp.domain.usecase.ReadIsOnBoard
import com.vineesh.newsapp.domain.usecase.SaveIsOnBoard
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideLoginUserManager(
        @ApplicationContext context: Context
    ): LoginUserManager = LoginUserManagerImpl(context = context)

    @Provides
    @Singleton
    fun provideIsOnBoardUseCase(
        loginUserManager: LoginUserManager
    ): IsOnBoardUseCase = IsOnBoardUseCase(
        readIsOnBoard = ReadIsOnBoard(loginUserManager),
        saveIsOnBoard = SaveIsOnBoard(loginUserManager)
    )
}