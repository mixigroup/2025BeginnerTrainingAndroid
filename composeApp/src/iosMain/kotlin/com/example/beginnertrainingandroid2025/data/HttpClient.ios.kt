package com.example.beginnertrainingandroid2025.data

import com.example.beginnertrainingandroid2025.AppConfig
import io.ktor.client.HttpClient
import io.ktor.client.engine.darwin.Darwin
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

actual val httpClient: HttpClient
    get() = HttpClient(Darwin) {
    install(ContentNegotiation) {
        json(json = Json { ignoreUnknownKeys = true })
    }

    install(Auth) {
        bearer {
            BearerTokens(accessToken = AppConfig.GITHUB_API_TOKEN, refreshToken = null)
        }
    }
}