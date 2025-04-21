package mamchenko.mityaiii.coinexchangesdui.domain.enums

enum class LayoutAlignment {
    VERTICAL,
    HORIZONTAL;

    companion object {
        fun fromString(value: String): LayoutAlignment {
            return try {
                valueOf(value.uppercase())
            } catch (e: IllegalArgumentException) {
                VERTICAL
            }
        }
    }
}