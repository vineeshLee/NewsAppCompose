package com.vineesh.newsapp.presentation.navgraph

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.vineesh.newsapp.presentation.home.HomeScreen
import com.vineesh.newsapp.presentation.home.HomeViewModel
import com.vineesh.newsapp.presentation.onboarding.OnBoardingScreens
import com.vineesh.newsapp.presentation.onboarding.OnBoardingViewModel
import com.vineesh.newsapp.presentation.search.SearchScreen
import com.vineesh.newsapp.presentation.search.SearchViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

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

        navigation(route = Route.NewsNavigation.route,
            startDestination = Route.NewsNavigatorScreen.route){

            composable (route = Route.NewsNavigatorScreen.route){
                val viewModel: HomeViewModel =hiltViewModel()
                val newsList=viewModel.news.collectAsLazyPagingItems()
                HomeScreen(newsList,{

                })
            }

           /* composable (route = Route.NewsNavigatorScreen.route){
                val viewModel: SearchViewModel =hiltViewModel()
                SearchScreen(viewModel.state.value, event =viewModel::onEvent)
            }*/
        }
    }
}