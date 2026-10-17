package ir.aotol.app.ui.components.preline.styled_icon

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ir.aotol.app.ui.components.preline.Colors
import ir.aotol.app.ui.components.preline.styled_icon.StyledIconTheme.Color as Color
import ir.aotol.app.ui.components.preline.styled_icon.StyledIconTheme.Shape as Shape
import ir.aotol.app.ui.components.preline.styled_icon.StyledIconTheme.Size as Size
import ir.aotol.app.ui.components.preline.styled_icon.StyledIconTheme.Type as Type
import androidx.compose.ui.graphics.Color as ComposeColor
import androidx.compose.ui.graphics.Shape as ComposeShape

data class StyledIconTheme(
    val containerColor: ComposeColor,
    val contentColor: ComposeColor,
    val foregroundColor: ComposeColor,
    val strokeColor: ComposeColor,
    val strokeWidth: Dp,
    val height: Dp,
    val containerPadding: Dp,
    val contentPadding: Dp,
    val shape: ComposeShape,
){
    sealed interface Color {
        object Dark : Color
        object Gray : Color
        object Green : Color
        object Blue : Color
        object Red : Color
        object Yellow : Color
        object Light : Color
        object White : Color
    }
    sealed interface Shape {
        object Rounded : Shape
        object Circular : Shape
    }
    sealed interface Size {
        object Large : Size
        object Default : Size
        object Small : Size
        object XS : Size
    }
    sealed interface Type {
        object Base : Type
        object Solid : Type
        object Soft : Type
        object SoftOutlined : Type
        object Outlined : Type
        object White : Type
    }
}

internal fun getTheme(type: StyledIconTheme.Type, color: StyledIconTheme.Color, size: StyledIconTheme.Size, shape: StyledIconTheme.Shape): StyledIconTheme = StyledIconTheme(
    containerColor = getContainerColor(type, color),
    contentColor = getContentColor(type, color),
    foregroundColor = getForegroundCol(type, color),
    strokeColor = getStrokeCol(type, color),
    strokeWidth = if (type == StyledIconTheme.Type.SoftOutlined) 7.dp else 1.dp,
    height = getHeight(size),
    containerPadding = getContainerPadding(size),
    contentPadding = getContentPadding(size),
    shape = getShape(shape, size)
)

private fun getContainerColor(type: Type, color: Color): ComposeColor {
    return when (type) {
        Type.Base         -> when (color) {
            Color.White -> Colors.Theme.Layer.Layer
            else        -> Colors.Transparent
        }

        Type.Solid        -> when (color) {
            Color.Dark -> Colors.Theme.Secondary.Secondary
            Color.Gray                 -> Colors.Theme.Surface.Surface4
            Color.Green  -> Colors.Teal.Teal500
            Color.Blue   -> Colors.Theme.Default.Primary
            Color.Red    -> Colors.Red.Red500
            Color.Yellow -> Colors.Yellow.Yellow500
            Color.Light  -> Colors.Theme.Background.BackgroundPlain
            Color.White  -> Colors.Theme.Layer.Layer
        }

        Type.Soft         -> when (color) {
            Color.Dark   -> Colors.Theme.Surface.Surface
            Color.Gray   -> Colors.Theme.Muted.Muted
            Color.Green  -> Colors.Theme.Accent.Green.Green3
            Color.Blue   -> Colors.Theme.Accent.Primary.Primary3
            Color.Red    -> Colors.Theme.Accent.Red.Red3
            Color.Yellow -> Colors.Theme.Accent.Yellow.Yellow3
            Color.Light  -> Colors.White.White10
            Color.White  -> Colors.Theme.Layer.Layer
        }

        Type.SoftOutlined -> when (color) {
            Color.Dark   -> Colors.Theme.Surface.Surface2
            Color.Gray   -> Colors.Theme.Surface.Surface2
            Color.Green  -> Colors.Theme.Accent.Green.Green2
            Color.Blue   -> Colors.Theme.Accent.Primary.Primary2
            Color.Red    -> Colors.Theme.Accent.Red.Red2
            Color.Yellow -> Colors.Theme.Accent.Yellow.Yellow2
            Color.Light  -> Colors.White.White10
            Color.White  -> Colors.Theme.Layer.Layer
        }

        Type.Outlined     -> when (color) {
            Color.White -> Colors.Theme.Layer.Layer
            else        -> Colors.Transparent
        }

        Type.White        -> Colors.Theme.Layer.Layer
    }
}

