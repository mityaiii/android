package mamchenko.mityaiii.coinexchangesdui.data.parsers.interfaces

import com.google.gson.JsonObject
import mamchenko.mityaiii.coinexchangesdui.infrastructure.valueobjects.Size

interface SizeParser {
    fun parseSize(jsonValue: JsonObject): Size
}