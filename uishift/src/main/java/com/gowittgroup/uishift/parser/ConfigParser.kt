package com.gowittgroup.uishift.parser

import com.gowittgroup.uishift.constants.ActionType
import com.gowittgroup.uishift.constants.ComponentType
import com.gowittgroup.uishift.models.ScreenConfiguration
import com.gowittgroup.uishift.models.Action
import com.gowittgroup.uishift.models.UIComponent
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

private const val TYPE_LABEL_KEY = "type"

class ConfigParser {
    fun parse(jsonConfigString: String): ScreenConfiguration? {
        val moshi = Moshi.Builder()
            .add(
                PolymorphicJsonAdapterFactory.of(UIComponent::class.java, TYPE_LABEL_KEY)
                    .withSubtype(UIComponent.TextComponent::class.java, ComponentType.TEXT)
                    .withSubtype(UIComponent.ButtonComponent::class.java, ComponentType.BUTTON)
                    .withSubtype(UIComponent.ImageComponent::class.java, ComponentType.IMAGE)
                    .withSubtype(UIComponent.ColumnComponent::class.java, ComponentType.COLUMN)
                    .withSubtype(UIComponent.RowComponent::class.java, ComponentType.ROW)
                    .withSubtype(
                        UIComponent.TextFieldComponent::class.java,
                        ComponentType.TEXT_FIELD
                    )
                    .withSubtype(UIComponent.CheckBoxComponent::class.java, ComponentType.CHECKBOX)
                    .withSubtype(UIComponent.SliderComponent::class.java, ComponentType.SLIDER)
                    .withSubtype(
                        UIComponent.RadioButtonComponent::class.java,
                        ComponentType.RADIO_BUTTON
                    )
                    .withSubtype(UIComponent.SwitchComponent::class.java, ComponentType.SWITCH)
                    .withSubtype(UIComponent.DividerComponent::class.java, ComponentType.DIVIDER)
                    .withSubtype(UIComponent.SpacerComponent::class.java, ComponentType.SPACER)
                    .withDefaultValue(UIComponent.Unknown)
            )
            .add(
                PolymorphicJsonAdapterFactory.of(Action::class.java, TYPE_LABEL_KEY)
                    .withSubtype(Action.Navigate::class.java, ActionType.NAVIGATE)
                    .withSubtype(Action.SubmitData::class.java, ActionType.SUBMIT_DATA)
                    .withSubtype(Action.ValidateField::class.java, ActionType.VALIDATE_FIELD)
                    .withDefaultValue(Action.NoAction)
            )
            .add(KotlinJsonAdapterFactory())
            .build()

        val jsonAdapter = moshi.adapter(ScreenConfiguration::class.java)

        return jsonAdapter.fromJson(jsonConfigString)
    }
}