package mamchenko.mityaiii.coinexchangesdui.data.mappers

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonObject
import mamchenko.mityaiii.coinexchangesdui.infrastructure.uicomponents.Text
import mamchenko.mityaiii.coinexchangesdui.infrastructure.uicomponents.UIComponent

class TextMapper : UIComponentMapper {
    override fun toComponent(jsonValue: JsonObject, context: JsonDeserializationContext): UIComponent {
        val text = jsonValue.get("text").asString
        val fontSize = jsonValue.get("fontSize").asFloat
        val color = if (jsonValue.has("color")) {
            jsonValue.get("color").asString
        } else {
            "#000000"
        }

        val textAlignment = if (jsonValue.has("textAlignment")) {
            jsonValue.get("textAlignment").asString
        } else {
            "left"
        }

        return Text(
            text = text,
            fontSize = fontSize,
            color = color,
            textAlignment = textAlignment
        )
    }
}