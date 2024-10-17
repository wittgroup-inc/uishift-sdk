package com.gowittgroup.uishift.parser

import com.gowittgroup.uishift.constants.ActionFlowType
import com.gowittgroup.uishift.constants.ActionType
import com.gowittgroup.uishift.constants.ComponentType
import com.gowittgroup.uishift.constants.RequestType
import com.gowittgroup.uishift.constants.ValidationType
import com.gowittgroup.uishift.models.Action
import com.gowittgroup.uishift.models.ActionFlow
import com.gowittgroup.uishift.models.Request
import com.gowittgroup.uishift.models.ScreenConfiguration
import com.gowittgroup.uishift.models.UIComponent
import com.gowittgroup.uishift.models.Validation
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

private const val TYPE_LABEL_KEY = "type"

class ConfigParser {
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
                .withSubtype(Action.ApiRequest::class.java, ActionType.API_REQUEST)
                .withSubtype(Action.ApiRequest::class.java, ActionType.SHOW_ERROR)
                .withSubtype(Action.ApiRequest::class.java, ActionType.SHOW_SUCCESS)
                .withSubtype(Action.Validate::class.java, ActionType.VALIDATE)
        )
        .add(
            PolymorphicJsonAdapterFactory.of(ActionFlow::class.java, TYPE_LABEL_KEY)
                .withSubtype(ActionFlow.Single::class.java, ActionFlowType.SINGLE)
                .withSubtype(ActionFlow.Sequence::class.java, ActionFlowType.SEQUENCE)
        )
        .add(
            PolymorphicJsonAdapterFactory.of(Request::class.java, TYPE_LABEL_KEY)
                .withSubtype(Request.Command::class.java, RequestType.COMMAND)
                .withSubtype(Request.Query::class.java, RequestType.QUERY)
        ).add(
            PolymorphicJsonAdapterFactory.of(Validation::class.java, TYPE_LABEL_KEY)
                .withSubtype(Validation.Base::class.java, ValidationType.BASE)
                .withSubtype(Validation.Selection::class.java, ValidationType.SELECTION)
                .withSubtype(Validation.Text::class.java, ValidationType.TEXT)
                .withSubtype(Validation.Binary::class.java, ValidationType.BOOLEAN)
                .withSubtype(Validation.Numeric::class.java, ValidationType.NUMERIC)
                .withDefaultValue(Validation.None)
        )
        .add(KotlinJsonAdapterFactory())
        .build()

    fun parse(jsonConfigString: String): ScreenConfiguration? {
        val jsonAdapter = moshi.adapter(ScreenConfiguration::class.java)
        return jsonAdapter.fromJson(jsonConfigString)
    }

    fun toJson(config: ScreenConfiguration): String{
        val adapter = moshi.adapter(ScreenConfiguration::class.java)
        return adapter.toJson(config)
    }
}