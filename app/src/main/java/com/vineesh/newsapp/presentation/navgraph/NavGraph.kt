package com.vineesh.newsapp.presentation.navgraph

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import androidx.paging.compose.collectAsLazyPagingItems
import com.vineesh.newsapp.presentation.bookmark.BookMarkViewModel
import com.vineesh.newsapp.presentation.bookmark.BookmarkScreen
import com.vineesh.newsapp.presentation.home.HomeScreen
import com.vineesh.newsapp.presentation.home.HomeViewModel
import com.vineesh.newsapp.presentation.news_navigator.components.NewsNavigator
import com.vineesh.newsapp.presentation.onboarding.OnBoardingScreens
import com.vineesh.newsapp.presentation.onboarding.OnBoardingViewModel

@Composable
fun NavGraph(startDestination: String) {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = startDestination) {
        navigation(
            route = Route.AppStartNavigation.route, startDestination = Route.OnboardingScreen.route
        ) {
            composable(route = Route.OnboardingScreen.route) {
                val viewModel: OnBoardingViewModel = hiltViewModel()
                OnBoardingScreens(viewModel::onEvent)
            }
        }

        navigation(
            route = Route.NewsNavigation.route,
            startDestination = Route.NewsNavigatorScreen.route
        ) {
            composable(route = Route.NewsNavigatorScreen.route){
                NewsNavigator()
            }
        }
    }
}