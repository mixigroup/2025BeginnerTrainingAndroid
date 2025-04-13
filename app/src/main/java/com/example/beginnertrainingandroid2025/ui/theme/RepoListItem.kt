package com.example.beginnertrainingandroid2025.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.beginnertrainingandroid2025.data.Repo

@Composable
fun RepoListItem(
    repo: Repo,
    modifier: Modifier = Modifier,
) {

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