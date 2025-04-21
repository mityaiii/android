package mamchenko.mityaiii.coinexchangesdui.data.parsers

import com.google.gson.JsonObject
import mamchenko.mityaiii.coinexchangesdui.data.parsers.interfaces.IndentationParser
import mamchenko.mityaiii.coinexchangesdui.infrastructure.valueobjects.Indentation

class IndentationParserImpl : IndentationParser {
    override fun parse(jsonValue: JsonObject): Indentation {
        val marginLeft = if (jsonValue.has("marginLeft")) {
            jsonValue.get("marginLeft").asInt
        } else {
            0
        }
        val marginTop = if (jsonValue.has("marginTop")) {
            jsonValue.get("marginTop").asInt
        } else {
            0
        }
        val marginRight = if (jsonValue.has("marginRight")) {
            jsonValue.get("marginRight").asInt
        } else {
            0
        }
        val marginBottom = if (jsonValue.has("marginBottom")) {
            jsonValue.get("marginBottom").asInt
        } else {
            0
        }

        return Indentation(
            marginLeft = marginLeft,
            marginBottom = marginBottom,
            marginTop = marginTop,
            marginRight = marginRight
        )
    }
}