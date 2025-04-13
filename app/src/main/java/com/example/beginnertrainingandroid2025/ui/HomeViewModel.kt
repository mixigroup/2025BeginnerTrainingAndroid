package com.example.beginnertrainingandroid2025.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.beginnertrainingandroid2025.data.Repo
import com.example.beginnertrainingandroid2025.data.httpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel: ViewModel() {
    var uiState = MutableStateFlow(
        HomeUiState(
            items = emptyList(),
        )
    )
        private set

    fun onLaunched() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val items: List<Repo> = httpClient.get("https://api.github.com/orgs/mixigroup/repos").body()
                uiState.update {
                    it.copy(
                        items = items,
                    )
                }
            }
        }
    }
}