package mamchenko.mityaiii.coinexchangesdui.domain.usecases

import mamchenko.mityaiii.coinexchangesdui.domain.repositories.UIComponentRepository
import mamchenko.mityaiii.coinexchangesdui.domain.usecases.interfaces.GetUIComponentUseCase
import mamchenko.mityaiii.coinexchangesdui.infrastructure.uicomponents.UIComponent

class GetUIComponentUseCaseImpl(
    private val repository: UIComponentRepository
) : GetUIComponentUseCase {
    override suspend fun execute(): UIComponent = repository.getUIComponent()
}