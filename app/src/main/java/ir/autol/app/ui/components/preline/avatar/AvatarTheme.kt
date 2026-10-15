package ir.autol.app.ui.components.preline.avatar

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.autol.app.ui.components.preline.Colors
import ir.autol.app.ui.components.preline.avatar.AvatarTheme.Color
import ir.autol.app.ui.components.preline.avatar.AvatarTheme.Shape
import ir.autol.app.ui.components.preline.avatar.AvatarTheme.Size
import ir.autol.app.ui.components.preline.avatar.AvatarTheme.Type
import androidx.compose.ui.graphics.Color as ComposeColor
import androidx.compose.ui.graphics.Shape as ComposeShape

data class AvatarTheme(
    val background: ComposeColor,
    val foreground: ComposeColor,
    val stroke: ComposeColor,
    val height: Dp,
    val statusSize: Dp,
    val fontSize: TextUnit,
    val shape: ComposeShape,
) {
    sealed interface Color {
        object Image : Color
        object Placeholder : Color
        object Dark : Color
        object Gray : Color
        object Green : Color
        object Blue : Color
        object Yellow : Color
        object Red : Color
        object Light : Color
        object White : Color
    }

    sealed interface Shape {
        object Rounded : Shape
        object Circular : Shape
    }

    sealed interface Size {
        object XS : Size
        object Small : Size
        object Default : Size
        object Large : Size
    }

    sealed interface Type {
        object Image : Type
        object Solid : Type
        object Soft : Type
        object White : Type
        object Outline : Type
    }
}

internal fun getTheme(type: Type, color: Color, size: Size, shape: Shape): AvatarTheme = AvatarTheme(
    background = getBackgroundColor(type, color),
    foreground = getForegroundColor(type, color),
    stroke = getStrokeColor(type, color),
    height = getHeight(size),
    statusSize = getStatusSize(size),
    fontSize = getFontSize(size),
    shape = getShape(shape)
)

private fun getBackgroundColor(type: Type, color: Color): ComposeColor {
    return when (type) {
        Type.Image   -> when (color) {
            Color.Image       -> Colors.Theme.Surface.Surface4
            Color.Placeholder -> Colors.Theme.Surface.Surface4
            else              -> Colors.Transparent
        }

        Type.Solid   -> when (color) {
            Color.Image       -> Colors.Theme.Surface.Surface4
            Color.Placeholder -> Colors.Theme.Surface.Surface4
            Color.Dark        -> Colors.Theme.Secondary.Secondary
            Color.Gray        -> Colors.Theme.Surface.Surface4
            Color.Green       -> Colors.Teal.Teal500
            Color.Blue        -> Colors.Theme.Default.Primary
            Color.Yellow      -> Colors.Yellow.Yellow500
            Color.Red         -> Colors.Red.Red500
            Color.Light       -> Colors.Theme.Background.BackgroundPlain
            Color.White       -> Colors.Transparent
        }

        Type.Soft    -> when (color) {
            Color.Image       -> Colors.Theme.Surface.Surface4
            Color.Placeholder -> Colors.Theme.Surface.Surface4
            Color.Dark        -> Colors.Theme.Surface.Surface
            Color.Gray        -> Colors.Theme.Muted.Muted
            Color.Green       -> Colors.Theme.Accent.Green.Green3
            Color.Blue        -> Colors.Theme.Accent.Primary.Primary3
            Color.Yellow      -> Colors.Theme.Accent.Yellow.Yellow3
            Color.Red         -> Colors.Theme.Accent.Red.Red3
            Color.Light       -> Colors.White.White10
            Color.White       -> Colors.Transparent
        }

        Type.White   -> Colors.Theme.Layer.Layer
        Type.Outline -> when (color) {
            Color.Image       -> Colors.Theme.Surface.Surface4
            Color.Placeholder -> Colors.Theme.Surface.Surface4
            else              -> Colors.Transparent
        }
    }
}

private fun getForegroundColor(type: Type, color: Color): ComposeColor {
    return when (type) {
        Type.Image   -> when (color) {
            Color.Image       -> Colors.Theme.Foreground.ForegroundInverse
            Color.Placeholder -> Colors.Theme.Foreground.ForegroundInverse
            else              -> Colors.Transparent
        }

        Type.Solid   -> when (color) {
            Color.Image       -> Colors.Theme.Foreground.ForegroundInverse
            Color.Placeholder -> Colors.Theme.Foreground.ForegroundInverse
            Color.Dark        -> Colors.Theme.Secondary.SecondaryForeground
            Color.Gray        -> Colors.Theme.Foreground.ForegroundInverse
            Color.Green       -> Colors.Theme.Foreground.ForegroundInverse
            Color.Blue        -> Colors.Theme.Default.PrimaryForeground
            Color.Yellow      -> Colors.Theme.Foreground.ForegroundInverse
            Color.Red         -> Colors.Theme.Foreground.ForegroundInverse
            Color.Light       -> Colors.Theme.Foreground.ForegroundInverse
            Color.White       -> Colors.Transparent
        }

        Type.Soft    -> when (color) {
            Color.Image       -> Colors.Theme.Foreground.ForegroundInverse
            Color.Placeholder -> Colors.Theme.Foreground.ForegroundInverse
            Color.Dark        -> Colors.Theme.Surface.SurfaceForeground
            Color.Gray        -> Colors.Theme.Muted.MutedForeground1
            Color.Green       -> Colors.Theme.Accent.Green.Green7
            Color.Blue        -> Colors.Theme.Accent.Primary.Primary7
            Color.Yellow      -> Colors.Theme.Accent.Yellow.Yellow7
            Color.Red         -> Colors.Theme.Accent.Red.Red7
            Color.Light       -> Colors.Theme.Foreground.ForegroundInverse
            Color.White       -> Colors.Transparent
        }

        Type.White   -> Colors.Theme.Layer.LayerForeground
        Type.Outline -> when (color) {
            Color.Image       -> Colors.Theme.Foreground.ForegroundInverse
            Color.Placeholder -> Colors.Theme.Foreground.ForegroundInverse
            Color.Dark        -> Colors.Theme.Foreground.Foreground
            Color.Gray        -> Colors.Theme.Muted.MutedForeground1
            Color.Green       -> Colors.Teal.Teal500
            Color.Blue        -> Colors.Theme.Default.Primary
            Color.Yellow      -> Colors.Yellow.Yellow500
            Color.Red         -> Colors.Red.Red500
            Color.Light       -> Colors.Theme.Foreground.ForegroundInverse
            Color.White       -> Colors.Transparent
        }
    }
}

private fun getStrokeColor(type: Type, color: Color): ComposeColor {
    return when (type) {
        Type.Outline -> getForegroundColor(type, color)
        else         -> Colors.Transparent
    }
}

private fun getStatusSize(size: Size): Dp = when (size) {
    Size.XS      -> 8.dp
    Size.Small   -> 12.dp
    Size.Default -> 14.dp
    Size.Large   -> 16.dp
}

private fun getFontSize(size: Size): TextUnit = when (size) {
    Size.XS      -> 12.sp
    Size.Small   -> 14.sp
    Size.Default -> 16.sp
    Size.Large   -> 20.sp
}

private fun getHeight(size: Size): Dp = when (size) {
    Size.XS      -> 24.dp
    Size.Small   -> 36.dp
    Size.Default -> 44.dp
    Size.Large   -> 60.dp
}

private fun getShape(shape: Shape): ComposeShape = when (shape) {
    Shape.Rounded  -> RoundedCornerShape(8.dp)
    Shape.Circular -> CircleShape
}
