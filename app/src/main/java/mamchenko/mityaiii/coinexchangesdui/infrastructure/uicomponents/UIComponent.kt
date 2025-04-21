package mamchenko.mityaiii.coinexchangesdui.infrastructure.uicomponents

import mamchenko.mityaiii.coinexchangesdui.infrastructure.valueobjects.Indentation
import mamchenko.mityaiii.coinexchangesdui.infrastructure.valueobjects.Size

abstract class UIComponent {
    lateinit var size: Size
    lateinit var indentation: Indentation
}