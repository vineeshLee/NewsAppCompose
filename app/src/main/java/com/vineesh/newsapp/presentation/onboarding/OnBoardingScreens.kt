package com.vineesh.newsapp.presentation.onboarding

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.vineesh.newsapp.presentation.Dimensions.IndicatorBoxWidth
import com.vineesh.newsapp.presentation.Dimensions.mediumPadding_24
import com.vineesh.newsapp.presentation.common.NewsButton
import com.vineesh.newsapp.presentation.common.NewsLabelButton
import kotlinx.coroutines.launch

@Composable
fun OnBoardingScreens(event:(OnBoardingEvent)-> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {

        val pagerState = rememberPagerState(initialPage = 0) {
            welcomeScreens.size
        }

        val buttonState = remember {
            derivedStateOf {
                when (pagerState.currentPage) {
                    0 -> listOf("", "Next")
                    1 -> listOf("Back", "Next")
                    2 -> listOf("Back", "Get Started")
                    else -> listOf("", "")
                }
            }
        }

        HeaderImageSlider(pagerState)

        Spacer(modifier = Modifier.weight(1f))

        Footer(pagerState, buttonState,event)

        Spacer(modifier = Modifier.weight(.3f))
    }
}

@Composable
private fun Footer(
    pagerState: PagerState,
    buttonState: State<List<String>>,
    event: (OnBoardingEvent) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = mediumPadding_24)
            .navigationBarsPadding(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
//            PageIndicator
        CircleIndicator(pagerState)

//            BackButton and NextButton
        BackAndNextButton(buttonState, pagerState,event)
    }
}

@Composable
private fun HeaderImageSlider(pagerState: PagerState) {
    HorizontalPager(state = pagerState) { index ->
        OnboardingPage(modifier = Modifier, welcomeScreens[index])
    }
}

@Composable
private fun CircleIndicator(pagerState: PagerState) {
    PageIndicator(
        modifier = Modifier.width(IndicatorBoxWidth), pageSize = welcomeScreens.size,
        selectedPage = pagerState.currentPage,

        )
}

@Composable
private fun BackAndNextButton(
    buttonState: State<List<String>>, pagerState: PagerState, event: (OnBoardingEvent) -> Unit
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        val scope = rememberCoroutineScope()
        if (buttonState.value[0].isNotEmpty()) {
            NewsLabelButton(text = buttonState.value[0], onClick = {
                scope.launch {
                    pagerState.animateScrollToPage(page = pagerState.currentPage - 1)
                }
            })
        }
        NewsButton(buttonState.value[1], onClick = {
            scope.launch {
                if (pagerState.currentPage == 2) {
                    event.invoke(OnBoardingEvent.SaveOnBoarding)
                } else {
                    pagerState.animateScrollToPage(pagerState.currentPage + 1)
                }
            }
        })
    }
}