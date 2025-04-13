package com.example.beginnertrainingandroid2025.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.beginnertrainingandroid2025.data.Repo
import com.example.beginnertrainingandroid2025.data.RepoRemoteDataSource
import com.example.beginnertrainingandroid2025.data.RepoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: RepoRepository,
): ViewModel() {
    var uiState = MutableStateFlow(
        HomeUiState(
            items = emptyList(),
            bookmarkedItems = emptySet(),
        )
    )
        private set

    fun onLaunched() {
        viewModelScope.launch {
            uiState.update {
                it.copy(
                    items = repository.getRepos(),
                )
            }
        }
    }

    fun onClickBookmark(item: Repo) {
        uiState.update {
            val bookmarkedItems = if (item in uiState.value.bookmarkedItems) {
                it.bookmarkedItems - item
            } else {
                it.bookmarkedItems + item
            }

            it.copy(bookmarkedItems = bookmarkedItems)
        }
    }

    companion object {
        val Factory =
            object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(modelClass: Class<T>): T =
                    HomeViewModel(
                        repository = RepoRepository(
                            remoteDataSource = RepoRemoteDataSource(),
                        ),
                    ) as T
            }
    }
}