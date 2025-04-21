package mamchenko.mityaiii.coinexchangesdui.domain.entities

import mamchenko.mityaiii.coinexchangesdui.domain.dataobjects.Image
import mamchenko.mityaiii.coinexchangesdui.domain.dataobjects.Money

class CoinEntityV1 (
    val id: String,
    val name: String,
    val price: Money,
    val image: Image
)