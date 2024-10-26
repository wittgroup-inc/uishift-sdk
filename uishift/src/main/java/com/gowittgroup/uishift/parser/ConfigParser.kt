package com.gowittgroup.uishift.parser


import com.gowittgroup.uishift.constants.ActionFlowType
import com.gowittgroup.uishift.constants.ActionType
import com.gowittgroup.uishift.constants.ComponentType
import com.gowittgroup.uishift.constants.RequestType
import com.gowittgroup.uishift.constants.ValidationType
import com.gowittgroup.uishift.models.ScreenConfiguration
import com.gowittgroup.uishift.models.components.*
import com.gowittgroup.uishift.models.properties.Action
import com.gowittgroup.uishift.models.properties.ActionFlow
import com.gowittgroup.uishift.models.properties.Request
import com.gowittgroup.uishift.models.properties.Validation
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

private const val TYPE_LABEL_KEY = "type"

class ConfigParser {
    val moshi = Moshi.Builder()
        .add(SizeOptionAdapter())
        .add(
            PolymorphicJsonAdapterFactory.of(UIComponent::class.java, TYPE_LABEL_KEY)
                .withSubtype(TextComponent::class.java, ComponentType.TEXT)
                .withSubtype(ButtonComponent::class.java, ComponentType.BUTTON)
                .withSubtype(ImageComponent::class.java, ComponentType.IMAGE)
                .withSubtype(ColumnComponent::class.java, ComponentType.COLUMN)
                .withSubtype(RowComponent::class.java, ComponentType.ROW)
                .withSubtype(
                    TextFieldComponent::class.java,
                    ComponentType.TEXT_FIELD
                )
                .withSubtype(CheckBoxComponent::class.java, ComponentType.CHECKBOX)
                .withSubtype(SliderComponent::class.java, ComponentType.SLIDER)
                .withSubtype(
                    RadioButtonComponent::class.java,
                    ComponentType.RADIO_BUTTON
                )
                .withSubtype(SwitchComponent::class.java, ComponentType.SWITCH)
                .withSubtype(DividerComponent::class.java, ComponentType.DIVIDER)
                .withSubtype(SpacerComponent::class.java, ComponentType.SPACER)
                .withDefaultValue(Unknown)
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
                .withSubtype(Validation.None::class.java, ValidationType.NONE)  // Instantiate the data class here
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
