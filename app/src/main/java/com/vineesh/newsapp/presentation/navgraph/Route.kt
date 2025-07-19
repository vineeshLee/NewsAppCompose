package com.vineesh.newsapp.presentation.navgraph

sealed class Route(val route: String) {
    object OnboardingScreen : Route("OnBoardingScreen")
    object HomeScreenScreen : Route("HomeScreenScreen")
    object SearchScreen : Route("SearchScreen")
    object BookMarkScreen : Route("BookMarkScreen")
    object DetailsScreen : Route("DetailsScreen")
    object AppStartNavigation : Route("AppStartNavigation")
    object NewsNavigationNavigation : Route("NewsNavigation")
    object NewsNavigatorScreen : Route("NewsNavigatorScreen")
}