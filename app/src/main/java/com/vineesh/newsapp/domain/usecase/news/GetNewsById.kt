package com.vineesh.newsapp.domain.usecase.news

import com.vineesh.newsapp.data.local.NewsDao
import com.vineesh.newsapp.domain.model.Article
import kotlinx.coroutines.flow.Flow

data class GetNewsById(
    val newsDao: NewsDao
) {
    suspend operator fun invoke(url: String):Article?{
        return newsDao.getArticle(url)
    }
}