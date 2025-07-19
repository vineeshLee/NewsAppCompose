package com.vineesh.newsapp.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.vineesh.newsapp.domain.usecase.news.NewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val newsUseCase: NewsUseCase
) : ViewModel() {
    val news = newsUseCase.getNews.invoke(
        sources = listOf(
            "abc-news",
            "bbc-news",
            "al-jazeera-english"
        )
    ).cachedIn(viewModelScope)
}