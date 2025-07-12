package com.vineesh.newsapp.presentation.onboarding

import androidx.annotation.DrawableRes
import com.vineesh.newsapp.R

data class OnBoard(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)

val welcomeScreens = listOf(
    OnBoard(
        title = "International Relations",
        description = "In news, \"politics\" broadly refers to the activities, processes, and structures involved in making decisions within a society, particularly those related to governance, power, and the distribution of resources. It encompasses the actions of individuals, groups, and institutions as they shape public policy, compete for influence, and manage societal affairs. ",
        image = R.drawable.img_welcome_politics
    ), OnBoard(
        title = "Latest Football Updates",
        description = "A good sports news description should be clear, concise, and engaging, highlighting the key events, players, and outcomes of a sporting event. It should answer the \"who, what, where, when, why, and how\" of the story, often starting with a strong lead that summarizes the main points.",
        image = R.drawable.img_welcome_sports
    ), OnBoard(
        title = "Intel launching a new AI robotics arm",
        description = "Recent technology news includes Intel launching a new AI robotics arm, Samsung hinting at a 2025 debut for tri-fold phones, and X (formerly Twitter) cutting subscription fees in India. Additionally, there's news about a potential Tesla India showroom opening in another city and discussions on the impact of AI on careers. ",
        image = R.drawable.img_welcome_tech
    )
)
