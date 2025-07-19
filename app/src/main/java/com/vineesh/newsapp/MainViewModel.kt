package com.vineesh.newsapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vineesh.newsapp.domain.usecase.onboard.IsOnBoardUseCase
import com.vineesh.newsapp.presentation.navgraph.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCase: IsOnBoardUseCase
) : ViewModel() {

    private val _startDestination = mutableStateOf(Route.AppStartNavigation.route)
    val startDestination: State<String> = _startDestination
    private val _slashScreen = mutableStateOf(true)
    val splashCondition: State<Boolean> = _slashScreen

    init {
        useCase.readIsOnBoard.invoke().onEach { readIsOnBoard ->
            if (readIsOnBoard) {
                _startDestination.value = Route.NewsNavigation.route
            } else {
                _startDestination.value = Route.AppStartNavigation.route
            }
            delay(200)
            _slashScreen.value = false
        }.launchIn(viewModelScope)
    }
}