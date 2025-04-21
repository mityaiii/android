package mamchenko.mityaiii.coinexchangesdui.infrastructure.uicomponents

import mamchenko.mityaiii.coinexchangesdui.domain.dataobjects.Image
import mamchenko.mityaiii.coinexchangesdui.domain.dataobjects.Money
import mamchenko.mityaiii.coinexchangesdui.infrastructure.uicomponents.interfaces.Searchable

data class Coin(
    val id: Int,
    val name: String,
    val price: Money,
    val image: Image,
) : UIComponent(), Searchable {
    override val searchKey: String
        get() = name
}