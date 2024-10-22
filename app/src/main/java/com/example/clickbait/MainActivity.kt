package com.example.clickbait

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.clickbait.data.DataSource
import com.example.clickbait.model.Article
import com.example.clickbait.ui.theme.ClickbaitTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ClickbaitTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ClickbaitApp()
                }
            }
        }
    }
}

@Composable
fun ClickbaitApp() {
    Scaffold(
        topBar = {
            ClickBaitTopAppBar(title = "Top Headlines")
        }
    ) { paddingValues ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = paddingValues,
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(DataSource.articles) { article ->
                ArticleItem(article = article)
            }
        }
    }
}

@Composable
fun ArticleItem(
    article: Article,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Column {
            Image(
                painter = painterResource(article.imageResourceId),
                contentDescription = null,
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Text(
                text = stringResource(article.brand),
                style = MaterialTheme.typography.labelLarge,
                modifier = Modifier.padding(8.dp),
            )
            Text(
                text = stringResource(article.article),
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .padding(bottom = 8.dp),
                maxLines = 4,
                overflow = TextOverflow.Ellipsis,
            )
            Divider()
            Text(
                text = stringResource(article.time),
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier
                    .padding(8.dp),
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClickBaitTopAppBar(title: String) {
    TopAppBar(
        title = { Text(title) }
    )
}

@Preview
@Composable
fun ClickbaitPreview() {
    ClickbaitTheme {
        ClickbaitApp()
    }
}

@Preview
@Composable
fun ClickbaitDarkThemePreview() {
    ClickbaitTheme(darkTheme = true) {
        ClickbaitApp()
    }
}