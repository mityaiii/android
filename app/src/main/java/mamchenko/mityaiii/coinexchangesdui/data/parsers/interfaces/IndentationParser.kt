package mamchenko.mityaiii.coinexchangesdui.data.parsers.interfaces

import com.google.gson.JsonObject
import mamchenko.mityaiii.coinexchangesdui.infrastructure.valueobjects.Indentation

interface IndentationParser {
    fun parse(jsonValue: JsonObject): Indentation
}