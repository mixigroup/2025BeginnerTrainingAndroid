package com.example.beginnertrainingandroid2025.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.beginnertrainingandroid2025.data.Repo
import org.jetbrains.compose.ui.tooling.preview.Preview
import kotlin.random.Random
import kotlin.random.nextInt

data class BookmarkScreenUiState(
    val items: List<Repo>
)

@Composable
fun BookmarkScreen(
    viewModel: BookmarkViewModel = viewModel(factory = BookmarkViewModel.Factory),
    modifier: Modifier = Modifier,
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) { viewModel.onLaunched() }

    BookmarkScreen(
        modifier = modifier,
        onBookmarkIconClick = viewModel::onBookmarkIconClick,
        uiState = uiState,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun BookmarkScreen(
    uiState: BookmarkScreenUiState,
    onBookmarkIconClick: (Repo) -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "ブックマーク")
                },
            )
        },
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .padding(8.dp),
        ) {
            items(uiState.items) { repo ->
                RepoListItem(
                    repo = repo,
                    isBookmarked = true,
                    onBookmarkIconClick = onBookmarkIconClick,
                )
            }
        }
    }
}

@Preview
@Composable
private fun BookmarkScreenPreview() {
    MaterialTheme {
        val repos = List(1000) {
            Repo(
                id = it,
                name = "repo$it",
                description = if (it.mod(2) == 0) "This is awesome repository" else null,
                stars = Random.nextInt(IntRange(0, 1000)),
            )
        }
        BookmarkScreen(
            uiState = BookmarkScreenUiState(items = repos),
            onBookmarkIconClick = {},
        )
    }
}