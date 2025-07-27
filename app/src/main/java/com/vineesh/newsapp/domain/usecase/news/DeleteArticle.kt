package com.vineesh.newsapp.domain.usecase.news

import com.vineesh.newsapp.data.local.NewsDao
import com.vineesh.newsapp.domain.model.Article
import com.vineesh.newsapp.domain.repository.NewsRepository

data class DeleteArticle(
    val newsRepository: NewsRepository
) {
    suspend operator fun invoke(article: Article){
        newsRepository.deleteArticle(article)
    }
}