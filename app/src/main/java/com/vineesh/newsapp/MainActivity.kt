package com.vineesh.newsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.vineesh.newsapp.domain.usecase.IsOnBoardUseCase
import com.vineesh.newsapp.presentation.onboarding.OnBoardingScreens
import com.vineesh.newsapp.presentation.onboarding.OnBoardingViewModel
import com.vineesh.newsapp.presentation.onboarding.OnboardingPage
import com.vineesh.newsapp.presentation.onboarding.welcomeScreens
import com.vineesh.newsapp.ui.theme.NewsAppTheme
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.getValue

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        enableEdgeToEdge()
        setContent {
            NewsAppTheme {
                val viewModel: OnBoardingViewModel by viewModels()
                OnBoardingScreens(viewModel::onEvent)
            }
        }
    }
}
