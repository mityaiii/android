package mamchenko.mityaiii.coinexchangesdui.infrastructure.uicomponents

import mamchenko.mityaiii.coinexchangesdui.domain.enums.LayoutAlignment

data class Layout(
    val align: LayoutAlignment,
    val items: List<UIComponent>
) : UIComponent()
