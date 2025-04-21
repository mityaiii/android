package mamchenko.mityaiii.coinexchangesdui.data.mappers

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonObject
import mamchenko.mityaiii.coinexchangesdui.infrastructure.uicomponents.UIComponent

interface UIComponentMapper {
    fun toComponent(jsonValue: JsonObject, context: JsonDeserializationContext): UIComponent
}