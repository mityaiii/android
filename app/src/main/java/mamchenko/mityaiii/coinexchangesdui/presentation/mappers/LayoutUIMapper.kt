package mamchenko.mityaiii.coinexchangesdui.presentation.mappers

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import mamchenko.mityaiii.coinexchangesdui.domain.enums.LayoutAlignment
import mamchenko.mityaiii.coinexchangesdui.infrastructure.uicomponents.Layout

class LayoutUIMapper(
    private val domainToViewMapper: DomainToViewMapper
) : ViewMapper<Layout> {
    override fun mapToView(context: Context, component: Layout): View {
        val linearLayout = LinearLayout(context).apply {
            orientation = if (component.align == LayoutAlignment.VERTICAL) {
                LinearLayout.VERTICAL
            } else {
                LinearLayout.HORIZONTAL
            }
            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        }

        component.items.forEach { child ->
            val childView = domainToViewMapper.mapToView(context, child)
            linearLayout.addView(childView)
        }

        return linearLayout
    }
}