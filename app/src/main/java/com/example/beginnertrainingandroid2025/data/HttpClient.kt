package com.example.beginnertrainingandroid2025.data

import com.example.beginnertrainingandroid2025.BuildConfig
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

val httpClient = HttpClient(CIO) {
    install(ContentNegotiation) {
        json(json = Json { ignoreUnknownKeys = true })
    }

    install(Auth) {
        bearer {
            BearerTokens(accessToken = BuildConfig.GITHUB_API_KEY, refreshToken = null)
        }
    }
}
