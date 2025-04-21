package mamchenko.mityaiii.coinexchangesdui.infrastructure

import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import mamchenko.mityaiii.coinexchangesdui.infrastructure.uicomponents.UIComponent

fun View.applySize(component: UIComponent) {
    val params = this.layoutParams
    val width = when (component.size.layoutWidth) {
        "match_parent" -> ViewGroup.LayoutParams.MATCH_PARENT
        "wrap_content" -> ViewGroup.LayoutParams.WRAP_CONTENT
        else -> component.size.layoutHeight.toInt()
    }

    val height = when (component.size.layoutHeight) {
        "match_parent" -> ViewGroup.LayoutParams.MATCH_PARENT
        "wrap_content" -> ViewGroup.LayoutParams.WRAP_CONTENT
        else -> component.size.layoutHeight.toInt()
    }

    if (params is LinearLayout.LayoutParams) {
        params.width = width
        params.height = height
        this.layoutParams = params
    } else {
        val newParams = LinearLayout.LayoutParams(width, height)
        if (params is ViewGroup.MarginLayoutParams) {
            newParams.setMargins(
                params.leftMargin,
                params.topMargin,
                params.rightMargin,
                params.bottomMargin
            )
        }
        this.layoutParams = newParams
    }
}

fun View.applyMargin(component: UIComponent) {
    val leftMargin = component.indentation.marginLeft
    val topMargin = component.indentation.marginTop
    val rightMargin = component.indentation.marginRight
    val bottomMargin = component.indentation.marginBottom

    val params = this.layoutParams as? LinearLayout.LayoutParams ?:
    LinearLayout.LayoutParams(
        ViewGroup.LayoutParams.MATCH_PARENT,
        ViewGroup.LayoutParams.WRAP_CONTENT
    )

    params.setMargins(leftMargin, topMargin, rightMargin, bottomMargin)
    this.layoutParams = params
}

