package com.example.beginnertrainingandroid2025

import platform.Foundation.NSBundle
import platform.Foundation.NSDictionary
import platform.Foundation.dictionaryWithContentsOfFile

actual object AppConfig {
    actual val GITHUB_API_TOKEN: String
        get() = getStringResource(
            filename = "Secrets",
            fileType = "plist",
            valueKey = "GITHUB_API_TOKEN"
        ) ?: ""
}

internal fun getStringResource(
    filename: String,
    fileType: String,
    valueKey: String,
): String? {
    val result = NSBundle.mainBundle.pathForResource(filename, fileType)?.let {
        val map = NSDictionary.dictionaryWithContentsOfFile(it)
        map?.get(valueKey) as? String
    }
    return result
}
