package com.vineesh.newsapp.presentation.bookmark

import com.vineesh.newsapp.domain.model.Article

data class BookMarkState(
    val news: List<Article> = emptyList()
)

