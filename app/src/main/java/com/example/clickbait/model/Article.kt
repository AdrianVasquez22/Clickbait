package com.example.clickbait.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Article(
    @DrawableRes val imageResourceId: Int,
    @StringRes val article: Int,
    @StringRes val brand: Int,
    @StringRes val time: Int
)
