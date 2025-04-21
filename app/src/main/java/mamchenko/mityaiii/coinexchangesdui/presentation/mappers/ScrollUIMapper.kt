package mamchenko.mityaiii.coinexchangesdui.presentation.mappers

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.HorizontalScrollView
import android.widget.LinearLayout
import android.widget.ScrollView
import mamchenko.mityaiii.coinexchangesdui.infrastructure.uicomponents.Scroll

class ScrollUIMapper(
    private val domainToViewMapper: DomainToViewMapper
) : ViewMapper<Scroll> {
    override fun mapToView(context: Context, component: Scroll): View {
        val defaultParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

        val scrollView: View = if (component.scrollDirection?.equals("horizontal", ignoreCase = true) == true) {
            HorizontalScrollView(context).apply {
                this.layoutParams = defaultParams
            }
        } else {
            ScrollView(context).apply {
                this.layoutParams = defaultParams
            }
        }

        val childView: View = domainToViewMapper.mapToView(context, component.child)

        when (scrollView) {
            is ScrollView -> {
                scrollView.addView(childView)
            }
            is HorizontalScrollView -> {
                scrollView.addView(childView)
            }
            else -> {
                (scrollView as ViewGroup).addView(childView)
            }
        }

        return scrollView
    }
}