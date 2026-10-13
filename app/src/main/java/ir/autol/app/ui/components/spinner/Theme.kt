package ir.autol.app.ui.components.spinner

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.autol.app.ui.components.Colors

data class Theme(
    val strokeWidth: Dp,
    val spinnerSize: Dp,
    val textSize: TextUnit,
    val trackColor: Color,
    val progressColor: Color,
    val labelColor: Color,
)

internal fun getTheme(size: Size): Theme = Theme(
    strokeWidth = getStrokeWidth(size),
    spinnerSize = getSpinnerSize(size),
    textSize = getTextSize(size),
    trackColor = Colors.Theme.Surface.Surface,
    progressColor = Colors.Theme.Default.Primary,
    labelColor = Colors.Theme.Foreground.Foreground
)

private fun getStrokeWidth(size: Size): Dp = when (size) {
    Size.Large   -> 8.dp
    Size.Default -> 6.dp
    Size.Small   -> 4.dp
    Size.XS      -> 2.dp
}

private fun getTextSize(size: Size): TextUnit = when (size) {
    Size.Large   -> 18.sp
    Size.Default -> 16.sp
    Size.Small   -> 14.sp
    Size.XS      -> 12.sp
}

private fun getSpinnerSize(size: Size): Dp = when (size) {
    Size.Large   -> 64.dp
    Size.Default -> 44.dp
    Size.Small   -> 36.dp
    Size.XS      -> 20.dp
}
