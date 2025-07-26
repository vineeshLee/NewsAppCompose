package com.vineesh.newsapp.presentation.search

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.paging.compose.collectAsLazyPagingItems
import com.vineesh.newsapp.R
import com.vineesh.newsapp.domain.model.Article
import com.vineesh.newsapp.presentation.Dimensions
import com.vineesh.newsapp.presentation.Dimensions.mediumPadding_24
import com.vineesh.newsapp.presentation.common.NewsList
import com.vineesh.newsapp.presentation.common.SearchBar
import com.vineesh.newsapp.ui.theme.NewsAppTheme

@Composable
fun SearchScreen(
    state: SearchState,
    event:(SearchEvent) -> Unit,
    navigateToDetail:(Article) -> Unit
) {

    Column(
        modifier = Modifier
            .padding(top = mediumPadding_24, start = mediumPadding_24, end = mediumPadding_24)
            .statusBarsPadding()
    ) {
        Text(
            text = "Search here...",
            style = MaterialTheme.typography.displayMedium.copy(fontWeight = FontWeight.Bold),
            color = colorResource(
                id = R.color.textColor
            )
        )

        Spacer(modifier = Modifier.height(mediumPadding_24))

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
                    navigateToDetail.invoke(it)
                }
            )
        }
    }
}
