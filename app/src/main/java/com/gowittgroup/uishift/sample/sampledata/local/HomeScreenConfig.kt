package com.gowittgroup.uishift.sample.sampledata.local

val homeScreenConfig = """
    {
      "components": [
        {
          "type": "Text",
          "content": "Welcome!!",
          "style": "mainTitle",
          "visualTransformation": "none",
          "id": "screenTitle",
          "padding": {
            "top": 0,
            "bottom": 0,
            "start": 0,
            "end": 0
          },
          "visibility": "visible",
          "alignment": "start",
          "interactions": {
            
          }
        },
        {
          "type": "Button",
          "label": "Register",
          "style": "primaryButton",
          "onClickAction": {
            "type": "Single",
            "action": {
              "type": "Navigate",
              "destination": "register"
            }
          },
          "isEnabled": true,
          "id": "registerButton",
          "padding": {
            "top": 0,
            "bottom": 0,
            "start": 0,
            "end": 0
          },
          "visibility": "visible",
          "alignment": "start",
          "interactions": {
            
          },
          "height": 50
        }
      ]
    }
""".trimIndent()