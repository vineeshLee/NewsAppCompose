package com.vineesh.newsapp.presentation.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vineesh.newsapp.domain.usecase.IsOnBoardUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class OnBoardingViewModel@Inject constructor(
    private val useCase: IsOnBoardUseCase
): ViewModel() {

    fun onEvent(event: OnBoardingEvent){
        when (event) {
            OnBoardingEvent.SaveOnBoarding -> {
                viewModelScope.launch {
                    useCase.saveIsOnBoard()
                }
            }
        }

    }
}