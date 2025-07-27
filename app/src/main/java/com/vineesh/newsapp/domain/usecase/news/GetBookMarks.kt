package com.vineesh.newsapp.domain.usecase.news

import com.vineesh.newsapp.data.local.NewsDao
import com.vineesh.newsapp.domain.model.Article
import com.vineesh.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

data class GetBookMarks(
    val newsRepository: NewsRepository
) {
    suspend operator fun invoke(): Flow<List<Article>>{
        return newsRepository.getAllBookMarks()
    }
}