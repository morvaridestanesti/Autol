package ir.aotol.app.ui.components.preline.card

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.aotol.app.ui.components.preline.Colors

data class CardTheme(
    val cardBackground: Color,
    val cardBorder: Color,
    val headerTitleColor: Color,
    val titleColor: Color,
    val subtitleColor: Color,
    val contentColor: Color,
    val footerBackground: Color,
    val footerTextColor: Color,
    val shape: Shape,
    val headerTitleFontSize: TextUnit,
    val titleFontSize: TextUnit,
    val subtitleFontSize: TextUnit,
    val contentFontSize: TextUnit,
    val footerFontSize: TextUnit,
    val padding: Dp,
) {
    sealed interface Style {
        object Default : Style
        object Simple : Style
    }

}

internal fun getTheme(): CardTheme = CardTheme(
    cardBackground = Colors.Theme.Card.Card,
    cardBorder = Colors.Theme.Card.CardBorder,
    headerTitleColor = Colors.Theme.Foreground.Foreground,
    titleColor = Colors.Theme.Layer.LayerForeground,
    subtitleColor = Colors.Theme.Muted.MutedForeground1,
    contentColor = Colors.Theme.Muted.MutedForeground1,
    footerBackground = Colors.Theme.Muted.Muted,
    footerTextColor = Colors.Theme.Muted.MutedForeground,
    shape = RoundedCornerShape(12.dp),
    headerTitleFontSize = 18.sp,
    titleFontSize = 18.sp,
    subtitleFontSize = 14.sp,
    contentFontSize = 16.sp,
    footerFontSize = 14.sp,
    padding = 24.dp
)
