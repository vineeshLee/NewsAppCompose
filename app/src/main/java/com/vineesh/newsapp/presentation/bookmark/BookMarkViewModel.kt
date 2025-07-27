package com.vineesh.newsapp.presentation.bookmark

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vineesh.newsapp.domain.usecase.news.NewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

@HiltViewModel
class BookMarkViewModel @Inject constructor(
    private val newsUseCase: NewsUseCase
) : ViewModel() {

    private val _state = mutableStateOf(BookMarkState())
    val state: State<BookMarkState> =_state

    init {
        viewModelScope.launch {
            getBookMarks()
        }
    }
    suspend fun getBookMarks(){
        newsUseCase.getBookMarks.invoke().onEach {
            _state.value=_state.value.copy(it.asReversed())
        }.launchIn(viewModelScope)
    }

}