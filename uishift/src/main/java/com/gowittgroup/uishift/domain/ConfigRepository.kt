package com.gowittgroup.uishift.domain

import com.gowittgroup.uishift.data.Result
import com.gowittgroup.uishift.models.ScreenConfiguration

interface ConfigRepository {
    suspend fun fetchScreenConfiguration(): Result<ScreenConfiguration>
}