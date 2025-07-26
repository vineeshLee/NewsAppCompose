package com.vineesh.newsapp.presentation.detail.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.vineesh.newsapp.R
import com.vineesh.newsapp.ui.theme.NewsAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailToolBar(
    onBrowserClick: () -> Unit,
    onShareClick: () -> Unit,
    onBookMarkClick: () -> Unit,
    onBackPress: () -> Unit
) {
    TopAppBar(
        title = {},
        modifier = Modifier.fillMaxWidth(),
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = Color.Transparent,
            actionIconContentColor = colorResource(R.color.body),
            navigationIconContentColor = colorResource(R.color.body)
        ),
        navigationIcon = {
            IconButton(onClick = onBackPress) {
                Icon(
                    painter = painterResource(R.drawable.ic_arrow_back),
                    contentDescription = null
                )
            }
        },
        actions = {
            IconButton(onClick = onBrowserClick) {
                Icon(
                    painter = painterResource(R.drawable.ic_web),
                    contentDescription = null
                )
            }
            IconButton(onClick = onShareClick) {
                Icon(
                    painter = painterResource(R.drawable.ic_share),
                    contentDescription = null
                )
            }
            IconButton(onClick = onBookMarkClick) {
                Icon(
                    painter = painterResource(R.drawable.ic_bookmark),
                    contentDescription = null
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable()
private fun DetailToolBar() {
    NewsAppTheme {
        Box(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
            DetailToolBar(
                onBrowserClick = {},
                onShareClick = {},
                onBookMarkClick = {},
                onBackPress = {}
            )
        }
    }
}