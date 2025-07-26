package com.vineesh.newsapp.presentation.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.compose.collectAsLazyPagingItems
import com.vineesh.newsapp.presentation.Dimensions
import com.vineesh.newsapp.presentation.Dimensions.mediumPadding_24
import com.vineesh.newsapp.presentation.common.NewsList
import com.vineesh.newsapp.presentation.common.SearchBar

@Composable
fun SearchScreen(
    state: SearchState,
    event:(SearchEvent) -> Unit
) {

    Column(
        modifier = Modifier
            .padding(top = mediumPadding_24, start = mediumPadding_24, end = mediumPadding_24)
            .statusBarsPadding()
    ) {
        SearchBar(
            text = state.searchQuery,
            readOnly = false,
            onValueChange = { event(SearchEvent.UpdateSearchQuery(it)) },
            onSearch = {
                event(SearchEvent.SearchNews)
            }
        )
        Spacer(modifier = Modifier.height(mediumPadding_24))
        state.articles?.let {
            val articles = it.collectAsLazyPagingItems()
            NewsList(
                articles = articles,
                onClick = {
                    //TODO: Navigate to details screen
                }
            )
        }
    }
}