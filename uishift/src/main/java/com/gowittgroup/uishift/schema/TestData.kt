package com.gowittgroup.uishift.schema

val testData = """
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
              "onClickAction": {
                "type": "SubmitData",
                "formData": {
                  "name": "nameField",
                  "email": "emailField",
                  "termsAccepted": "termsCheckBox"
                }
              }
            },
            {
              "type": "Button",
              "id": "cancelButton",
              "label": "Cancel",
              "style": "secondaryButton",
              "onClickAction": {
                "type": "Navigate",
                "destination": "HomeScreen"
              }
            }
          ]
        }
      ]
    }
  ]
}
""".trimIndent()