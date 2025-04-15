package com.example.beginnertrainingandroid2025.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.beginnertrainingandroid2025.data.DefaultRepoRepository
import com.example.beginnertrainingandroid2025.data.Repo
import com.example.beginnertrainingandroid2025.data.RepoLocalDataSource
import com.example.beginnertrainingandroid2025.data.RepoRemoteDataSource
import com.example.beginnertrainingandroid2025.di.LocalDataSourceFactory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.reflect.KClass

class BookmarkViewModel(
    private val repository: DefaultRepoRepository,
): ViewModel() {
    var uiState = MutableStateFlow(
        BookmarkScreenUiState(
            items = emptyList(),
        )
    )
        private set

    fun onLaunched() {
        viewModelScope.launch {
            uiState.value = BookmarkScreenUiState(
                items = repository.getBookmarkedRepoList(),
            )
        }
    }

    fun onBookmarkIconClick(repo: Repo) {
        viewModelScope.launch {
            repository.saveAsUnBookmark(repo)

            uiState.update {
                it.copy(items = repository.getBookmarkedRepoList())
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: KClass<T>, extras: CreationExtras): T {
                return BookmarkViewModel(
                    repository = DefaultRepoRepository(
                        localDataSource = LocalDataSourceFactory.createRepoLocalDataSource(),
                        remoteDataSource = RepoRemoteDataSource(),
                    ),
                ) as T
            }
        }
    }
}
