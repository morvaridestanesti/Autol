package ir.aotol.app.ui.components.preline.button_icon

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ir.aotol.app.ui.components.preline.Colors
import ir.aotol.app.ui.components.preline.button_icon.ButtonIconTheme.Color
import ir.aotol.app.ui.components.preline.button_icon.ButtonIconTheme.Size
import ir.aotol.app.ui.components.preline.button_icon.ButtonIconTheme.State
import ir.aotol.app.ui.components.preline.button_icon.ButtonIconTheme.Type
import androidx.compose.ui.graphics.Color as ComposeColor
import androidx.compose.ui.graphics.Shape as ComposeShape

data class ButtonIconTheme(
    val background: ComposeColor,
    val foreground: ComposeColor,
    val stroke: ComposeColor,
    val height: Dp,
    val padding: Dp,
    val iconSize: Dp,
    val shape: ComposeShape,
    val badgeBackground: ComposeColor,
    val badgeBorder: ComposeColor,
    val badgeForeground: ComposeColor,
    val badgeShape: ComposeShape,
) {
    sealed interface Color {
        object Dark : Color
        object Gray : Color
        object Green : Color
        object Blue : Color
        object Red : Color
        object Yellow : Color
        object Light : Color
    }

    sealed interface Size {
        object Default : Size
        object Large : Size
        object Small : Size
    }

    sealed interface State {
        object Default : State
        object Disabled : State
        object Focus : State
        object Hover : State
    }

    sealed interface Type {
        object Ghost : Type
        object Link : Type
        object Outlined : Type
        object Soft : Type
        object Solid : Type
        object White : Type
    }
}

internal fun getTheme(type: Type, color: Color, state: State, size: Size): ButtonIconTheme = ButtonIconTheme(
    background = getBackgroundColor(type, color, state),
    foreground = getForegroundColor(type, color, state),
    stroke = getStrokeColor(type, color),
    height = getHeight(size),
    padding = getContainerPadding(size),
    iconSize = getIconSize(size),
    shape = RoundedCornerShape(8.dp),
    badgeBackground = Colors.Theme.Layer.Layer,
    badgeBorder = Colors.Theme.Layer.LayerBorder,
    badgeForeground = Colors.Theme.Layer.LayerForeground,
    badgeShape = CircleShape
)

