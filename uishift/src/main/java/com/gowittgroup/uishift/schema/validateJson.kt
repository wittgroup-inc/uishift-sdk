package com.gowittgroup.uishift.schema

import org.everit.json.schema.Schema
import org.everit.json.schema.SchemaException
import org.everit.json.schema.loader.SchemaLoader
import org.json.JSONObject
import org.json.JSONTokener


fun validateJson(schemaString: String, jsonData: String) {
    try {
        // Load the JSON schema
        val schemaJson = JSONObject(schemaString)
        val schema: Schema = SchemaLoader.load(schemaJson)

        // Load the JSON data
        val jsonDataObject = JSONObject(JSONTokener(jsonData))

        // Validate the JSON data against the schema
        schema.validate(jsonDataObject)

        // If validation is successful
        println("JSON is valid")
    } catch (e: SchemaException) {
        // Handle validation errors
        println("Validation failed: ${e.message}")
    } catch (e: Exception) {
        // Handle any other exceptions
        println("An error occurred: ${e.message}")
    }
}


val schemaString = """
    {
      "$\schema": "http://json-schema.org/draft-07/schema#",
      "type": "object",
      "properties": {
        "components": {
          "type": "array",
          "items": {
            "type": "object",
            "properties": {
              "type": {
                "type": "string",
                "enum": [
                  "Text",
                  "Button",
                  "Image",
                  "Column",
                  "Row",
                  "TextField",
                  "Checkbox",
                  "Slider"
                ]
              },
              "id": {
                "type": "string"
              },
              "content": {
                "type": "string"
              },
              "style": {
                "type": "string"
              },
              "label": {
                "type": "string"
              },
              "hint": {
                "type": "string"
              },
              "initialValue": {
                "type": "string"
              },
              "min": {
                "type": "number"
              },
              "max": {
                "type": "number"
              },
              "isChecked": {
                "type": "boolean"
              },
              "children": {
                "type": "array",
                "items": { "$\ref": "#" }
              },
              "onClickAction": {
                "type": "object",
                "oneOf": [
                  {
                    "type": "object",
                    "properties": {
                      "type": {
                        "type": "string",
                        "enum": ["Navigate"]
                      },
                      "destination": {
                        "type": "string"
                      }
                    },
                    "required": ["type", "destination"],
                    "additionalProperties": false
                  },
                  {
                    "type": "object",
                    "properties": {
                      "type": {
                        "type": "string",
                        "enum": ["SubmitData"]
                      },
                      "formData": {
                        "type": "object",
                        "additionalProperties": {
                          "type": "string"
                        }
                      }
                    },
                    "required": ["type", "formData"],
                    "additionalProperties": false
                  },
                  {
                    "type": "object",
                    "properties": {
                      "type": {
                        "type": "string",
                        "enum": ["ValidateField"]
                      },
                      "fieldId": {
                        "type": "string"
                      }
                    },
                    "required": ["type", "fieldId"],
                    "additionalProperties": false
                  },
                  {
                    "type": "object",
                    "properties": {
                      "type": {
                        "type": "string",
                        "enum": ["NoAction"]
                      }
                    },
                    "required": ["type"],
                    "additionalProperties": false
                  }
                ]
              }
            },
            "required": ["type", "id"],
            "additionalProperties": false
          }
        }
      },
      "required": ["components"],
      "additionalProperties": false
    }

""".trimIndent()


fun main() {
    validateJson(schemaString, testData)
}

// TODO: Work in progress