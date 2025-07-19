package com.vineesh.newsapp.domain.usecase.news

import androidx.paging.PagingData
import com.vineesh.newsapp.domain.model.Article
import com.vineesh.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetNews(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(sources: List<String>): Flow<PagingData<Article>> {
        return newsRepository.getNews(sources)
    }
}