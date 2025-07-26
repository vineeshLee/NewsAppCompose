package com.vineesh.newsapp.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.vineesh.newsapp.data.LoginUserManagerImpl
import com.vineesh.newsapp.data.local.NewsDao
import com.vineesh.newsapp.data.local.NewsDatabase
import com.vineesh.newsapp.data.local.NewsTypeConvertor
import com.vineesh.newsapp.data.remote.NewsApi
import com.vineesh.newsapp.data.repository.NewsRepositoryImpl
import com.vineesh.newsapp.domain.manager.LoginUserManager
import com.vineesh.newsapp.domain.repository.NewsRepository
import com.vineesh.newsapp.domain.usecase.news.DeleteArticle
import com.vineesh.newsapp.domain.usecase.news.GetBookMarks
import com.vineesh.newsapp.domain.usecase.news.GetNews
import com.vineesh.newsapp.domain.usecase.news.GetNewsById
import com.vineesh.newsapp.domain.usecase.news.NewsUseCase
import com.vineesh.newsapp.domain.usecase.news.SearchNews
import com.vineesh.newsapp.domain.usecase.news.UpsertNews
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
        newsRepository: NewsRepository,
        newsDao: NewsDao
    ): NewsUseCase {
        return NewsUseCase(getNews = GetNews(newsRepository),
            searchNews = SearchNews(newsRepository),
            upsertNews = UpsertNews(newsDao),
            deleteArticle = DeleteArticle(newsDao),
            getBookMarks = GetBookMarks(newsDao),
            getNewsById = GetNewsById(newsDao))
    }

    @Provides
    @Singleton
    fun provideNewsDatabase(
        application: Application
    ): NewsDatabase {
        return Room.databaseBuilder(
            context = application,
            klass = NewsDatabase::class.java,
            name = "news_db"
        ).addTypeConverter(NewsTypeConvertor())
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsDao(
        newsDatabase: NewsDatabase
    ): NewsDao = newsDatabase.newsDao

}