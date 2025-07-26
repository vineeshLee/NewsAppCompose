package com.vineesh.newsapp.domain.usecase.news

data class NewsUseCase(
    val getNews: GetNews,
    val searchNews: SearchNews
) {
}