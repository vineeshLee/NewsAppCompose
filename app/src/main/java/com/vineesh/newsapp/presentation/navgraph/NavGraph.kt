package com.vineesh.newsapp.presentation.navgraph

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.vineesh.newsapp.presentation.bookmark.BookMarkViewModel
import com.vineesh.newsapp.presentation.bookmark.BookmarkScreen
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

            composable(route = Route.NewsNavigatorScreen.route) {
//                val viewModel: HomeViewModel =hiltViewModel()
//                val newsList=viewModel.news.collectAsLazyPagingItems()
//                HomeScreen(newsList,{
//
//                })

                val viewModel: BookMarkViewModel = hiltViewModel()
                BookmarkScreen(state = viewModel.state.value,
                    navigateToDetails = {

                })
            }

            /* composable (route = Route.NewsNavigatorScreen.route){
                 val viewModel: SearchViewModel =hiltViewModel()
                 SearchScreen(viewModel.state.value, event =viewModel::onEvent)
             }*/
        }
    }
}