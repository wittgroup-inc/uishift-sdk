# UIShift SDK Configuration Guide

UIShift is an SDK designed to dynamically generate user interfaces (***Server-driven UI***) using Jetpack Compose based on a configuration file. This document provides a detailed guide on how to create a `ScreenConfiguration` JSON document, including all available components, styles, actions, and example configurations.

## Overview

UIShift allows developers to build flexible and dynamic user interfaces by defining UI components and their behaviors in a configuration file. By using Jetpack Compose, the SDK makes it easy to create rich, interactive UIs that adapt to changing data and user interactions.

## Components Overview

The following UI components are available for use in your configuration document:

### 1. TextComponent

- **Properties**:
  - `type`: String (Has fixed value `Text`)
  - `content`: String (The text to display)
  - `style`: String (The style token to apply)
  - `id`: String (Unique identifier)

### 2. ButtonComponent

- **Properties**:
  - `type`: String (Has fixed value `Button`)
  - `label`: String (The label displayed on the button)
  - `style`: String (The style token for button appearance)
  - `isEnabled`: Boolean (Whether enabled or disabled, defaults to `true`)
  - `onClickAction`: Action (The action to perform when clicked)
  - `id`: String (Unique identifier)

### 3. ImageComponent

- **Properties**:
  - `type`: String (Has fixed value `Image`)
  - `url`: String (The URL of the image)
  - `height`: Int (Height of the image)
  - `width`: Int (Width of the image)
  - `scaleType`: String (How image should scale, value can be `crop` or `fit` or `fillBounds`. defaults to `fit` )
  - `description`: String (Description of the image)
  - `id`: String (Unique identifier)

### 4. ColumnComponent

- **Properties**:
  - `type`: String (Has fixed value `Column`)
  - `children`: List<UIComponent> (List of child components)
  - `isScrollable`: Boolean (Default value `false`)
  - `id`: String (Unique identifier)

### 5. RowComponent

- **Properties**:
  - `type`: String (Has fixed value `Row`)
  - `children`: List<UIComponent> (List of child components)
  - `isScrollable`: Boolean (Default value `false`)
  - `id`: String (Unique identifier)

### 6. TextFieldComponent

- **Properties**:
  - `type`: String (Has fixed value `TextField`)
  - `label`: String (The label for the text field)
  - `hint`: String (The hint text shown inside the text field)
  - `isEnabled`: Boolean (Whether enabled or disabled, defaults to `true`)
  - `readOnly`: Boolean (Whether editable, defaults to `true`)
  - `initialValue`: String (The default value, defaults to empty)
  - `id`: String (Unique identifier)

### 7. CheckBoxComponent

- **Properties**:
  - `type`: String (Has fixed value `Checkbox`)
  - `label`: String (The label for the checkbox)
  - `isEnabled`: Boolean (Whether enabled or disabled, defaults to `true`)
  - `isChecked`: Boolean (Whether the checkbox is checked, defaults to false)
  - `id`: String (Unique identifier)

### 8. SliderComponent

- **Properties**:
  - `type`: String (Has fixed value `Slider`)
  - `min`: Float (Minimum value of the slider)
  - `max`: Float (Maximum value of the slider)
  - `isEnabled`: Boolean (Whether enabled or disabled, defaults to `true`)
  - `initialValue`: Float (Initial value of the slider)
  - `id`: String (Unique identifier)

### 9. RadioButton

- **Properties**:
  - `type`: String (Has fixed value `RadioButton`)
  - `label`: String (The label for the radio button)
  - `isEnabled`: Boolean (Whether enabled or disabled, defaults to `true`)
  - `isSelected`: Boolean (Whether the radio button is selected, defaults to false)
  - `id`: String (Unique identifier)

### 10. Switch

- **Properties**:
  - `type`: String (Has fixed value `Switch`)
  - `label`: String (The label for the switch)
  - `isEnabled`: Boolean (Whether enabled or disabled, defaults to `true`)
  - `isChecked`: Boolean (Whether the switch is checked, defaults to false)
  - `id`: String (Unique identifier)

### 11. Divider

- **Properties**:
  - `type`: String (Has fixed value `Divider`)
  - `direction`: String (direction for the divider, value can be `horizontal` or `vertical`, defaults to `horizontal`)
  - `thickness`: Int (Thickness of divider, defaults to 1)
  - `color`: String (Color of divider, can be any hexadecimal color code, default to `#000000`)
  - `id`: String (Unique identifier)

### 12. Spacer

- **Properties**:
  - `type`: String (Has fixed value `Spacer`)
  - `label`: String (The label for the switch)
  - `height`: Int (Height of spacer)
  - `id`: String (Unique identifier)

## Actions Overview

The following actions can be performed in response to UI events:

### 1. Navigate

- **Properties**:
  - `destination`: String (The destination to navigate to)

### 2. SubmitData

- **Properties**:
  - `formData`: Map<String, String> (Key-value pairs of form data)

### 3. ValidateField

- **Properties**:
  - `fieldId`: String (The ID of the field to validate)

### 4. NoAction

- Represents no action to be taken.

## Styles Overview

### Theme 

- Theme is configurable, can be configured as below.

