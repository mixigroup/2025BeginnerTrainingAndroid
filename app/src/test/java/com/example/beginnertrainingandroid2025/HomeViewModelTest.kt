package com.example.beginnertrainingandroid2025

import com.example.beginnertrainingandroid2025.data.Repo
import com.example.beginnertrainingandroid2025.fake.FakeRepoRepository
import com.example.beginnertrainingandroid2025.ui.HomeUiState
import com.example.beginnertrainingandroid2025.ui.HomeViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class HomeViewModelTest {
    @Before
    fun setUp() {
        Dispatchers.setMain(StandardTestDispatcher())
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun onLaunchedTest() = runTest {
        val repos = listOf(
            Repo(
                id = 1,
                name = "fake repo1",
                stars = 12,
            ),
            Repo(
                id = 2,
                description = "this is fake repository",
                name = "fake repo2",
                stars = 3,
            ),
        )

        val viewModel = HomeViewModel(
            repository = FakeRepoRepository(
                repos = repos,
                bookmarkedRepos = emptyList(),
            ),
        )

        viewModel.onLaunched()
        advanceUntilIdle()

        assertEquals(
            HomeUiState(
                items = repos,
                bookmarkedItems = emptySet(),
            ),
            viewModel.uiState.value,
        )
    }
}