private fun getBackgroundColor(type: Type, color: Color, state: State): ComposeColor {
    return when (type) {
        Type.Ghost    -> when (color) {
            Color.Dark   -> when (state) {
                State.Default  -> Colors.Transparent
                State.Disabled -> Colors.Transparent
                State.Focus    -> Colors.Theme.Muted.MutedFocus
                State.Hover    -> Colors.Theme.Muted.MutedHover
            }

            Color.Gray   -> when (state) {
                State.Default  -> Colors.Transparent
                State.Disabled -> Colors.Transparent
                State.Focus    -> Colors.Theme.Muted.MutedFocus
                State.Hover    -> Colors.Theme.Muted.MutedHover
            }

            Color.Green  -> when (state) {
                State.Default  -> Colors.Transparent
                State.Disabled -> Colors.Transparent
                State.Focus    -> Colors.Theme.Accent.Green.Green3
                State.Hover    -> Colors.Theme.Accent.Green.Green3
            }

            Color.Blue   -> when (state) {
                State.Default  -> Colors.Transparent
                State.Disabled -> Colors.Transparent
                State.Focus    -> Colors.Theme.Accent.Primary.Primary3
                State.Hover    -> Colors.Theme.Accent.Primary.Primary3
            }

            Color.Red    -> when (state) {
                State.Default  -> Colors.Transparent
                State.Disabled -> Colors.Transparent
                State.Focus    -> Colors.Theme.Accent.Red.Red3
                State.Hover    -> Colors.Theme.Accent.Red.Red3
            }

            Color.Yellow -> when (state) {
                State.Default  -> Colors.Transparent
                State.Disabled -> Colors.Transparent
                State.Focus    -> Colors.Theme.Accent.Yellow.Yellow3
                State.Hover    -> Colors.Theme.Accent.Yellow.Yellow3
            }

            Color.Light  -> when (state) {
                State.Default  -> Colors.Transparent
                State.Disabled -> Colors.Transparent
                State.Focus    -> Colors.White.White10
                State.Hover    -> Colors.White.White10
            }
        }

        Type.Link     -> Colors.Transparent
        Type.Outlined -> Colors.Transparent
        Type.Soft     -> when (color) {
            Color.Dark   -> when (state) {
                State.Default  -> Colors.Theme.Surface.Surface
                State.Disabled -> Colors.Theme.Surface.Surface4Disabled
                State.Focus    -> Colors.Theme.Surface.SurfaceFocus
                State.Hover    -> Colors.Theme.Surface.SurfaceHover
            }

            Color.Gray   -> when (state) {
                State.Default  -> Colors.Theme.Surface.Surface
                State.Disabled -> Colors.Theme.Surface.Surface4Disabled
                State.Focus    -> Colors.Theme.Surface.SurfaceFocus
                State.Hover    -> Colors.Theme.Surface.SurfaceHover
            }

            Color.Green  -> when (state) {
                State.Default  -> Colors.Theme.Accent.Green.Green3
                State.Disabled -> Colors.Theme.Accent.Green.Green3Disabled
                State.Focus    -> Colors.Theme.Accent.Green.Green5
                State.Hover    -> Colors.Theme.Accent.Green.Green5
            }

            Color.Blue   -> when (state) {
                State.Default  -> Colors.Theme.Accent.Primary.Primary3
                State.Disabled -> Colors.Theme.Accent.Primary.Primary3DisabledButton
                State.Focus    -> Colors.Theme.Accent.Primary.Primary5
                State.Hover    -> Colors.Theme.Accent.Primary.Primary5
            }

            Color.Red    -> when (state) {
                State.Default  -> Colors.Theme.Accent.Red.Red3
                State.Disabled -> Colors.Theme.Accent.Red.Red3DisabledButton
                State.Focus    -> Colors.Theme.Accent.Red.Red5
                State.Hover    -> Colors.Theme.Accent.Red.Red5
            }

            Color.Yellow -> when (state) {
                State.Default  -> Colors.Theme.Accent.Yellow.Yellow3
                State.Disabled -> Colors.Theme.Accent.Yellow.Yellow3DisabledButton
                State.Focus    -> Colors.Theme.Accent.Yellow.Yellow5
                State.Hover    -> Colors.Theme.Accent.Yellow.Yellow5
            }

            Color.Light  -> when (state) {
                State.Default  -> Colors.White.White10
                State.Disabled -> Colors.White.White10Disabled
                State.Focus    -> Colors.White.White20
                State.Hover    -> Colors.White.White20
            }
        }

        Type.Solid    -> when (color) {
            Color.Dark   -> when (state) {
                State.Default  -> Colors.Theme.Secondary.Secondary
                State.Disabled -> Colors.Theme.Secondary.SecondaryDisabled
                State.Focus    -> Colors.Theme.Secondary.SecondaryFocus
                State.Hover    -> Colors.Theme.Secondary.SecondaryHover
            }

            Color.Gray   -> when (state) {
                State.Default  -> Colors.Theme.Surface.Surface4
                State.Disabled -> Colors.Theme.Surface.Surface4Disabled
                State.Focus    -> Colors.Theme.Surface.Surface5
                State.Hover    -> Colors.Theme.Surface.Surface5
            }

            Color.Green  -> when (state) {
                State.Default  -> Colors.Teal.Teal500
                State.Disabled -> Colors.Teal.Teal500DisabledButton
                State.Focus    -> Colors.Teal.Teal600
                State.Hover    -> Colors.Teal.Teal600
            }

            Color.Blue   -> when (state) {
                State.Default  -> Colors.Theme.Default.Primary
                State.Disabled -> Colors.Theme.Default.PrimaryDisabled
                State.Focus    -> Colors.Theme.Default.PrimaryFocus
                State.Hover    -> Colors.Theme.Default.PrimaryHover
            }

            Color.Red    -> when (state) {
                State.Default  -> Colors.Red.Red500
                State.Disabled -> Colors.Red.Red500Disabled
                State.Focus    -> Colors.Red.Red600
                State.Hover    -> Colors.Red.Red600
            }

            Color.Yellow -> when (state) {
                State.Default  -> Colors.Yellow.Yellow500
                State.Disabled -> Colors.Yellow.Yellow500Disabled
                State.Focus    -> Colors.Yellow.Yellow600
                State.Hover    -> Colors.Yellow.Yellow600
            }

            Color.Light  -> when (state) {
                State.Default  -> Colors.Theme.Background.BackgroundPlain
                State.Disabled -> Colors.Theme.Background.BackgroundPlainDisabled
                State.Focus    -> Colors.White.White90
                State.Hover    -> Colors.White.White90
            }
        }

        Type.White    -> Colors.Theme.Layer.Layer
    }
}

