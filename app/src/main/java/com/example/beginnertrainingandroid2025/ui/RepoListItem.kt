package com.example.beginnertrainingandroid2025.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.beginnertrainingandroid2025.data.Repo
import com.example.beginnertrainingandroid2025.ui.theme.BeginnerTrainingAndroid2025Theme

@Composable
fun RepoListItem(
    repo: Repo,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
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
}

@Preview(showBackground = true)
@Composable
fun RepoListItemPreview() {
    BeginnerTrainingAndroid2025Theme {
        RepoListItem(
            repo = Repo(
                id = 123,
                name = "foo",
                description = "This is awesome repository.",
                stars = 123,
            ),
        )
    }
}