package mamchenko.mityaiii.coinexchangesdui.data.mappers

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonObject
import mamchenko.mityaiii.coinexchangesdui.infrastructure.uicomponents.SearchField
import mamchenko.mityaiii.coinexchangesdui.infrastructure.uicomponents.UIComponent

class SearchFieldMapper : UIComponentMapper {
    override fun toComponent(
        jsonValue: JsonObject,
        context: JsonDeserializationContext
    ): UIComponent {
        val hint = if(jsonValue.has("hint")) {
            jsonValue.get("hint").asString
        } else {
            "Search..."
        }

        val filterField = if (jsonValue.has("filterField")) {
            jsonValue.get("filterField").asString
        } else {
            ""
        }

        val childElement = jsonValue.get("child")
        val childComponent: UIComponent = context.deserialize(childElement, UIComponent::class.java)

        val layoutWidth = if (jsonValue.has("layoutWidth")) {
            jsonValue.get("layoutWidth").asString
        } else {
            "match_parent"
        }

        val layoutHeight = if (jsonValue.has("layoutHeight")) {
            jsonValue.get("layoutHeight").asString
        } else {
            "match_parent"
        }

        return SearchField(
            hint = hint,
            child = childComponent,
            filterField = filterField,
            layoutWidth = layoutWidth,
            layoutHeight = layoutHeight
        )
    }
}