package com.gowittgroup.uishift.sample.sampledata

val registrationSampleJsonConfig = """
{
  "components": [
    {
      "type": "Column",
      "id": "registrationColumn",
      "children": [
        {
          "type": "Text",
          "id": "headerText",
          "content": "User Registration",
          "style": "mainTitle"
        },
        {
          "type": "TextField",
          "id": "nameField",
          "label": "Name",
          "hint": "Enter your full name",
          "initialValue": ""
        },
        {
          "type": "TextField",
          "id": "emailField",
          "label": "Email",
          "hint": "example@example.com",
          "initialValue": ""
        },
        {
          "type": "Checkbox",
          "id": "termsCheckBox",
          "label": "I accept the terms and conditions",
          "isChecked": false
        },
        {
          "type": "Row",
          "id": "buttonRow",
          "children": [
            {
              "type": "Button",
              "id": "submitButton",
              "label": "Register",
              "style": "primaryButton",
              "onClickAction" : {
                "type": "Sequence",
                "action": {
                    "type": "ApiRequest",
                    "requestModel": {
                    
                    }
                    
                }
              
              }
            },
            {
              "type": "Button",
              "id": "cancelButton",
              "label": "Cancel",
              "style": "secondaryButton",
            }
          ]
        }
      ]
    }
  ]
}

""".trimIndent()

val dashBoardSampleJsonConfig = """
{
  "components": [
    {
      "type": "Column",
      "id": "dashboardColumn",
      "children": [
        {
          "type": "Text",
          "id": "welcomeText",
          "content": "Welcome to Your Dashboard",
          "style": "mainTitle"
        },
        {
          "type": "Text",
          "id": "profileInfo",
          "content": "Name: John Doe\\nEmail: john.doe@example.com",
          "style": "mainContent"
        },
        {
          "type": "TextField",
          "id": "editNameField",
          "label": "Edit Name",
          "hint": "Enter your new name",
          "initialValue": "John Doe"
        },
        {
          "type": "Slider",
          "id": "preferenceSlider",
          "min": 1,
          "max": 10,
          "initialValue": 5
        },
        {
          "type": "Row",
          "id": "actionButtonRow",
          "children": [
            {
              "type": "Button",
              "id": "saveChangesButton",
              "label": "Save Changes",
              "style": "primaryButton",
              "onClickAction": {
                "type": "SubmitData",
                "formData": {
                  "name": "editNameField"
                }
              }
            },
            {
              "type": "Button",
              "id": "logoutButton",
              "label": "Logout",
              "style": "secondaryButton",
              "onClickAction": {
                "type": "Navigate",
                "destination": "LoginScreen"
              }
            }
          ]
        }
      ]
    }
  ]
}
"""

val sampleConfigJson = """
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
""".trimIndent()