package mamchenko.mityaiii.coinexchangesdui.presentation.mappers

import android.content.Context
import android.view.View
import mamchenko.mityaiii.coinexchangesdui.infrastructure.uicomponents.UIComponent

interface ViewMapper<T : UIComponent> {
    fun mapToView(context: Context, component: T): View
}