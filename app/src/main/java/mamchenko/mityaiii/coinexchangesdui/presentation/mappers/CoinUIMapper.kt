package mamchenko.mityaiii.coinexchangesdui.presentation.mappers

import android.annotation.SuppressLint
import android.content.Context
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.PARENT_ID
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import mamchenko.mityaiii.coinexchangesdui.infrastructure.uicomponents.Coin

class CoinUIMapper : ViewMapper<Coin> {
    @SuppressLint("SetTextI18n")
    override fun mapToView(context: Context, component: Coin): View {
        val cardView = CardView(context).apply {
            layoutParams = ViewGroup.MarginLayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply {
                bottomMargin = dpToPx(context, 4)
            }
            radius = dpToPx(context, 16).toFloat()
            cardElevation = dpToPx(context, 6).toFloat()
        }

        val constraintLayout = ConstraintLayout(context).apply {
            layoutParams = ConstraintLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            setPadding(
                dpToPx(context, 16),
                dpToPx(context, 16),
                dpToPx(context, 16),
                dpToPx(context, 16)
            )
        }

        cardView.tag = component.searchKey

        val imageView = AppCompatImageView(context).apply {
            id = View.generateViewId()
            layoutParams = ConstraintLayout.LayoutParams(
                dpToPx(context, 48),
                dpToPx(context, 48)
            ).apply {
                startToStart = PARENT_ID
                topToTop = PARENT_ID
                bottomToBottom = PARENT_ID
            }
            contentDescription = "coin icon"
        }
        Glide.with(context)
            .load(component.image.imageUrl)
            .apply(RequestOptions().transform(RoundedCorners(component.image.cornerRadius)))
            .into(imageView)

        val textContainer = LinearLayout(context).apply {
            id = View.generateViewId()
            orientation = LinearLayout.HORIZONTAL
            layoutParams = ConstraintLayout.LayoutParams(
                0,
                ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply {
                startToEnd = imageView.id
                endToEnd = PARENT_ID
                topToTop = PARENT_ID
                bottomToBottom = PARENT_ID
                marginStart = dpToPx(context, 16)
            }
        }

        val nameView = TextView(context).apply {
            id = View.generateViewId()
            text = component.name ?: "Unknown"
            setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f)
            layoutParams = LinearLayout.LayoutParams(
                0,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                1f
            )
        }

        val priceView = TextView(context).apply {
            id = View.generateViewId()
            val pr = component.price
            text = "${pr.value} ${pr.currency}"
            setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f)
            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        }

        textContainer.addView(nameView)
        textContainer.addView(priceView)

        constraintLayout.addView(imageView)
        constraintLayout.addView(textContainer)

        cardView.addView(constraintLayout)

        return cardView
    }

    private fun dpToPx(context: Context, dp: Int): Int =
        (dp * context.resources.displayMetrics.density).toInt()
}