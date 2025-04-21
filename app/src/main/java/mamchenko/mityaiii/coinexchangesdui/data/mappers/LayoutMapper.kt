package mamchenko.mityaiii.coinexchangesdui.data.mappers

import com.google.gson.JsonArray
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonObject
import mamchenko.mityaiii.coinexchangesdui.domain.enums.LayoutAlignment
import mamchenko.mityaiii.coinexchangesdui.infrastructure.uicomponents.Layout
import mamchenko.mityaiii.coinexchangesdui.infrastructure.uicomponents.UIComponent

class LayoutMapper : UIComponentMapper {
    override fun toComponent(jsonValue: JsonObject, context: JsonDeserializationContext): UIComponent {
        val align = LayoutAlignment.fromString(jsonValue.get("align").asString)
        val itemsArray = if (jsonValue.has("items")) {
            jsonValue.getAsJsonArray("items")
        } else {
            JsonArray()
        }

        val items = mutableListOf<UIComponent>()
        for (element in itemsArray) {
            val childComponent: UIComponent = context.deserialize(element, UIComponent::class.java)
            items.add(childComponent)
        }

        return Layout(
            align = align,
            items = items
        )
    }
}