private fun getContentColor(type: Type, color: Color): ComposeColor {
    return when (type) {
        Type.Base         -> when (color) {
            Color.White -> Colors.Theme.Layer.Layer
            else        -> Colors.Transparent
        }

        Type.Solid        -> when (color) {
            Color.Dark   -> Colors.Theme.Secondary.Secondary
            Color.Gray   -> Colors.Theme.Surface.Surface4
            Color.Green  -> Colors.Teal.Teal500
            Color.Blue   -> Colors.Theme.Default.Primary
            Color.Red    -> Colors.Red.Red500
            Color.Yellow -> Colors.Yellow.Yellow500
            Color.Light  -> Colors.Theme.Background.BackgroundPlain
            Color.White  -> Colors.Theme.Layer.Layer
        }

        Type.Soft         -> when (color) {
            Color.Dark   -> Colors.Theme.Surface.Surface
            Color.Gray   -> Colors.Theme.Muted.Muted
            Color.Green  -> Colors.Theme.Accent.Green.Green3
            Color.Blue   -> Colors.Theme.Accent.Primary.Primary3
            Color.Red    -> Colors.Theme.Accent.Red.Red3
            Color.Yellow -> Colors.Theme.Accent.Yellow.Yellow3
            Color.Light  -> Colors.White.White10
            Color.White  -> Colors.Theme.Layer.Layer
        }

        Type.SoftOutlined -> when (color) {
            Color.Dark   -> Colors.Theme.Surface.Surface1
            Color.Gray   -> Colors.Theme.Surface.Surface
            Color.Green  -> Colors.Theme.Accent.Green.Green4
            Color.Blue   -> Colors.Theme.Accent.Primary.Primary4
            Color.Red    -> Colors.Theme.Accent.Red.Red4
            Color.Yellow -> Colors.Theme.Accent.Yellow.Yellow4
            Color.Light  -> Colors.Transparent
            Color.White  -> Colors.Theme.Layer.Layer
        }

        Type.Outlined     -> when (color) {
            Color.White -> Colors.Theme.Layer.Layer
            else        -> Colors.Transparent
        }

        Type.White        -> Colors.Theme.Layer.Layer
    }
}

