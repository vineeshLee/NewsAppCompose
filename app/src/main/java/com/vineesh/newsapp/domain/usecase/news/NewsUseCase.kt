package com.vineesh.newsapp.domain.usecase.news

data class NewsUseCase(
    val getNews: GetNews,
    val searchNews: SearchNews,
    val upsertNews: UpsertNews,
    val deleteArticle: DeleteArticle,
    val getBookMarks: GetBookMarks,
    val getNewsById: GetNewsById
) {
}