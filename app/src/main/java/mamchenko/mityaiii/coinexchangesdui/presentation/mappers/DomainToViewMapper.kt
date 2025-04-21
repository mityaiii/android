package mamchenko.mityaiii.coinexchangesdui.presentation.mappers

import android.content.Context
import android.view.View
import mamchenko.mityaiii.coinexchangesdui.infrastructure.applyMargin
import mamchenko.mityaiii.coinexchangesdui.infrastructure.uicomponents.Coin
import mamchenko.mityaiii.coinexchangesdui.infrastructure.uicomponents.Layout
import mamchenko.mityaiii.coinexchangesdui.infrastructure.uicomponents.Scroll
import mamchenko.mityaiii.coinexchangesdui.infrastructure.uicomponents.SearchField
import mamchenko.mityaiii.coinexchangesdui.infrastructure.uicomponents.Text
import mamchenko.mityaiii.coinexchangesdui.infrastructure.uicomponents.UIComponent

class DomainToViewMapper : ViewMapper<UIComponent> {
    private val coinMapper = CoinUIMapper()
    private val textMapper = TextUIMapper()
    private val layoutMapper = LayoutUIMapper(this)
    private val scrollMapper = ScrollUIMapper(this)
    private val searchMapper = SearchUIMapper(this)

    override fun mapToView(context: Context, component: UIComponent): View {
        val view = when(component) {
            is Layout -> layoutMapper.mapToView(context, component)
            is Coin -> coinMapper.mapToView(context, component)
            is Text -> textMapper.mapToView(context, component)
            is Scroll -> scrollMapper.mapToView(context, component)
            is SearchField -> searchMapper.mapToView(context, component
            )

            else -> throw IllegalStateException("Illegal component")
        }

        view.applyMargin(component)
//        view.applySize(context, component)

        return view
    }
}