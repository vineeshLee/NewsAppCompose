package com.vineesh.newsapp.presentation.common

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.vineesh.newsapp.R
import com.vineesh.newsapp.ui.theme.NewsAppTheme

@Composable
fun NoInformationScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(), // Make the Column take the full screen size
        verticalArrangement = Arrangement.Center, // Center content vertically
        horizontalAlignment = Alignment.CenterHorizontally // Center content horizontally
    ) {
        Image(
            painter = painterResource(R.drawable.ic_emptycase),
            contentDescription = null
        )
        Text(
            // text = stringResource(id = R.string.no_information_available), // Recommended for localization
            text = "No information available to display.", // Or use a hardcoded string
            style = MaterialTheme.typography.titleLarge
        )
    }
}

@Preview (showBackground = true)
@Preview (showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun NoInformationScreen() {
    NewsAppTheme{
        NoInformationScreen(modifier = Modifier)
    }
}