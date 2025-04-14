package com.example.beginnertrainingandroid2025.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.beginnertrainingandroid2025.data.Repo
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun RepoListItem(
    repo: Repo,
    isBookmarked: Boolean,
    onBookmarkIconClick: (Repo) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            Text(
                text = repo.name,
                fontWeight = FontWeight.Bold,
            )
            repo.description?.let { Text(text = it) }
            Row {
                Icon(
                    imageVector = Icons.Outlined.Star,
                    tint = Color.LightGray,
                    contentDescription = null,
                )
                Text(text = "${repo.stars}")
            }
        }

//        IconButton(onClick = { onBookmarkIconClick(repo) }) {
//            Icon(
//                painter = painterResource(if (isBookmarked) R.drawable.bookmark_filled else R.drawable.bookmark),
//                contentDescription = null,
//            )
//        }
    }
}

@Preview
@Composable
private fun RepoListItemPreview() {
    MaterialTheme {
        RepoListItem(
            repo = Repo(
                id = 123,
                name = "foo",
                description = "This is awesome repository.",
                stars = 123,
            ),
            isBookmarked = false,
            onBookmarkIconClick = {},
        )
    }
}