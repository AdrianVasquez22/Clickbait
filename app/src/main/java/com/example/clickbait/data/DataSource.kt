package com.example.clickbait.data

import com.example.clickbait.R
import com.example.clickbait.model.Article

object DataSource {
    val articles = listOf(
        Article(R.drawable.travel, R.string.article, R.string.brand, R.string.time),
        Article(R.drawable.pet, R.string.article2, R.string.brand2, R.string.time2),
        Article(R.drawable.fantasy, R.string.article3, R.string.brand3, R.string.time3),
        Article(R.drawable.diy, R.string.article4, R.string.brand4, R.string.time4),
        Article(R.drawable.cartoons, R.string.article5, R.string.brand5, R.string.time5),
        Article(R.drawable.pizza, R.string.article6, R.string.brand6, R.string.time6),
        Article(R.drawable.celebrity, R.string.article7, R.string.brand7, R.string.time7),
        Article(R.drawable.junkfood, R.string.article8, R.string.brand8, R.string.time8),
        Article(R.drawable.soulmate, R.string.article9, R.string.brand9, R.string.time9),
        Article(R.drawable.lifehacks, R.string.article10, R.string.brand10, R.string.time10),
    )
}