package com.vineesh.newsapp.domain.repository

import androidx.paging.PagingData
import com.vineesh.newsapp.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    fun getNews(params: List<String>): Flow<PagingData<Article>>
    fun searchNews(searchQuery: String, sources: List<String>): Flow<PagingData<Article>>

    suspend fun upsertArticle(article: Article)
    suspend fun deleteArticle(article: Article)
    suspend fun getAllBookMarks(): Flow<List<Article>>
    suspend fun getArticleById(url: String): Article?
}