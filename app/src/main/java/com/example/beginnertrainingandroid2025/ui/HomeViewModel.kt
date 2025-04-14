package com.example.beginnertrainingandroid2025.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.beginnertrainingandroid2025.data.Repo
import com.example.beginnertrainingandroid2025.data.RepoRemoteDataSource
import com.example.beginnertrainingandroid2025.data.RepoRepository
import com.example.beginnertrainingandroid2025.di.LocalDataSourceFactory
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
                    items = repository.getRepoList(),
                    bookmarkedItems = repository.getBookmarkedRepoList().toSet(),
                )
            }
        }
    }

    fun onClickBookmark(item: Repo) {
        viewModelScope.launch {
            uiState.update {
                if (item in uiState.value.bookmarkedItems) {
                    repository.saveAsUnBookmark(item)
                } else {
                    repository.saveAsBookmark(item)
                }

                it.copy(bookmarkedItems = repository.getBookmarkedRepoList().toSet())
            }
        }
    }

    companion object {
        val Factory =
            object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(modelClass: Class<T>): T =
                    HomeViewModel(
                        repository = RepoRepository(
                            localDataSource = LocalDataSourceFactory.createRepoLocalDataSource(),
                            remoteDataSource = RepoRemoteDataSource(),
                        ),
                    ) as T
            }
    }
}