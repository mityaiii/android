package mamchenko.mityaiii.coinexchangesdui.infrastructure.uicomponents

data class Scroll(
    val child: UIComponent,
    val scrollDirection: String? = "vertical",
    val layoutWidth: String = "match_parent",
    val layoutHeight: String = "match_parent"
) : UIComponent()
