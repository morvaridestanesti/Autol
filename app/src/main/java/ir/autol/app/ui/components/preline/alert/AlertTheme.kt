package ir.autol.app.ui.components.preline.alert

import ir.autol.app.ui.components.preline.Colors
import ir.autol.app.ui.components.preline.alert.AlertTheme.Color
import ir.autol.app.ui.components.preline.alert.AlertTheme.Type
import androidx.compose.ui.graphics.Color as ComposeColor
import ir.autol.app.ui.components.preline.styled_icon.StyledIconTheme.Color as StyledIconColor

data class AlertTheme(
    val container: ComposeColor,
    val primaryForeground: ComposeColor,
    val secondaryForeground: ComposeColor,
    val stroke: ComposeColor,
    val leadingIcon: ComposeColor,
    val featuredIconColor: StyledIconColor,
) {
    sealed interface Color {
        object White : Color
        object Dark : Color
        object Gray : Color
        object Green : Color
        object Blue : Color
        object Red : Color
        object Yellow : Color
        object Light : Color
    }

    sealed interface Type {
        object Solid : Type
        object Soft : Type
        object White : Type
    }
}

internal fun getTheme(type: Type, color: Color): AlertTheme = AlertTheme(
    container = getContainerColor(type, color),
    primaryForeground = getPrimaryForegroundColor(type, color),
    secondaryForeground = getSecondaryForegroundColor(type, color),
    stroke = getStrokeColor(type, color),
    leadingIcon = getLeadingIconColor(type, color),
    featuredIconColor = getFeaturedIconColor(type, color)
)

private fun getContainerColor(type: Type, color: Color): ComposeColor {
    return when (type) {
        Type.Solid -> when (color) {
            Color.White  -> Colors.Theme.Layer.Layer
            Color.Dark   -> Colors.Theme.Secondary.Secondary
            Color.Gray   -> Colors.Theme.Surface.Surface4
            Color.Green  -> Colors.Teal.Teal500
            Color.Blue   -> Colors.Theme.Default.Primary
            Color.Red    -> Colors.Red.Red500
            Color.Yellow -> Colors.Yellow.Yellow500
            Color.Light  -> Colors.Theme.Background.BackgroundPlain
        }

        Type.Soft  -> when (color) {
            Color.White  -> Colors.Theme.Layer.Layer
            Color.Dark   -> Colors.Theme.Surface.Surface
            Color.Gray   -> Colors.Theme.Muted.Muted
            Color.Green  -> Colors.Theme.Accent.Green.Green3
            Color.Blue   -> Colors.Theme.Accent.Primary.Primary3
            Color.Red    -> Colors.Theme.Accent.Red.Red3
            Color.Yellow -> Colors.Theme.Accent.Yellow.Yellow3
            Color.Light  -> Colors.White.White10
        }

        Type.White -> Colors.Theme.Layer.Layer
    }
}

private fun getPrimaryForegroundColor(type: Type, color: Color): ComposeColor {
    return when (type) {
        Type.Solid -> when (color) {
            Color.White  -> Colors.Theme.Layer.LayerForeground
            Color.Dark   -> Colors.Theme.Secondary.SecondaryForeground
            Color.Gray   -> Colors.Theme.Foreground.ForegroundInverse
            Color.Green  -> Colors.Theme.Foreground.ForegroundInverse
            Color.Blue   -> Colors.Theme.Default.PrimaryForeground
            Color.Red    -> Colors.Theme.Foreground.ForegroundInverse
            Color.Yellow -> Colors.Theme.Foreground.ForegroundInverse
            Color.Light  -> Colors.Theme.Foreground.ForegroundInverse
        }

        Type.Soft  -> when (color) {
            Color.White  -> Colors.Theme.Layer.LayerForeground
            Color.Dark   -> Colors.Theme.Surface.Surface
            Color.Gray   -> Colors.Theme.Foreground.Foreground
            Color.Green  -> Colors.Theme.Accent.Green.Green7
            Color.Blue   -> Colors.Theme.Accent.Primary.Primary7
            Color.Red    -> Colors.Theme.Accent.Red.Red7
            Color.Yellow -> Colors.Theme.Accent.Yellow.Yellow7
            Color.Light  -> Colors.Theme.Foreground.ForegroundInverse
        }

        Type.White -> Colors.Theme.Layer.LayerForeground
    }
}

