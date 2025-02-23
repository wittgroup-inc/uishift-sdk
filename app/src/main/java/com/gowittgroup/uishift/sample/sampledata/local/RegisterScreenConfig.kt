
val registerScreenConfig = """
    {
      "components": [
        {
          "type": "Text",
          "content": "Registration",
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
          "type": "TextField",
          "label": "Full name",
          "hint": "Enter full name",
          "initialValue": "",
          "isEnabled": true,
          "readOnly": false,
          "validation": {
            "type": "None",
            "none": "None"
          },
          "imeAction": "done",
          "keyboardType": "text",
          "id": "fullNameField",
          "padding": {
            "top": 8,
            "bottom": 0,
            "start": 0,
            "end": 0
          },
          "visibility": "visible",
          "alignment": "start",
          "interactions": {
            
          },
          "width": "fillMaxSpace"
        },
        {
          "type": "TextField",
          "label": "Email",
          "hint": "email@domain",
          "initialValue": "",
          "isEnabled": true,
          "readOnly": false,
          "validation": {
            "type": "TextValidation",
            "required": false,
            "regex": "^[^@]+@[^@]+\\.[^@]+${'$'}"
          },
          "imeAction": "done",
          "keyboardType": "text",
          "id": "emailField",
          "padding": {
            "top": 8,
            "bottom": 0,
            "start": 0,
            "end": 0
          },
          "visibility": "visible",
          "alignment": "start",
          "interactions": {
            
          },
          "width": "fillMaxSpace"
        },
        {
          "type": "TextField",
          "label": "Password",
          "hint": "password",
          "initialValue": "",
          "isEnabled": true,
          "readOnly": false,
          "validation": {
            "type": "None",
            "none": "None"
          },
          "imeAction": "done",
          "keyboardType": "text",
          "id": "password",
          "padding": {
            "top": 8,
            "bottom": 0,
            "start": 0,
            "end": 0
          },
          "visibility": "visible",
          "alignment": "start",
          "interactions": {
            
          },
          "width": "fillMaxSpace"
        },
        {
          "type": "Checkbox",
          "label": "Accept the terms and condition.",
          "isChecked": false,
          "isEnabled": true,
          "validation": {
            "type": "None",
            "none": "None"
          },
          "id": "termsAndCondition",
          "padding": {
            "top": 8,
            "bottom": 0,
            "start": 0,
            "end": 0
          },
          "visibility": "visible",
          "alignment": "start",
          "interactions": {
            
          },
          "width": "fillMaxSpace"
        },
        {
          "type": "Row",
          "children": [
            {
              "type": "Button",
              "label": "Register",
              "style": "primaryButton",
              "onClickAction": {
                "type": "Sequence",
                "sequence": {
                  "core": {
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
                  },
                  "prefixes": [
                    {
                      "type": "ValidateField",
                      "field": {
                        "id": "emailField",
                        "type": "TextField"
                      },
                      "validation": {
                        "type": "TextValidation",
                        "required": false,
                        "regex": "^[^@]+@[^@]+\\.[^@]+${'$'}"
                      }
                    },
                    {
                      "type": "ValidateField",
                      "field": {
                        "id": "termsAndCondition",
                        "type": "Checkbox"
                      },
                      "validation": {
                        "type": "BooleanValidation",
                        "required": true
                      }
                    }
                  ],
                  "postfixes": [
                    {
                      "type": "Navigate",
                      "destination": "details"
                    }
                  ]
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
              "height": 60
            },
            {
              "type": "Button",
              "label": "Cancel",
              "style": "tertiaryButton",
              "onClickAction": {
                "type": "Single",
                "action": {
                  "type": "Navigate",
                  "destination": "back"
                }
              },
              "isEnabled": true,
              "id": "cancelButton",
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
            }
          ],
          "isScrollable": false,
          "childArrangement": {
            "direction": "VERTICAL",
            "spacing": 8,
            "alignment": "START",
            "isWrap": false
          },
          "id": "buttons",
          "padding": {
            "top": 0,
            "bottom": 0,
            "start": 16,
            "end": 16
          },
          "visibility": "visible",
          "alignment": "start",
          "interactions": {
            
          },
          "width": "fillMaxSpace"
        }
      ]
    }
""".trimIndent()