package com.gowittgroup.uishift.parser

import com.gowittgroup.uishift.models.ScreenConfiguration
import com.gowittgroup.uishift.models.Action
import com.gowittgroup.uishift.models.UIComponent
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory

class ConfigParser {
    fun parse(jsonConfigString: String): ScreenConfiguration? {
        val moshi = Moshi.Builder()
            .add(
                PolymorphicJsonAdapterFactory.of(UIComponent::class.java, "type")
                    .withSubtype(UIComponent.TextComponent::class.java, "Text")
                    .withSubtype(UIComponent.ButtonComponent::class.java, "Button")
                    .withSubtype(UIComponent.ImageComponent::class.java, "Image")
                    .withSubtype(UIComponent.ColumnComponent::class.java, "Column")
                    .withSubtype(UIComponent.RowComponent::class.java, "Row")
                    .withSubtype(UIComponent.TextFieldComponent::class.java, "TextField")
                    .withSubtype(UIComponent.CheckBoxComponent::class.java, "Checkbox")
                    .withSubtype(UIComponent.SliderComponent::class.java, "Slider")
                    .withDefaultValue(UIComponent.Unknown)
            )
            .add(
                PolymorphicJsonAdapterFactory.of(Action::class.java, "type")
                    .withSubtype(Action.Navigate::class.java, "Navigate")
                    .withSubtype(Action.SubmitData::class.java, "SubmitData")
                    .withSubtype(Action.ValidateField::class.java, "ValidateField")
                    .withDefaultValue(Action.NoAction)
            )
            .build()
        val jsonAdapter = moshi.adapter(ScreenConfiguration::class.java)

        return jsonAdapter.fromJson(jsonConfigString)
    }
}