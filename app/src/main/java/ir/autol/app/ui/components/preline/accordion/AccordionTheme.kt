package ir.autol.app.ui.components.preline.accordion

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.autol.app.ui.components.preline.Colors

data class AccordionTheme(
    val borderColor: Color,
    val titleColor: Color,
    val expandedTitleColor: Color,
    val shape: Shape,
    val iconSize: Dp,
    val titleFontSize: TextUnit,
) {
    sealed interface Style {
        object Normal : Style
        object Bordered : Style
        object BorderedOpen : Style
    }

    sealed interface Toggle {
        object StartPlus : Toggle
        object StartArrow : Toggle
        object EndArrow : Toggle
        object None : Toggle
    }

    sealed interface Type {
        object Basic : Type
        object AlwaysOpen : Type
    }
}

internal fun getTheme(style: AccordionTheme.Style, isExpanded: Boolean): AccordionTheme = AccordionTheme(
    borderColor = getBorderColor(style),
    titleColor = getTitleColor(isExpanded),
    expandedTitleColor = Colors.Theme.Default.Primary,
    shape = RoundedCornerShape(12.dp),
    iconSize = 16.dp,
    titleFontSize = 14.sp
)

private fun getBorderColor(style: AccordionTheme.Style): Color = when (style) {
    AccordionTheme.Style.Bordered, AccordionTheme.Style.BorderedOpen -> Colors.Theme.Layer.LayerBorder
    else                                                             -> Colors.Transparent
}

private fun getTitleColor(isExpanded: Boolean): Color = if (isExpanded) Colors.Theme.Default.Primary else Colors.Theme.Foreground.Foreground