```kotlin
        
        val colorScheme = UiShiftColorScheme(primaryButtonBackground = Color.LightGray)
        val typography = UiShiftTypography(
            mainTitle = TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                letterSpacing = 0.sp
            )
        )
        UiShift.initialize(
            colorScheme = colorScheme,
            typography = typography
        )
```
- Note: Available pre-defined color schemes are lightColorScheme() or darkColorScheme, defaults to lightColorScheme, but developer define their own color schemes as well.

### Button Styles

- **primaryButton**: Default primary button style.
- **secondaryButton**: Secondary button style.
- **tertiaryButton**: Tertiary button style.
- **outlinedButton**: Outlined button style.
- **destructiveButton**: Red button style for destructive actions.

### Text Styles

- **mainTitle**: Style for the main title.
- **sectionTitle**: Style for section titles.
- **subSectionTitle**: Style for sub-section titles.
- **primaryHeader**: Style for primary headers.
- **secondaryHeader**: Style for secondary headers.
- **tertiaryHeader**: Style for tertiary headers.
- **primaryTitle**: Style for primary titles.
- **secondaryTitle**: Style for secondary titles.
- **tertiaryTitle**: Style for tertiary titles.
- **mainContent**: Style for main content text.
- **secondaryContent**: Style for secondary content text.
- **smallContent**: Style for smaller content text.
- **primaryLabel**: Style for primary labels.
- **secondaryLabel**: Style for secondary labels.
- **smallLabel**: Style for small labels.

## Creating a ScreenConfiguration JSON

Here's how youcan create a valid JSON document for a `ScreenConfiguration`.

### Example JSON Configuration

```json
{
  "components": [
    {
      "type": "Column",
      "id": "mainColumn",
      "isScrollable": true,
      "children": [
        {
          "type": "Text",
          "id": "welcomeText",
          "content": "Welcome to Your Application",
          "style": "primaryHeader"
        },
        {
          "type": "Text",
          "id": "appDescription",
          "content": "This application helps you manage your tasks efficiently.",
          "style": "mainContent"
        },
        {
          "type": "Image",
          "id": "appImage",
          "height": 200,
          "scaleType": "crop",
          "url": "https://picsum.photos/id/237/200/300",
          "description": "App screenshot"
        },
        {
          "type": "Row",
          "id": "buttonRow",
          "children": [
            {
              "type": "Button",
              "id": "startButton",
              "label": "Start Now",
              "style": "primaryButton",
              "onClickAction": {
                "type": "Navigate",
                "destination": "task_list"
              }
            },
            {
              "type": "Button",
              "id": "infoButton",
              "label": "More Info",
              "style": "secondaryButton",
              "onClickAction": {
                "type": "Navigate",
                "destination": "info_page"
              }
            }
          ]
        },
        {
          "type": "TextField",
          "id": "userNameField",
          "label": "Your Name",
          "hint": "Enter your name",
          "initialValue": ""
        },
        {
          "type": "TextField",
          "id": "emailField",
          "label": "Email Address",
          "hint": "Enter your email",
          "initialValue": ""
        },
        {
          "type": "Checkbox",
          "id": "termsCheckBox",
          "label": "I accept the terms and conditions",
          "isChecked": false
        },
        {
          "type": "Slider",
          "id": "prioritySlider",
          "min": 1,
          "max": 5,
          "initialValue": 3
        },
        {
          "type": "Row",
          "id": "actionRow",
          "children": [
            {
              "type": "Button",
              "id": "submitButton",
              "label": "Submit",
              "style": "tertiaryButton",
              "onClickAction": {
                "type": "SubmitData",
                "formData": {
                  "name": "userNameField",
                  "email": "emailField",
                  "termsAccepted": "termsCheckBox"
                }
              }
            },
            {
              "type": "Button",
              "id": "cancelButton",
              "label": "Cancel",
              "style": "outlinedButton",
              "onClickAction": {
                "type": "NoAction"
              }
            }
          ]
        },
        {
          "type": "Text",
          "id": "footerText",
          "content": "Thank you for using our app!",
          "style": "secondaryContent"
        },
        {
          "type": "RadioButton",
          "id": "red",
          "label": "Red",
          "isSelected": false
        },
        {
          "type": "Switch",
          "id": "botSetting",
          "label": "Enable bot",
          "isChecked": true
        },
        {
          "type": "Divider",
          "id": "startDivider",
          "direction": "horizontal",
          "thickness": 1
        },
        {
          "type": "Spacer",
          "id": "space",
          "height": 32
        },
        {
          "type": "Divider",
          "id": "endDivider",
          "direction": "horizontal",
          "thickness": 1
        }
      ]
    }
  ]
}
````
### Result of above JSON Configuration
![Screenshot of UIShift](screen_recording.gif)
### Usage
#### Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories
````
	dependencyResolutionManagement {
		repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
		repositories {
			mavenCentral()
			maven { url 'https://jitpack.io' }
		}
	}
````
#### Step 2. Add the dependency
Add the dependency module build.gradle

````
	dependencies {
	        implementation 'com.github.wittgroup-inc:uishift-sdk:Tag'
	}
````
[![](https://jitpack.io/v/wittgroup-inc/uishift-sdk.svg)](https://jitpack.io/#wittgroup-inc/uishift-sdk)
##
