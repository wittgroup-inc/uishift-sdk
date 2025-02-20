package com.gowittgroup.uishift.sample.sampledata

val sampleConfigJson = """
{
  "components": [
    {
      "type": "Column",
      "id": "mainColumn",
      "isScrollable": true,
      "width": "fillMaxSpace",
      "padding": {
        "top": 16,
        "bottom": 16,
        "start": 16,
        "end": 16
      },
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
          "style": "mainContent",
          "padding": {
            "bottom": 24
          }
        },
        {
          "type": "Image",
          "id": "appImage",
          "height": 250,
          "scaleType": "crop",
          "url": "https://picsum.photos/id/237/200/300",
          "description": "App screenshot"
        },
        {
          "type": "Row",
          "id": "buttonRow",
          "width": "fillMaxSpace",
          "padding": {
            "top": 8,
            "bottom": 8
          },
          "children": [
            {
              "type": "Button",
              "id": "startButton",
              "label": "Start Now",
              "style": "primaryButton",
              "onClickAction": {
                "type": "Single",
                "action": {
                  "type": "Navigate",
                  "destination": "home"
                }
              }
            },
            {
              "type": "Button",
              "id": "infoButton",
              "label": "More Info",
              "style": "secondaryButton",
              "onClickAction": {
                "type": "Single",
                "action": {
                  "type": "Navigate",
                  "destination": "home"
                }
              }
            }
          ]
        },
        {
          "type": "TextField",
          "id": "userNameField",
          "label": "Your Name",
          "hint": "Enter your name",
          "initialValue": "",
          "width": "fillMaxSpace"
        },
        {
          "type": "TextField",
          "id": "emailField",
          "label": "Email Address",
          "hint": "Enter your email",
          "initialValue": "",
          "width": "fillMaxSpace"
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
          "width": "fillMaxSpace",
          "padding": {
            "top": 8,
            "bottom": 8
          },
          "children": [
            {
              "type": "Button",
              "id": "submitButton",
              "label": "Submit",
              "style": "tertiaryButton",
              "onClickAction": {
                "type": "Single",
                "action": {
                  "type": "ApiRequest",
                  "requestModel": {
                    "type": "Command",
                    "action": "",
                    "parameters": {
                      
                    },
                    "headers": {
                      
                    },
                    "endpoint": "register",
                    "retries": 3,
                    "timeout": 3000
                  },
                  "retryCount": 0
                }
              }
            },
            {
              "type": "Button",
              "id": "cancelButton",
              "label": "Cancel",
              "style": "outlinedButton",
              "onClickAction": {
                "type": "Single",
                "action": {
                  "type": "Navigate",
                  "destination": "home"
                }
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
          "isChecked": true,
          "width": "fillMaxSpace"
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