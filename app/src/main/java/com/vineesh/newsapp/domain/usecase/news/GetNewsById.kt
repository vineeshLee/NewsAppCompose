package com.vineesh.newsapp.domain.usecase.news

import com.vineesh.newsapp.data.local.NewsDao
import com.vineesh.newsapp.domain.model.Article
import com.vineesh.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

data class GetNewsById(
    val newsRepository: NewsRepository
) {
    suspend operator fun invoke(url: String):Article?{
        return newsRepository.getArticleById(url)
    }
}