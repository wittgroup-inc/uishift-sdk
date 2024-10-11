package com.gowittgroup.uishift.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
class UiShiftColorScheme(
    // Primary Button Colors
    val primaryButtonBackground: Color = ColorLightTokens.PrimaryButtonBackground,  // Primary button background color
    val primaryButtonTextColor: Color = ColorLightTokens.PrimaryButtonTextColor,  // Primary button text color
    val primaryButtonDisabledBackground: Color = ColorLightTokens.PrimaryButtonDisabledBackground,  // Primary button background when disabled
    val primaryButtonDisabledTextColor: Color = ColorLightTokens.PrimaryButtonDisabledTextColor,  // Primary button text when disabled

    // Secondary Button Colors
    val secondaryButtonBackground: Color = ColorLightTokens.SecondaryButtonBackground,  // Secondary button background color
    val secondaryButtonTextColor: Color = ColorLightTokens.SecondaryButtonTextColor,  // Secondary button text color
    val secondaryButtonDisabledBackground: Color = ColorLightTokens.SecondaryButtonDisabledBackground,  // Secondary button background when disabled
    val secondaryButtonDisabledTextColor: Color = ColorLightTokens.SecondaryButtonDisabledTextColor,  // Secondary button text when disabled

    // Tertiary Button Colors
    val tertiaryButtonBackground: Color = ColorLightTokens.TertiaryButtonBackground,  // Tertiary button background color
    val tertiaryButtonTextColor: Color = ColorLightTokens.TertiaryButtonTextColor,  // Tertiary button text color
    val tertiaryButtonDisabledBackground: Color = ColorLightTokens.TertiaryButtonDisabledBackground,  // Tertiary button background when disabled
    val tertiaryButtonDisabledTextColor: Color = ColorLightTokens.TertiaryButtonDisabledTextColor,  // Tertiary button text when disabled

    // Outlined Button Colors
    val outlinedButtonBorderColor: Color = ColorLightTokens.OutlinedButtonBorderColor,  // Outlined button border color
    val outlinedButtonTextColor: Color = ColorLightTokens.OutlinedButtonTextColor,  // Outlined button text color
    val outlinedButtonDisabledBorderColor: Color = ColorLightTokens.OutlinedButtonDisabledBorderColor,  // Outlined button border when disabled
    val outlinedButtonDisabledTextColor: Color = ColorLightTokens.OutlinedButtonDisabledTextColor,  // Outlined button text when disabled

    // Destructive Button Colors
    val destructiveButtonBackground: Color = ColorLightTokens.DestructiveButtonBackground,  // Destructive button background color
    val destructiveButtonTextColor: Color = ColorLightTokens.DestructiveButtonTextColor,  // Destructive button text color
    val destructiveButtonDisabledBackground: Color = ColorLightTokens.DestructiveButtonDisabledBackground,  // Destructive button background when disabled
    val destructiveButtonDisabledTextColor: Color = ColorLightTokens.DestructiveButtonDisabledTextColor,  // Destructive button text when disabled

    // Text Colors
    val mainTitleTextColor: Color = ColorLightTokens.MainTitleTextColor,  // Main title text color
    val sectionTitleTextColor: Color = ColorLightTokens.SectionTitleTextColor,  // Section title text color
    val subSectionTitleTextColor: Color = ColorLightTokens.SubSectionTitleTextColor,  // Subsection title text color
    val primaryHeaderTextColor: Color = ColorLightTokens.PrimaryHeaderTextColor,  // Primary header text color
    val secondaryHeaderTextColor: Color = ColorLightTokens.SecondaryHeaderTextColor,  // Secondary header text color
    val tertiaryHeaderTextColor: Color = ColorLightTokens.TertiaryHeaderTextColor,  // Tertiary header text color
    val primaryTitleTextColor: Color = ColorLightTokens.PrimaryTitleTextColor,  // Primary title text color
    val secondaryTitleTextColor: Color = ColorLightTokens.SecondaryTitleTextColor,  // Secondary title text color
    val tertiaryTitleTextColor: Color = ColorLightTokens.TertiaryTitleTextColor,  // Tertiary title text color
    val bodyTextColor: Color = ColorLightTokens.BodyTextColor,  // Body text color
    val labelTextColor: Color = ColorLightTokens.LabelTextColor,  // Label text color
    val secondaryLabelTextColor: Color = ColorLightTokens.SecondaryLabelTextColor, // Secondary label text color

    // TextField Colors
    val textFieldBackground: Color = ColorLightTokens.TextFieldBackground,  // TextField background color
    val textFieldBorderColor: Color = ColorLightTokens.TextFieldBorderColor,  // TextField border color
    val textFieldTextColor: Color = ColorLightTokens.TextFieldTextColor,  // TextField text color
    val textFieldFocusedBorderColor: Color = ColorLightTokens.TextFieldFocusedBorderColor,  // TextField border color when focused
    val textFieldDisabledBackground: Color = ColorLightTokens.TextFieldDisabledBackground,  // TextField background when disabled
    val textFieldDisabledBorderColor: Color = ColorLightTokens.TextFieldDisabledBorderColor, // TextField border color when disabled

    // Checkbox Colors
    val checkboxCheckedColor: Color = ColorLightTokens.CheckboxCheckedColor,  // Checkbox color when checked
    val checkboxUncheckedColor: Color = ColorLightTokens.CheckboxUncheckedColor,  // Checkbox color when unchecked
    val checkboxDisabledColor: Color = ColorLightTokens.CheckboxDisabledColor,  // Checkbox color when disabled

    // Switch Colors
    val switchOnTrackColor: Color = ColorLightTokens.SwitchOnTrackColor,  // Switch track color when ON
    val switchOffTrackColor: Color = ColorLightTokens.SwitchOffTrackColor,  // Switch track color when OFF
    val switchOnThumbColor: Color = ColorLightTokens.SwitchOnThumbColor,  // Switch checked thumb color
    val switchOffThumbColor: Color = ColorLightTokens.SwitchOffThumbColor, // Switch unchecked thumb color
    val switchDisabledTrackColor: Color = ColorLightTokens.SwitchDisabledTrackColor,  // Switch track color when disabled
    val switchDisabledThumbColor: Color = ColorLightTokens.SwitchDisabledThumbColor,  // Switch thumb color when disabled

    // Slider Colors
    val sliderTrackColor: Color = ColorLightTokens.SliderTrackColor,  // Slider track color
    val sliderThumbColor: Color = ColorLightTokens.SliderThumbColor,  // Slider thumb color
    val sliderDisabledTrackColor: Color = ColorLightTokens.SliderDisabledTrackColor,  // Slider track color when disabled
    val sliderDisabledThumbColor: Color = ColorLightTokens.SliderDisabledThumbColor,  // Slider thumb color when disabled

    // Primary Container Colors
    val primaryContainerBackground: Color = ColorLightTokens.PrimaryContainerBackground,  // Primary container background color
    val primaryContainerBorderColor: Color = ColorLightTokens.PrimaryContainerBorderColor,  // Primary container border color
    val primaryContainerDisabledBackground: Color = ColorLightTokens.PrimaryContainerDisabledBackground,  // Primary container background when disabled
    val primaryContainerDisabledBorderColor: Color = ColorLightTokens.PrimaryContainerDisabledBorderColor,  // Primary container border when disabled

    // Secondary Container Colors
    val secondaryContainerBackground: Color = ColorLightTokens.SecondaryContainerBackground,  // Secondary container background color
    val secondaryContainerBorderColor: Color = ColorLightTokens.SecondaryContainerBorderColor,  // Secondary container border color
    val secondaryContainerDisabledBackground: Color = ColorLightTokens.SecondaryContainerDisabledBackground,  // Secondary container background when disabled
    val secondaryContainerDisabledBorderColor: Color = ColorLightTokens.SecondaryContainerDisabledBorderColor,  // Secondary container border when disabled

    // Tertiary Container Colors
    val tertiaryContainerBackground: Color = ColorLightTokens.TertiaryContainerBackground,  // Tertiary container background color
    val tertiaryContainerBorderColor: Color = ColorLightTokens.TertiaryContainerBorderColor,  // Tertiary container border color
    val tertiaryContainerDisabledBackground: Color = ColorLightTokens.TertiaryContainerDisabledBackground,  // Tertiary container background when disabled
    val tertiaryContainerDisabledBorderColor: Color = ColorLightTokens.TertiaryContainerDisabledBorderColor  // Tertiary container border when disabled
)
