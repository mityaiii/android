package mamchenko.mityaiii.coinexchangesdui.presentation.mappers

import android.content.Context
import android.view.View
import android.widget.LinearLayout
import android.widget.SearchView
import mamchenko.mityaiii.coinexchangesdui.infrastructure.uicomponents.SearchField

class SearchUIMapper(
    private val domainToViewMapper: DomainToViewMapper
) : ViewMapper<SearchField> {
    override fun mapToView(context: Context, component: SearchField): View {
        val childView = domainToViewMapper.mapToView(context, component.child)
        if (childView !is LinearLayout) {
            throw IllegalArgumentException("Child is not LinearLayout")
        }

        val searchView = SearchView(context).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )

            queryHint = component.hint
        }

        childView.addView(searchView, 0)

        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (component.filterField.isBlank()) {
                    return true
                }

                for(i in 1 until childView.childCount) {
                    val view = childView.getChildAt(i)

                    val filterValue = view.tag as? String
                    view.visibility = if (newText.isNullOrBlank() ||
                        (filterValue != null && filterValue.contains(newText, ignoreCase = true))
                    ) {
                        View.VISIBLE
                    } else {
                        View.GONE
                    }
                }

                return true
            }
        })
        return childView
    }
}