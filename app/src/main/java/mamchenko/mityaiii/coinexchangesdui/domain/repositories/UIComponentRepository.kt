package mamchenko.mityaiii.coinexchangesdui.domain.repositories

import mamchenko.mityaiii.coinexchangesdui.infrastructure.uicomponents.UIComponent

interface UIComponentRepository {
    suspend fun getUIComponent(): UIComponent
}