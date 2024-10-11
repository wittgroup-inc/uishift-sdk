import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
class UiShiftColorScheme(
    // Button Colors
    val primaryButtonBackground: Color = Color(0xFF007AFF),  // Primary button background color
    val primaryButtonTextColor: Color = Color.White,  // Primary button text color
    val primaryButtonDisabledBackground: Color = Color.Gray,  // Primary button background when disabled
    val primaryButtonDisabledTextColor: Color = Color.LightGray,  // Primary button text when disabled

    // Secondary Button Colors
    val secondaryButtonBackground: Color = Color(0xFFE0E0E0),  // Secondary button background color
    val secondaryButtonTextColor: Color = Color.Black,  // Secondary button text color
    val secondaryButtonDisabledBackground: Color = Color.Gray,  // Secondary button background when disabled
    val secondaryButtonDisabledTextColor: Color = Color.LightGray,  // Secondary button text when disabled

    // Tertiary Button Colors
    val tertiaryButtonBackground: Color = Color(0xFFADD8E6),  // Tertiary button background color
    val tertiaryButtonTextColor: Color = Color.Black,  // Tertiary button text color
    val tertiaryButtonDisabledBackground: Color = Color.Gray,  // Tertiary button background when disabled
    val tertiaryButtonDisabledTextColor: Color = Color.LightGray,  // Tertiary button text when disabled

    // Outlined Button Colors
    val outlinedButtonBorderColor: Color = Color.Gray,  // Outlined button border color
    val outlinedButtonTextColor: Color = Color.Black,  // Outlined button text color
    val outlinedButtonDisabledBorderColor: Color = Color.LightGray,  // Outlined button border when disabled
    val outlinedButtonDisabledTextColor: Color = Color.LightGray,  // Outlined button text when disabled

    // Destructive Button Colors
    val destructiveButtonBackground: Color = Color.Red,  // Destructive button background color
    val destructiveButtonTextColor: Color = Color.White,  // Destructive button text color
    val destructiveButtonDisabledBackground: Color = Color.Gray,  // Destructive button background when disabled
    val destructiveButtonDisabledTextColor: Color = Color.LightGray,  // Destructive button text when disabled

    // Text Colors
    val mainTitleTextColor: Color = Color.Black,  // Main title text color
    val sectionTitleTextColor: Color = Color.Black,  // Section title text color
    val subSectionTitleTextColor: Color = Color.Black,  // Subsection title text color
    val primaryHeaderTextColor: Color = Color.Black,  // Primary header text color
    val secondaryHeaderTextColor: Color = Color.Black,  // Secondary header text color
    val tertiaryHeaderTextColor: Color = Color.Black,  // Tertiary header text color
    val primaryTitleTextColor: Color = Color(0xFF007AFF),  // Primary title text color
    val secondaryTitleTextColor: Color = Color(0xFF007AFF),  // Secondary title text color
    val tertiaryTitleTextColor: Color = Color(0xFF007AFF),  // Tertiary title text color
    val bodyTextColor: Color = Color(0xFF8E8E93),  // Body text color
    val labelTextColor: Color = Color.DarkGray,  // Label text color
    val secondaryLabelTextColor:Color = Color.DarkGray, // Secondary label text color

    // TextField Colors
    val textFieldBackground: Color = Color.White,  // TextField background color
    val textFieldBorderColor: Color = Color.Gray,  // TextField border color
    val textFieldTextColor: Color = Color.Black,  // TextField text color
    val textFieldFocusedBorderColor: Color = Color(0xFF007AFF),  // TextField border color when focused
    val textFieldDisabledBackground: Color = Color(0xFFE0E0E0),  // TextField background when disabled
    val textFieldDisabledBorderColor: Color = Color.Gray, // // TextField border color when disabled

    // Checkbox Colors
    val checkboxCheckedColor: Color = Color(0xFF007AFF),  // Checkbox color when checked
    val checkboxUncheckedColor: Color = Color.LightGray,  // Checkbox color when unchecked
    val checkboxDisabledColor: Color = Color.Gray,  // Checkbox color when disabled

    // Switch Colors
    val switchOnTrackColor: Color = Color(0xFF007AFF),  // Switch track color when ON
    val switchOffTrackColor: Color = Color.LightGray,  // Switch track color when OFF
    val switchOnThumbColor: Color = Color.White,  // Switch checked thumb color
    val switchOffThumbColor: Color = Color.Gray, // Switch unchecked thumb color
    val switchDisabledTrackColor: Color = Color.LightGray,  // Switch track color when disabled
    val switchDisabledThumbColor: Color = Color.Gray,  // Switch thumb color when disabled

    // Slider Colors
    val sliderTrackColor: Color = Color(0xFF007AFF),  // Slider track color
    val sliderThumbColor: Color = Color(0xFF007AFF),  // Slider thumb color
    val sliderDisabledTrackColor: Color = Color.LightGray,  // Slider track color when disabled
    val sliderDisabledThumbColor: Color = Color.LightGray,  // Slider thumb color when disabled

    // Primary Container Colors
    val primaryContainerBackground: Color = Color(0xFFE0F7FA),  // Primary container background color
    val primaryContainerBorderColor: Color = Color(0xFFB2EBF2),  // Primary container border color
    val primaryContainerDisabledBackground: Color = Color.LightGray,  // Primary container background when disabled
    val primaryContainerDisabledBorderColor: Color = Color.Gray,  // Primary container border when disabled

    // Secondary Container Colors
    val secondaryContainerBackground: Color = Color(0xFFFFFDE7),  // Secondary container background color
    val secondaryContainerBorderColor: Color = Color(0xFFFFE57F),  // Secondary container border color
    val secondaryContainerDisabledBackground: Color = Color.LightGray,  // Secondary container background when disabled
    val secondaryContainerDisabledBorderColor: Color = Color.Gray,  // Secondary container border when disabled

    // Tertiary Container Colors
    val tertiaryContainerBackground: Color = Color(0xFFF3E5F5),  // Tertiary container background color
    val tertiaryContainerBorderColor: Color = Color(0xFFE1BEE7),  // Tertiary container border color
    val tertiaryContainerDisabledBackground: Color = Color.LightGray,  // Tertiary container background when disabled
    val tertiaryContainerDisabledBorderColor: Color = Color.Gray  // Tertiary container border when disabled
)
