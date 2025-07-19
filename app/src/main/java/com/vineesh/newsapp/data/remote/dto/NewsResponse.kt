package com.vineesh.newsapp.data.remote.dto

import com.vineesh.newsapp.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)