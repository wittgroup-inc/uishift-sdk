package com.gowittgroup.uishift

val testData = """
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
          "url": "{image url}",
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
""".trimIndent()