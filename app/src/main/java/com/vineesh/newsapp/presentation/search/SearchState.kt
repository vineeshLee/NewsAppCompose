package com.vineesh.newsapp.presentation.search

import androidx.paging.PagingData
import com.vineesh.newsapp.domain.model.Article
import kotlinx.coroutines.flow.Flow

data class SearchState(
    val searchQuery: String = "",
    val articles: Flow<PagingData<Article>>? = null
)