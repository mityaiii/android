package mamchenko.mityaiii.coinexchangesdui.infrastructure.uicomponents

data class SearchField (
    val hint: String,
    val filterField: String,
    val child: UIComponent,
    val layoutWidth: String = "match_parent",
    val layoutHeight: String = "match_parent"
) : UIComponent()