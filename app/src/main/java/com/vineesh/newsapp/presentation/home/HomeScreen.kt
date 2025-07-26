package com.vineesh.newsapp.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.compose.LazyPagingItems
import com.vineesh.newsapp.R
import com.vineesh.newsapp.domain.model.Article
import com.vineesh.newsapp.presentation.Dimensions.mediumPadding_24
import com.vineesh.newsapp.presentation.common.NewsList
import com.vineesh.newsapp.presentation.common.SearchBar

@Composable
fun HomeScreen(
    articles: LazyPagingItems<Article>,
    navigateToDetail: (Article) -> Unit,
    navigateToSearch: () -> Unit
) {

    val titles by remember {
        derivedStateOf {
            if (articles.itemCount > 10) {
                articles.itemSnapshotList.items
                    .slice(IntRange(start = 0, endInclusive = 9))
                    .joinToString(separator = " \uD83D\uDFE5 ") { it.title }
            } else {
                ""
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = mediumPadding_24)
            .statusBarsPadding()
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_splash),
            contentDescription = null,
            modifier = Modifier
                .width(150.dp)
                .height(30.dp)
                .padding(horizontal = mediumPadding_24)
        )

        Spacer(modifier = Modifier.height(mediumPadding_24))

        SearchBar(
            modifier = Modifier
                .padding(horizontal = mediumPadding_24)
                .fillMaxWidth(),
            text = "",
            readOnly = true,
            onValueChange = {},
            onSearch = {},
            onClick = {
                navigateToSearch.invoke()
            }
        )

        Spacer(modifier = Modifier.height(mediumPadding_24))

        Text(
            text = titles, modifier = Modifier
                .fillMaxWidth()
                .padding(start = mediumPadding_24)
                .basicMarquee(), fontSize = 12.sp,
            color = colorResource(id = R.color.lowGrey)
        )

        Spacer(modifier = Modifier.height(mediumPadding_24))

        NewsList(
            modifier = Modifier.padding(horizontal = mediumPadding_24),
            articles = articles,
            onClick = {
                navigateToDetail.invoke(it)
            }
        )
    }
}