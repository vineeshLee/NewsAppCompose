package com.vineesh.newsapp.domain.usecase.news

import com.vineesh.newsapp.data.local.NewsDao
import com.vineesh.newsapp.domain.model.Article

data class DeleteArticle(
    val newsDao: NewsDao
) {
    suspend operator fun invoke(article: Article){
        newsDao.delete(article)
    }
}