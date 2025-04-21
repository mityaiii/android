package mamchenko.mityaiii.coinexchangesdui.presentation.mappers

import android.content.Context
import android.view.Gravity
import android.view.View
import android.widget.TextView
import mamchenko.mityaiii.coinexchangesdui.infrastructure.uicomponents.Text


class TextUIMapper : ViewMapper<Text> {
    override fun mapToView(context: Context, component: Text): View {
        val textView = TextView(context).apply {
            text = component.text
            textSize = component.fontSize
            gravity = when (component.textAlignment.lowercase()) {
                "center" -> Gravity.CENTER
                "right" -> Gravity.END
                else -> Gravity.START
            }
        }

        return textView
    }
}