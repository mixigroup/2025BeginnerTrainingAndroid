package com.example.beginnertrainingandroid2025.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.beginnertrainingandroid2025.data.Repo
import com.example.beginnertrainingandroid2025.ui.theme.BeginnerTrainingAndroid2025Theme
import kotlin.random.Random
import kotlin.random.nextInt

@Composable
fun HomeScreen(
    repos: List<Repo>,
    modifier: Modifier = Modifier,
) {
    Scaffold {
        LazyColumn(modifier = modifier) {
            items(
                items = repos,
                key = { it.id },
            ) {
                RepoListItem(repo = it)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    BeginnerTrainingAndroid2025Theme {
        val repos = List(1000) {
            Repo(
                id = it,
                name = "repo$it",
                description = if (it.mod(2) == 0) "This is awesome repository" else null,
                stars = Random.nextInt(IntRange(0, 1000)),
            )
        }
        HomeScreen(
            repos = repos,
        )
    }
}