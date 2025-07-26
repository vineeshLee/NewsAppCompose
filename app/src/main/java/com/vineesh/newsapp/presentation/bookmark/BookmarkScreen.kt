package com.vineesh.newsapp.presentation.bookmark

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import com.vineesh.newsapp.R
import com.vineesh.newsapp.domain.model.Article
import com.vineesh.newsapp.presentation.Dimensions
import com.vineesh.newsapp.presentation.Dimensions.mediumPadding_24
import com.vineesh.newsapp.presentation.common.NewsList
import java.nio.file.WatchEvent

@Composable
fun BookmarkScreen(
    state: BookMarkState,
    navigateToDetails: (Article) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .padding(top = mediumPadding_24, start = mediumPadding_24, end = mediumPadding_24)
    ) {

        Text(
            text = "Bookmark'S",
            style = MaterialTheme.typography.displayMedium.copy(fontWeight = FontWeight.Bold),
            color = colorResource(
                id = R.color.textColor
            )
        )

        Spacer(modifier = Modifier.height(mediumPadding_24))

        NewsList(
            modifier = Modifier,
            articles = state.news,
            onClick = navigateToDetails
        )
    }
}