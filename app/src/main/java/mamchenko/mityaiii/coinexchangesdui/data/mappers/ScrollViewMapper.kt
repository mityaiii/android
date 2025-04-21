package mamchenko.mityaiii.coinexchangesdui.data.mappers

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonObject
import mamchenko.mityaiii.coinexchangesdui.infrastructure.uicomponents.Scroll
import mamchenko.mityaiii.coinexchangesdui.infrastructure.uicomponents.UIComponent

class ScrollViewMapper : UIComponentMapper {
    override fun toComponent(
        jsonValue: JsonObject,
        context: JsonDeserializationContext
    ): UIComponent {
        val layoutWidth = if (jsonValue.has("layout_width")) jsonValue.get("layout_width").asString else "match_parent"
        val layoutHeight = if (jsonValue.has("layout_height")) jsonValue.get("layout_height").asString else "match_parent"
        val scrollDirection = if (jsonValue.has("scrollDirection") && !jsonValue.get("scrollDirection").isJsonNull) jsonValue.get("scrollDirection").asString else "vertical"

        val childElement = jsonValue.get("child")
        val childComponent: UIComponent = context.deserialize(childElement, UIComponent::class.java)

        return Scroll(
            child = childComponent,
            layoutWidth = layoutWidth,
            layoutHeight = layoutHeight,
            scrollDirection = scrollDirection
        )
    }
}