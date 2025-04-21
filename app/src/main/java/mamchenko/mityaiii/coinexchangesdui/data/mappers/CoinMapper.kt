package mamchenko.mityaiii.coinexchangesdui.data.mappers

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonObject
import mamchenko.mityaiii.coinexchangesdui.domain.dataobjects.Image
import mamchenko.mityaiii.coinexchangesdui.domain.dataobjects.Money
import mamchenko.mityaiii.coinexchangesdui.infrastructure.uicomponents.Coin
import mamchenko.mityaiii.coinexchangesdui.infrastructure.uicomponents.UIComponent

class CoinMapper: UIComponentMapper {
    override fun toComponent(jsonValue: JsonObject, context: JsonDeserializationContext): UIComponent {
        val id = jsonValue.get("id").asInt
        val name = jsonValue.get("name").asString

        val priceObject = jsonValue.get("price").asJsonObject
        val price = run {
            val priceValue = priceObject.get("value").asBigDecimal
            val currency = priceObject.get("currency").asString

            Money(priceValue, currency)
        }

        val imageObject = jsonValue.get("image").asJsonObject
        val image = run {
            val imageUrl = imageObject.get("imageUrl").asString
            val width = imageObject.get("width").asInt
            val height = imageObject.get("height").asInt
            val cornerRadius = imageObject.get("cornerRadius").asInt

            Image(imageUrl, width, height, cornerRadius)
        }

        return Coin(
            id = id,
            name = name,
            price = price,
            image = image
        )
    }
}