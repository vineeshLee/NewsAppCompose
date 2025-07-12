package com.vineesh.newsapp.presentation.onboarding

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.UiMode
import com.vineesh.newsapp.R
import com.vineesh.newsapp.presentation.Dimensions.lowPadding_4
import com.vineesh.newsapp.presentation.Dimensions.mediumPadding_24
import com.vineesh.newsapp.ui.theme.NewsAppTheme

@Composable
fun OnboardingPage(
    modifier: Modifier = Modifier,
    page: OnBoard
) {

    Column {
//        Image header
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(fraction = 0.6f),
            painter = painterResource(id = page.image),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(mediumPadding_24))

//        Title
        Text(
            modifier = Modifier.padding(horizontal = mediumPadding_24),
            text = page.title,
            maxLines = 2,
            style = MaterialTheme.typography.displayMedium.copy(fontWeight = FontWeight.Bold),
            color = colorResource(R.color.textColor)
        )

        Spacer(modifier = Modifier.height(lowPadding_4))
//        Description
        Text(
            modifier = Modifier.padding(horizontal = mediumPadding_24),
            text = page.description,
            maxLines = 5,
            style = MaterialTheme.typography.bodySmall,
            color = colorResource(R.color.textColor)
        )
    }
}

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
private fun OnBoardingPage() {
    NewsAppTheme {
        OnboardingPage(page = welcomeScreens[0])
    }
}