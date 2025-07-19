package com.vineesh.newsapp.presentation.common

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.vineesh.newsapp.R
import com.vineesh.newsapp.domain.model.Article
import com.vineesh.newsapp.domain.model.Source
import com.vineesh.newsapp.presentation.Dimensions
import com.vineesh.newsapp.presentation.Dimensions.SmallIconSize
import com.vineesh.newsapp.presentation.Dimensions.articleCardSize
import com.vineesh.newsapp.ui.theme.NewsAppTheme

@Composable
fun ArticleCard(
    modifier: Modifier = Modifier,
    article: Article,
    onClick: (()-> Unit)? = null,
) {
    val context = LocalContext.current
    Row(
        verticalAlignment = Alignment.CenterVertically, modifier = modifier.clickable {
            onClick?.invoke()
        }) {
        AsyncImage(
            modifier = Modifier
                .clip(MaterialTheme.shapes.medium)
                .size(articleCardSize),
            contentScale = ContentScale.Crop,
            contentDescription = null,
            model = ImageRequest.Builder(context).data(article.urlToImage).build()
        )
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(horizontal = Dimensions.lowPadding_4)
                .height(articleCardSize)
        ) {
            Text(
                text = article.title,
                style = MaterialTheme.typography.bodyMedium.copy(),
                color = colorResource(R.color.textColor),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = article.source.name,
                    style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Bold),
                    color = colorResource(R.color.textColor)
                )
                Spacer(modifier = Modifier.width(Dimensions.lowPadding_4))
                Icon(
                    painter = painterResource(R.drawable.ic_time),
                    contentDescription = null,
                    modifier = Modifier.size(SmallIconSize)
                )
                Spacer(modifier = Modifier.size(Dimensions.lowPadding_4))
                Text(
                    text = article.publishedAt,
                    style = MaterialTheme.typography.bodySmall.copy(),
                    color = colorResource(R.color.lowGrey)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun ArticleCardPreview() {
    NewsAppTheme(dynamicColor = false) {
        ArticleCard(
            article = Article(
                author = "",
                content = "",
                description = "",
                publishedAt = "2 hours",
                source = Source(id = "", name = "BBC"),
                title = "Her train broke down. Her phone died. And then she met her Saver in a",
                url = "",
                urlToImage = "https://ichef.bbci.co.uk/live-experience/cps/624/cpsprodpb/11787/production/_124395517_bbcbreakingnewsgraphic.jpg"
            ),
        )
    }
}