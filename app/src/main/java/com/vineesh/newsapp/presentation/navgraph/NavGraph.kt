package com.vineesh.newsapp.presentation.navgraph

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
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

        navigation(route = Route.NewsNavigationNavigation.route,
            startDestination = Route.HomeScreenScreen.route){

            composable(route= Route.HomeScreenScreen.route) {

            }
            composable(route= Route.SearchScreen.route) {

            }
            composable(route= Route.BookMarkScreen.route) {

            }
            composable(route= Route.DetailsScreen.route) {

            }
        }
    }
}