private fun getForegroundCol(type: Type, color: Color): ComposeColor {
    return when (type) {
        Type.Base         -> when (color) {
            Color.Dark   -> Colors.Transparent
            Color.Gray   -> Colors.Theme.Muted.MutedForeground1
            Color.Green  -> Colors.Teal.Teal500
            Color.Blue   -> Colors.Theme.Default.Primary
            Color.Red    -> Colors.Red.Red500
            Color.Yellow -> Colors.Yellow.Yellow500
            Color.Light  -> Colors.Theme.Foreground.ForegroundInverse
            Color.White  -> Colors.Theme.Layer.LayerForeground
        }

        Type.Solid        -> when (color) {
            Color.Dark   -> Colors.Theme.Secondary.SecondaryForeground
            Color.Gray   -> Colors.Theme.Foreground.ForegroundInverse
            Color.Green  -> Colors.Theme.Foreground.ForegroundInverse
            Color.Blue   -> Colors.Theme.Default.PrimaryForeground
            Color.Red    -> Colors.Theme.Foreground.ForegroundInverse
            Color.Yellow -> Colors.Theme.Foreground.ForegroundInverse
            Color.Light  -> Colors.Theme.Foreground.Inverse
            Color.White  -> Colors.Theme.Layer.LayerForeground
        }

        Type.Soft         -> when (color) {
            Color.Dark   -> Colors.Theme.Surface.SurfaceForeground
            Color.Gray   -> Colors.Theme.Foreground.Foreground
            Color.Green  -> Colors.Theme.Accent.Green.Green7
            Color.Blue   -> Colors.Theme.Accent.Primary.Primary7
            Color.Red    -> Colors.Theme.Accent.Red.Red7
            Color.Yellow -> Colors.Theme.Accent.Yellow.Yellow7
            Color.Light  -> Colors.Theme.Foreground.ForegroundInverse
            Color.White  -> Colors.Theme.Layer.LayerForeground
        }

        Type.SoftOutlined -> when (color) {
            Color.Dark   -> Colors.Theme.Surface.SurfaceForeground
            Color.Gray   -> Colors.Theme.Muted.MutedForeground1
            Color.Green  -> Colors.Theme.Accent.Green.Green7
            Color.Blue   -> Colors.Theme.Accent.Primary.Primary7
            Color.Red    -> Colors.Theme.Accent.Red.Red7
            Color.Yellow -> Colors.Theme.Accent.Yellow.Yellow7
            Color.Light  -> Colors.Theme.Foreground.ForegroundInverse
            Color.White  -> Colors.Theme.Layer.LayerForeground
        }

        Type.Outlined     -> when (color) {
            Color.Dark   -> Colors.Theme.Foreground.Foreground
            Color.Gray   -> Colors.Theme.Muted.MutedForeground1
            Color.Green  -> Colors.Teal.Teal500
            Color.Blue   -> Colors.Theme.Default.Primary
            Color.Red    -> Colors.Red.Red500
            Color.Yellow -> Colors.Yellow.Yellow500
            Color.Light  -> Colors.Theme.Foreground.ForegroundInverse
            Color.White  -> Colors.Theme.Layer.LayerForeground
        }

        Type.White        -> Colors.Theme.Layer.LayerForeground
    }
}

private fun getStrokeCol(type: Type, color: Color): ComposeColor {
    return when (type) {
        Type.Outlined     -> when (color) {
            Color.Dark   -> Colors.Theme.Border.Border8
            Color.Gray   -> Colors.Theme.Border.Border5
            Color.Green  -> Colors.Teal.Teal500
            Color.Blue   -> Colors.Theme.Default.Primary
            Color.Red    -> Colors.Red.Red500
            Color.Yellow -> Colors.Yellow.Yellow500
            Color.Light  -> Colors.Theme.Border.BorderInverse
            Color.White  -> Colors.Theme.Layer.LayerBorder
        }

        Type.SoftOutlined -> when (color) {
            Color.Light -> Colors.White.White10
            Color.White -> Colors.Theme.Layer.LayerBorder
            else        -> Colors.Transparent
        }

        Type.White        -> Colors.Theme.Layer.LayerBorder
        else              -> Colors.Transparent
    }
}

private fun getContainerPadding(size: Size): Dp = when (size) {
    Size.Large          -> 8.dp
    Size.Default        -> 6.dp
    Size.Small, Size.XS -> 4.dp
}

private fun getContentPadding(size: Size): Dp = when (size) {
    Size.Large   -> 8.dp
    Size.Default -> 4.dp
    Size.Small   -> 2.dp
    Size.XS      -> 0.dp
}

private fun getHeight(size: Size): Dp = when (size) {
    Size.Large   -> 60.dp
    Size.Default -> 44.dp
    Size.Small   -> 36.dp
    Size.XS      -> 24.dp
}

private fun getShape(shape: Shape, size: Size): ComposeShape = when (shape) {
    Shape.Rounded  -> RoundedCornerShape(
        when (size) {
            Size.Large, Size.Default, Size.Small -> 8.dp
            Size.XS                              -> 6.dp
        }
    )

    Shape.Circular -> CircleShape
}