private fun getSecondaryForegroundColor(type: Type, color: Color): ComposeColor {
    return when (type) {
        Type.Solid -> when (color) {
            Color.White  -> Colors.Theme.Muted.MutedForeground1
            Color.Dark   -> Colors.Theme.Muted.MutedForeground
            Color.Gray   -> Colors.Theme.Foreground.ForegroundInverse
            Color.Green  -> Colors.Teal.Teal100
            Color.Blue   -> Colors.Theme.Default.Primary100
            Color.Red    -> Colors.Red.Red100
            Color.Yellow -> Colors.Yellow.Yellow100
            Color.Light  -> Colors.Theme.Muted.MutedForeground
        }

        Type.Soft  -> when (color) {
            Color.White  -> Colors.Theme.Muted.MutedForeground1
            Color.Dark   -> Colors.Theme.Muted.MutedForeground1
            Color.Gray   -> Colors.Theme.Muted.MutedForeground1
            Color.Green  -> Colors.Theme.Accent.Green.Green7
            Color.Blue   -> Colors.Theme.Accent.Primary.Primary7
            Color.Red    -> Colors.Theme.Accent.Red.Red7
            Color.Yellow -> Colors.Theme.Accent.Yellow.Yellow7
            Color.Light  -> Colors.White.White70
        }

        Type.White -> Colors.Theme.Muted.MutedForeground1
    }
}

private fun getStrokeColor(type: Type, color: Color): ComposeColor {
    return when (type) {
        Type.Solid -> when (color) {
            Color.White -> Colors.Theme.Layer.LayerBorder
            else        -> Colors.Transparent
        }

        Type.Soft  -> when (color) {
            Color.White  -> Colors.Theme.Layer.LayerBorder
            Color.Dark   -> Colors.Theme.Border.Border2
            Color.Gray   -> Colors.Theme.Border.Border2
            Color.Green  -> Colors.Theme.Accent.Green.Green4
            Color.Blue   -> Colors.Theme.Accent.Primary.Primary6
            Color.Red    -> Colors.Theme.Accent.Red.Red6
            Color.Yellow -> Colors.Theme.Accent.Yellow.Yellow6
            Color.Light  -> Colors.White.White10
        }

        Type.White -> Colors.Theme.Layer.LayerBorder
    }
}

private fun getLeadingIconColor(type: Type, color: Color): ComposeColor {
    return when (type) {
        Type.Solid -> when (color) {
            Color.White  -> Colors.Theme.Default.Primary
            Color.Dark   -> Colors.Theme.Secondary.SecondaryForeground
            Color.Gray   -> Colors.Theme.Foreground.ForegroundInverse
            Color.Green  -> Colors.Teal.Teal100
            Color.Blue   -> Colors.Theme.Default.Primary100
            Color.Red    -> Colors.Red.Red100
            Color.Yellow -> Colors.Yellow.Yellow100
            Color.Light  -> Colors.Theme.Muted.MutedForeground
        }

        Type.Soft  -> when (color) {
            Color.White  -> Colors.Theme.Default.Primary
            Color.Dark   -> Colors.Theme.Muted.MutedForeground1
            Color.Gray   -> Colors.Theme.Muted.MutedForeground1
            Color.Green  -> Colors.Theme.Accent.Green.Green7
            Color.Blue   -> Colors.Theme.Accent.Primary.Primary7
            Color.Red    -> Colors.Theme.Accent.Red.Red7
            Color.Yellow -> Colors.Theme.Accent.Yellow.Yellow7
            Color.Light  -> Colors.White.White70
        }

        Type.White -> Colors.Theme.Default.Primary
    }
}

private fun getFeaturedIconColor(type: Type, color: Color): StyledIconColor {
    return when (type) {
        Type.Solid -> when (color) {
            Color.White, Color.Gray -> StyledIconColor.Gray
            Color.Dark              -> StyledIconColor.Light
            Color.Green             -> StyledIconColor.Green
            Color.Blue              -> StyledIconColor.Blue
            Color.Red               -> StyledIconColor.Red
            Color.Yellow            -> StyledIconColor.Yellow
            Color.Light             -> StyledIconColor.Blue
        }

        Type.Soft  -> when (color) {
            Color.White  -> StyledIconColor.Gray
            Color.Dark   -> StyledIconColor.Dark
            Color.Gray   -> StyledIconColor.Gray
            Color.Green  -> StyledIconColor.Green
            Color.Blue   -> StyledIconColor.Blue
            Color.Red    -> StyledIconColor.Red
            Color.Yellow -> StyledIconColor.Yellow
            Color.Light  -> StyledIconColor.Light
        }

        Type.White -> StyledIconColor.Gray
    }
}
