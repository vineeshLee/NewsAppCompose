package com.vineesh.newsapp.di

import android.content.Context
import com.vineesh.newsapp.data.LoginUserManagerImpl
import com.vineesh.newsapp.data.remote.NewsApi
import com.vineesh.newsapp.data.repository.NewsRepositoryImpl
import com.vineesh.newsapp.domain.manager.LoginUserManager
import com.vineesh.newsapp.domain.repository.NewsRepository
import com.vineesh.newsapp.domain.usecase.news.GetNews
import com.vineesh.newsapp.domain.usecase.news.NewsUseCase
import com.vineesh.newsapp.domain.usecase.news.SearchNews
import com.vineesh.newsapp.domain.usecase.onboard.IsOnBoardUseCase
import com.vineesh.newsapp.domain.usecase.onboard.ReadIsOnBoard
import com.vineesh.newsapp.domain.usecase.onboard.SaveIsOnBoard
import com.vineesh.newsapp.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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

    @Provides
    @Singleton
    fun provideNewsApi(): NewsApi {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi
    ): NewsRepository = NewsRepositoryImpl(newsApi)

    @Provides
    @Singleton
    fun provideNewsUseCase(
        newsRepository: NewsRepository
    ): NewsUseCase {
        return NewsUseCase(getNews = GetNews(newsRepository), searchNews = SearchNews(newsRepository) )
    }
}