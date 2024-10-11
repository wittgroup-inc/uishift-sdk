package com.gowittgroup.uishift


import UiShiftTypography
import com.gowittgroup.uishift.theme.ThemeConfig
import com.gowittgroup.uishift.theme.UiShiftColorScheme
import com.gowittgroup.uishift.theme.lightColorScheme

object UiShift {
    fun initialize(
        colorScheme: UiShiftColorScheme = lightColorScheme(),
        typography: UiShiftTypography = UiShiftTypography()
    ) {
        ThemeConfig.colorScheme = colorScheme
        ThemeConfig.typography = typography
    }
}