private fun getForegroundColor(type: Type, color: Color, state: State): ComposeColor {
    return when (type) {
        Type.Ghost    -> when (color) {
            Color.Dark   -> when (state) {
                State.Default  -> Colors.Theme.Foreground.Foreground
                State.Disabled -> Colors.Theme.Foreground.ForegroundDisabled
                else           -> Colors.Theme.Foreground.Foreground
            }

            Color.Gray   -> when (state) {
                State.Default  -> Colors.Theme.Muted.MutedForeground1
                State.Disabled -> Colors.Theme.Muted.MutedForeground1Disabled
                else           -> Colors.Theme.Muted.MutedForeground1
            }

            Color.Green  -> Colors.Teal.Teal500
            Color.Blue   -> Colors.Theme.Default.Primary
            Color.Red    -> Colors.Red.Red500
            Color.Yellow -> Colors.Yellow.Yellow500
            Color.Light  -> when (state) {
                State.Disabled -> Colors.White.White70
                else           -> Colors.Theme.Foreground.ForegroundInverse
            }
        }

        Type.Link     -> when (color) {
            Color.Dark   -> Colors.Theme.Foreground.Foreground
            Color.Gray   -> Colors.Theme.Muted.MutedForeground1
            Color.Green  -> Colors.Teal.Teal500
            Color.Blue   -> Colors.Theme.Default.Primary
            Color.Red    -> Colors.Red.Red500
            Color.Yellow -> Colors.Yellow.Yellow500
            Color.Light  -> Colors.Theme.Foreground.ForegroundInverse
        }

        Type.Outlined -> when (color) {
            Color.Dark   -> Colors.Theme.Foreground.Foreground
            Color.Gray   -> Colors.Theme.Muted.MutedForeground1
            Color.Green  -> Colors.Teal.Teal500
            Color.Blue   -> Colors.Theme.Default.Primary
            Color.Red    -> Colors.Red.Red500
            Color.Yellow -> Colors.Yellow.Yellow500
            Color.Light  -> Colors.Theme.Foreground.ForegroundInverse
        }

        Type.Soft     -> when (color) {
            Color.Dark   -> Colors.Theme.Surface.SurfaceForeground
            Color.Gray   -> Colors.Theme.Muted.MutedForeground1
            Color.Green  -> Colors.Theme.Accent.Green.Green7
            Color.Blue   -> Colors.Theme.Accent.Primary.Primary7
            Color.Red    -> Colors.Theme.Accent.Red.Red7
            Color.Yellow -> Colors.Theme.Accent.Yellow.Yellow7
            Color.Light  -> Colors.Theme.Foreground.ForegroundInverse
        }

        Type.Solid    -> when (color) {
            Color.Dark   -> Colors.Theme.Secondary.SecondaryForeground
            Color.Gray   -> Colors.Theme.Foreground.ForegroundInverse
            Color.Green  -> Colors.Theme.Foreground.ForegroundInverse
            Color.Blue   -> Colors.Theme.Default.PrimaryForeground
            Color.Red    -> Colors.Theme.Foreground.ForegroundInverse
            Color.Yellow -> Colors.Theme.Foreground.ForegroundInverse
            Color.Light  -> Colors.Theme.Background.BackgroundInverse
        }

        Type.White    -> Colors.Theme.Layer.LayerForeground
    }
}

private fun getStrokeColor(type: Type, color: Color): ComposeColor {
    return when (type) {
        Type.Outlined -> when (color) {
            Color.Dark   -> Colors.Theme.Border.Border8
            Color.Gray   -> Colors.Theme.Border.Border5
            Color.Green  -> Colors.Teal.Teal500
            Color.Blue   -> Colors.Theme.Default.Primary
            Color.Red    -> Colors.Red.Red500
            Color.Yellow -> Colors.Yellow.Yellow500
            Color.Light  -> Colors.Theme.Border.BorderInverse
        }

        else          -> Colors.Transparent
    }
}

private fun getHeight(size: Size): Dp = when (size) {
    Size.Large   -> 60.dp
    Size.Default -> 44.dp
    Size.Small   -> 36.dp
}

private fun getContainerPadding(size: Size): Dp = when (size) {
    Size.Large   -> 16.dp
    Size.Default -> 12.dp
    Size.Small   -> 10.dp
}

private fun getIconSize(size: Size): Dp = when (size) {
    Size.Large   -> 24.dp
    Size.Default -> 20.dp
    Size.Small   -> 16.dp
}
