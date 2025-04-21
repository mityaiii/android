package mamchenko.mityaiii.coinexchangesdui.data.parsers

import com.google.gson.JsonObject
import mamchenko.mityaiii.coinexchangesdui.data.parsers.interfaces.SizeParser
import mamchenko.mityaiii.coinexchangesdui.infrastructure.valueobjects.Size

class SizeParserImpl : SizeParser {
    override fun parseSize(jsonValue: JsonObject): Size {
        val layoutWidth = if (jsonValue.has("layoutWidth")) {
            jsonValue.get("layoutWidth").asString
        } else {
            "wrap_content"
        }
        val layoutHeight = if (jsonValue.has("layoutHeight")) {
            jsonValue.get("layoutHeight").asString
        } else {
            "wrap_content"
        }

        return Size(
            layoutHeight = layoutHeight,
            layoutWidth = layoutWidth
        )
    }
}