package mamchenko.mityaiii.coinexchangesdui.domain.usecases.interfaces

import mamchenko.mityaiii.coinexchangesdui.infrastructure.uicomponents.UIComponent

interface GetUIComponentUseCase {
    suspend fun execute(): UIComponent
}