package com.vineesh.newsapp.domain.usecase.news

import com.vineesh.newsapp.data.local.NewsDao
import com.vineesh.newsapp.domain.model.Article
import kotlinx.coroutines.flow.Flow

data class GetBookMarks(
    val newsDao: NewsDao
) {
    operator fun invoke(): Flow<List<Article>>{
        return newsDao.getArticles()
    }
}