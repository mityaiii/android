package mamchenko.mityaiii.coinexchangesdui.domain.dataobjects

import java.math.BigDecimal

data class Money (
    val value: BigDecimal,
    val currency: String
)