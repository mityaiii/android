package mamchenko.mityaiii.coinexchangesdui.data.factories

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import mamchenko.mityaiii.coinexchangesdui.data.mappers.CoinMapper
import mamchenko.mityaiii.coinexchangesdui.data.mappers.LayoutMapper
import mamchenko.mityaiii.coinexchangesdui.data.mappers.ScrollViewMapper
import mamchenko.mityaiii.coinexchangesdui.data.mappers.SearchFieldMapper
import mamchenko.mityaiii.coinexchangesdui.data.mappers.TextMapper
import mamchenko.mityaiii.coinexchangesdui.data.parsers.IndentationParserImpl
import mamchenko.mityaiii.coinexchangesdui.data.parsers.SizeParserImpl
import mamchenko.mityaiii.coinexchangesdui.data.parsers.interfaces.IndentationParser
import mamchenko.mityaiii.coinexchangesdui.data.parsers.interfaces.SizeParser
import mamchenko.mityaiii.coinexchangesdui.infrastructure.uicomponents.UIComponent
import java.lang.reflect.Type

class UIComponentMapperFactory : JsonDeserializer<UIComponent> {
    private val layoutMapper: LayoutMapper = LayoutMapper()
    private val textMapper: TextMapper = TextMapper()
    private val coinMapper: CoinMapper = CoinMapper()
    private val scrollViewMapper: ScrollViewMapper = ScrollViewMapper()
    private val searchFieldMapper: SearchFieldMapper = SearchFieldMapper()

    private val sizeParser: SizeParser = SizeParserImpl()
    private val indentationParser: IndentationParser = IndentationParserImpl()

    override fun deserialize(
        json: JsonElement,
        typeOfT: Type?,
        context: JsonDeserializationContext
    ): UIComponent {
        val jsonObj = json.asJsonObject
        val type = jsonObj.get("type").asString
        val value = jsonObj.getAsJsonObject("value").asJsonObject

        val component: UIComponent = when (type) {
            "layout" -> layoutMapper.toComponent(value, context)
            "text" -> textMapper.toComponent(value, context)
            "coin" -> coinMapper.toComponent(value, context)
            "scrollView" -> scrollViewMapper.toComponent(value, context)
            "searchField" -> searchFieldMapper.toComponent(value, context)
            else -> throw IllegalArgumentException("Invalid type $type")
        }

        component.size = sizeParser.parseSize(value)
        component.indentation = indentationParser.parse(value)

        return component
    }
}