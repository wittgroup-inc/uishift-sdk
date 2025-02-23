package com.gowittgroup.uishift.screen

import com.gowittgroup.uishift.models.ScreenConfiguration

sealed class ScreenConfigState {
    data object Loading : ScreenConfigState()
    data class Success(val config: ScreenConfiguration) : ScreenConfigState()
    data class Error(val message: String) : ScreenConfigState()
}