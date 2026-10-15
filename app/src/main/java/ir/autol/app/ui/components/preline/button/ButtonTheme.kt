package ir.autol.app.ui.components.preline.button

import ir.autol.app.ui.components.preline.Colors
import ir.autol.app.ui.components.preline.button.ButtonTheme.Color
import ir.autol.app.ui.components.preline.button.ButtonTheme.State
import ir.autol.app.ui.components.preline.button.ButtonTheme.Style
import androidx.compose.ui.graphics.Color as ComposeColor

data class ButtonTheme(
    val background: ComposeColor,
    val foreground: ComposeColor,
    val stroke: ComposeColor,
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

    sealed interface Style {
        object Ghost : Style
        object Outlined : Style
        object Soft : Style
        object Solid : Style
        object Link : Style
        object White : Style
    }
}

internal fun getTheme(style: Style, color: Color, state: State): ButtonTheme = when (style) {
    Style.Ghost    -> when (color) {
        Color.Dark   -> when (state) {
            State.Default  -> ButtonTheme(
                Colors.Transparent,
                Colors.Theme.Foreground.Foreground,
                Colors.Transparent
            )

            State.Disabled -> ButtonTheme(
                Colors.Transparent,
                Colors.Theme.Foreground.ForegroundDisabled,
                Colors.Transparent
            )

            State.Focus    -> ButtonTheme(
                Colors.Theme.Muted.MutedFocus,
                Colors.Theme.Foreground.Foreground,
                Colors.Theme.Border.BorderTransparent
            )

            State.Hover    -> ButtonTheme(
                Colors.Theme.Muted.MutedHover,
                Colors.Theme.Foreground.Foreground,
                Colors.Transparent
            )
        }

        Color.Gray   -> when (state) {
            State.Default  -> ButtonTheme(
                Colors.Transparent,
                Colors.Theme.Muted.MutedForeground1,
                Colors.Transparent
            )

            State.Disabled -> ButtonTheme(
                Colors.Theme.Muted.MutedFocus,
                Colors.Theme.Muted.MutedForeground1Disabled,
                Colors.Transparent
            )

            State.Focus    -> ButtonTheme(
                Colors.Theme.Muted.MutedFocus,
                Colors.Theme.Muted.MutedForeground1,
                Colors.Theme.Border.BorderTransparent
            )

            State.Hover    -> ButtonTheme(
                Colors.Theme.Muted.MutedHover,
                Colors.Theme.Muted.MutedForeground1,
                Colors.Transparent
            )
        }

        Color.Green  -> when (state) {
            State.Default  -> ButtonTheme(
                Colors.Transparent,
                Colors.Teal.Teal500,
                Colors.Transparent
            )

            State.Disabled -> ButtonTheme(
                Colors.Transparent,
                Colors.Teal.Teal500DisabledButton,
                Colors.Transparent
            )

            State.Focus    -> ButtonTheme(
                Colors.Theme.Accent.Green.Green3,
                Colors.Theme.Accent.Green.Green7,
                Colors.Ghost.GreenFocusBorder
            )

            State.Hover    -> ButtonTheme(
                Colors.Theme.Accent.Green.Green3,
                Colors.Theme.Accent.Green.Green7,
                Colors.Transparent
            )
        }

        Color.Blue   -> when (state) {
            State.Default  -> ButtonTheme(
                Colors.Transparent,
                Colors.Theme.Default.Primary,
                Colors.Transparent
            )

            State.Disabled -> ButtonTheme(
                Colors.Transparent,
                Colors.Theme.Default.PrimaryDisabled,
                Colors.Transparent
            )

            State.Focus    -> ButtonTheme(
                Colors.Theme.Accent.Primary.Primary3,
                Colors.Theme.Accent.Primary.Primary7,
                Colors.Ghost.BlueFocusBorder
            )

            State.Hover    -> ButtonTheme(
                Colors.Theme.Accent.Primary.Primary3,
                Colors.Theme.Accent.Primary.Primary7,
                Colors.Transparent
            )
        }

        Color.Red    -> when (state) {
            State.Default  -> ButtonTheme(
                Colors.Transparent,
                Colors.Red.Red500,
                Colors.Transparent
            )

            State.Disabled -> ButtonTheme(
                Colors.Transparent,
                Colors.Red.Red500Disabled,
                Colors.Transparent
            )

            State.Focus    -> ButtonTheme(
                Colors.Theme.Accent.Red.Red3,
                Colors.Theme.Accent.Red.Red7,
                Colors.Ghost.RedFocusBorder
            )

            State.Hover    -> ButtonTheme(
                Colors.Theme.Accent.Red.Red3,
                Colors.Theme.Accent.Red.Red7,
                Colors.Transparent
            )
        }

        Color.Yellow -> when (state) {
            State.Default  -> ButtonTheme(
                Colors.Transparent,
                Colors.Yellow.Yellow500,
                Colors.Transparent
            )

            State.Disabled -> ButtonTheme(
                Colors.Transparent,
                Colors.Yellow.Yellow500Disabled,
                Colors.Transparent
            )

            State.Focus    -> ButtonTheme(
                Colors.Theme.Accent.Yellow.Yellow3,
                Colors.Theme.Accent.Yellow.Yellow7,
                Colors.Ghost.YellowFocusBorder
            )

            State.Hover    -> ButtonTheme(
                Colors.Theme.Accent.Yellow.Yellow3,
                Colors.Theme.Accent.Yellow.Yellow7,
                Colors.Transparent
            )
        }

        Color.Light  -> when (state) {
            State.Default  -> ButtonTheme(
                Colors.Transparent,
                Colors.Theme.Foreground.ForegroundInverse,
                Colors.Transparent
            )

            State.Disabled -> ButtonTheme(
                Colors.Transparent,
                Colors.Theme.Foreground.ForegroundInverseDisabled,
                Colors.Transparent
            )

            State.Focus    -> ButtonTheme(
                Colors.White.White10,
                Colors.Theme.Foreground.ForegroundInverse,
                Colors.WhiteColor
            )

            State.Hover    -> ButtonTheme(
                Colors.White.White10,
                Colors.Theme.Foreground.ForegroundInverse,
                Colors.Transparent
            )
        }
    }

    Style.Outlined -> when (color) {
        Color.Dark   -> when (state) {
            State.Default  -> ButtonTheme(
                Colors.Transparent,
                Colors.Theme.Foreground.Foreground,
                Colors.Theme.Border.Border8
            )

            State.Disabled -> ButtonTheme(
                Colors.Transparent,
                Colors.Theme.Foreground.ForegroundDisabled,
                Colors.Theme.Border.Border8Disabled
            )

            State.Focus    -> ButtonTheme(
                Colors.White.White1,
                Colors.Theme.Default.PrimaryFocus,
                Colors.Theme.Default.PrimaryFocus
            )

            State.Hover    -> ButtonTheme(
                Colors.Transparent,
                Colors.Theme.Default.PrimaryHover,
                Colors.Theme.Default.PrimaryHover
            )
        }

        Color.Gray   -> when (state) {
            State.Default  -> ButtonTheme(
                Colors.Transparent,
                Colors.Theme.Muted.MutedForeground1,
                Colors.Theme.Border.Border5
            )

            State.Disabled -> ButtonTheme(
                Colors.Transparent,
                Colors.Theme.Muted.MutedForeground1Disabled,
                Colors.Theme.Border.Border5Disabled
            )

            State.Focus    -> ButtonTheme(
                Colors.White.White1,
                Colors.Theme.Foreground.Foreground,
                Colors.Theme.Border.Border8
            )

            State.Hover    -> ButtonTheme(
                Colors.Transparent,
                Colors.Theme.Foreground.Foreground,
                Colors.Theme.Border.Border8
            )
        }

        Color.Green  -> when (state) {
            State.Default  -> ButtonTheme(
                Colors.Transparent,
                Colors.Teal.Teal500,
                Colors.Teal.Teal500
            )

            State.Disabled -> ButtonTheme(
                Colors.Transparent,
                Colors.Teal.Teal500DisabledButton,
                Colors.Teal.Teal500DisabledButton
            )

            State.Focus    -> ButtonTheme(
                Colors.White.White1,
                Colors.Teal.Teal400,
                Colors.Teal.Teal400
            )

            State.Hover    -> ButtonTheme(
                Colors.Transparent,
                Colors.Teal.Teal400,
                Colors.Teal.Teal400
            )
        }

        Color.Blue   -> when (state) {
            State.Default  -> ButtonTheme(
                Colors.Transparent,
                Colors.Theme.Default.Primary,
                Colors.Theme.Default.Primary
            )

            State.Disabled -> ButtonTheme(
                Colors.Transparent,
                Colors.Theme.Default.PrimaryDisabled,
                Colors.Theme.Default.PrimaryDisabled
            )

            State.Focus    -> ButtonTheme(
                Colors.White.White1,
                Colors.Theme.Default.PrimaryFocus,
                Colors.Theme.Default.PrimaryFocus
            )

            State.Hover    -> ButtonTheme(
                Colors.Transparent,
                Colors.Theme.Default.PrimaryHover,
                Colors.Theme.Default.PrimaryHover
            )
        }

        Color.Red    -> when (state) {
            State.Default  -> ButtonTheme(
                Colors.Transparent,
                Colors.Red.Red500,
                Colors.Red.Red500
            )

            State.Disabled -> ButtonTheme(
                Colors.Transparent,
                Colors.Red.Red500Disabled,
                Colors.Red.Red500Disabled
            )

            State.Focus    -> ButtonTheme(
                Colors.White.White1,
                Colors.Red.Red400,
                Colors.Red.Red400
            )

            State.Hover    -> ButtonTheme(
                Colors.Transparent,
                Colors.Red.Red400,
                Colors.Red.Red400
            )
        }

        Color.Yellow -> when (state) {
            State.Default  -> ButtonTheme(
                Colors.Transparent,
                Colors.Yellow.Yellow500,
                Colors.Yellow.Yellow500
            )

            State.Disabled -> ButtonTheme(
                Colors.Transparent,
                Colors.Yellow.Yellow500Disabled,
                Colors.Yellow.Yellow500Disabled
            )

            State.Focus    -> ButtonTheme(
                Colors.White.White1,
                Colors.Yellow.Yellow400,
                Colors.Yellow.Yellow400
            )

            State.Hover    -> ButtonTheme(
                Colors.Transparent,
                Colors.Yellow.Yellow400,
                Colors.Yellow.Yellow400
            )
        }

        Color.Light  -> when (state) {
            State.Default  -> ButtonTheme(
                Colors.Transparent,
                Colors.Theme.Foreground.ForegroundInverse,
                Colors.Theme.Border.BorderInverse
            )

            State.Disabled -> ButtonTheme(
                Colors.Transparent,
                Colors.Theme.Foreground.ForegroundInverseDisabled,
                Colors.Theme.Border.BorderInverseDisabled
            )

            State.Focus    -> ButtonTheme(
                Colors.White.White1,
                Colors.White.White70,
                Colors.Theme.Border.BorderInverse
            )

            State.Hover    -> ButtonTheme(
                Colors.Transparent,
                Colors.White.White70,
                Colors.Theme.Border.BorderInverse
            )
        }
    }

    Style.Soft     -> when (color) {
        Color.Dark   -> when (state) {
            State.Default  -> ButtonTheme(
                Colors.Theme.Surface.Surface,
                Colors.Theme.Surface.SurfaceForeground,
                Colors.Transparent
            )

            State.Disabled -> ButtonTheme(
                Colors.Theme.Surface.SurfaceDisabledButton,
                Colors.Theme.Surface.SurfaceForegroundDisabled,
                Colors.Transparent
            )

            State.Focus    -> ButtonTheme(
                Colors.Theme.Surface.SurfaceFocus,
                Colors.Theme.Surface.SurfaceForeground,
                Colors.Transparent
            )

            State.Hover    -> ButtonTheme(
                Colors.Theme.Surface.SurfaceHover,
                Colors.Theme.Surface.SurfaceForeground,
                Colors.Transparent
            )
        }

        Color.Gray   -> when (state) {
            State.Default  -> ButtonTheme(
                Colors.Theme.Surface.Surface,
                Colors.Theme.Muted.MutedForeground1,
                Colors.Transparent
            )

            State.Disabled -> ButtonTheme(
                Colors.Theme.Surface.SurfaceDisabledButton,
                Colors.Theme.Muted.MutedForeground1Disabled,
                Colors.Transparent
            )

            State.Focus    -> ButtonTheme(
                Colors.Theme.Surface.SurfaceFocus,
                Colors.Theme.Muted.MutedForeground1,
                Colors.Transparent
            )

            State.Hover    -> ButtonTheme(
                Colors.Theme.Surface.SurfaceHover,
                Colors.Theme.Muted.MutedForeground1,
                Colors.Transparent
            )
        }

        Color.Green  -> when (state) {
            State.Default  -> ButtonTheme(
                Colors.Theme.Accent.Green.Green3,
                Colors.Theme.Accent.Green.Green7,
                Colors.Transparent
            )

            State.Disabled -> ButtonTheme(
                Colors.Theme.Accent.Green.Green3Disabled,
                Colors.Theme.Accent.Green.Green7Disabled,
                Colors.Transparent
            )

            State.Focus    -> ButtonTheme(
                Colors.Theme.Accent.Green.Green5,
                Colors.Theme.Accent.Green.Green7,
                Colors.Soft.GreenFocusBorder
            )

            State.Hover    -> ButtonTheme(
                Colors.Theme.Accent.Green.Green5,
                Colors.Theme.Accent.Green.Green7,
                Colors.Transparent
            )
        }

        Color.Blue   -> when (state) {
            State.Default  -> ButtonTheme(
                Colors.Theme.Accent.Primary.Primary3,
                Colors.Theme.Accent.Primary.Primary7,
                Colors.Transparent
            )

            State.Disabled -> ButtonTheme(
                Colors.Theme.Accent.Primary.Primary3DisabledButton,
                Colors.Theme.Accent.Primary.Primary7Disabled,
                Colors.Transparent
            )

            State.Focus    -> ButtonTheme(
                Colors.Theme.Accent.Primary.Primary5,
                Colors.Theme.Accent.Primary.Primary7,
                Colors.Soft.BlueFocusBorder
            )

            State.Hover    -> ButtonTheme(
                Colors.Theme.Accent.Primary.Primary5,
                Colors.Theme.Accent.Primary.Primary7,
                Colors.Transparent
            )
        }

        Color.Red    -> when (state) {
            State.Default  -> ButtonTheme(
                Colors.Theme.Accent.Red.Red3,
                Colors.Theme.Accent.Red.Red7,
                Colors.Transparent
            )

            State.Disabled -> ButtonTheme(
                Colors.Theme.Accent.Red.Red3DisabledButton,
                Colors.Theme.Accent.Red.Red7Disabled,
                Colors.Transparent
            )

            State.Focus    -> ButtonTheme(
                Colors.Theme.Accent.Red.Red5,
                Colors.Theme.Accent.Red.Red7,
                Colors.Soft.RedFocusBorder
            )

            State.Hover    -> ButtonTheme(
                Colors.Theme.Accent.Red.Red5,
                Colors.Theme.Accent.Red.Red7,
                Colors.Transparent
            )
        }

        Color.Yellow -> when (state) {
            State.Default  -> ButtonTheme(
                Colors.Theme.Accent.Yellow.Yellow3,
                Colors.Theme.Accent.Yellow.Yellow7,
                Colors.Transparent
            )

            State.Disabled -> ButtonTheme(
                Colors.Theme.Accent.Yellow.Yellow3DisabledButton,
                Colors.Theme.Accent.Yellow.Yellow7Disabled,
                Colors.Transparent
            )

            State.Focus    -> ButtonTheme(
                Colors.Theme.Accent.Yellow.Yellow5,
                Colors.Theme.Accent.Yellow.Yellow7,
                Colors.Soft.YellowFocusBorder
            )

            State.Hover    -> ButtonTheme(
                Colors.Theme.Accent.Yellow.Yellow5,
                Colors.Theme.Accent.Yellow.Yellow7,
                Colors.Transparent
            )
        }

        Color.Light  -> when (state) {
            State.Default  -> ButtonTheme(
                Colors.White.White10,
                Colors.Theme.Foreground.ForegroundInverse,
                Colors.Transparent
            )

            State.Disabled -> ButtonTheme(
                Colors.White.White10Disabled,
                Colors.Theme.Foreground.ForegroundInverseDisabled,
                Colors.Transparent
            )

            State.Focus    -> ButtonTheme(
                Colors.White.White20,
                Colors.Theme.Foreground.ForegroundInverse,
                Colors.WhiteColor
            )

            State.Hover    -> ButtonTheme(
                Colors.White.White20,
                Colors.Theme.Foreground.ForegroundInverse,
                Colors.Transparent
            )
        }
    }

    Style.Solid    -> when (color) {
        Color.Dark   -> when (state) {
            State.Default  -> ButtonTheme(
                Colors.Theme.Secondary.Secondary,
                Colors.Theme.Secondary.SecondaryForeground,
                Colors.Transparent
            )

            State.Disabled -> ButtonTheme(
                Colors.Theme.Secondary.SecondaryDisabled,
                Colors.Theme.Secondary.SecondaryForegroundDisabled,
                Colors.Transparent
            )

            State.Focus    -> ButtonTheme(
                Colors.Theme.Secondary.SecondaryFocus,
                Colors.Theme.Secondary.SecondaryForeground,
                Colors.Transparent
            )

            State.Hover    -> ButtonTheme(
                Colors.Theme.Secondary.SecondaryHover,
                Colors.Theme.Secondary.SecondaryForeground,
                Colors.Transparent
            )
        }

        Color.Gray   -> when (state) {
            State.Default  -> ButtonTheme(
                Colors.Theme.Surface.Surface4,
                Colors.Theme.Foreground.ForegroundInverse,
                Colors.Transparent
            )

            State.Disabled -> ButtonTheme(
                Colors.Theme.Surface.Surface4Disabled,
                Colors.Theme.Foreground.ForegroundInverseDisabled,
                Colors.Transparent
            )

            State.Focus    -> ButtonTheme(
                Colors.Theme.Surface.Surface5,
                Colors.Theme.Foreground.ForegroundInverse,
                Colors.Transparent
            )

            State.Hover    -> ButtonTheme(
                Colors.Theme.Surface.Surface5,
                Colors.Theme.Foreground.ForegroundInverse,
                Colors.Transparent
            )
        }

        Color.Green  -> when (state) {
            State.Default  -> ButtonTheme(
                Colors.Teal.Teal500,
                Colors.Theme.Foreground.ForegroundInverse,
                Colors.Transparent
            )

            State.Disabled -> ButtonTheme(
                Colors.Teal.Teal500DisabledButton,
                Colors.Theme.Foreground.ForegroundInverseDisabled,
                Colors.Transparent
            )

            State.Focus    -> ButtonTheme(
                Colors.Teal.Teal600,
                Colors.Theme.Foreground.ForegroundInverse,
                Colors.Solid.GreenFocusBorder
            )

            State.Hover    -> ButtonTheme(
                Colors.Teal.Teal600,
                Colors.Theme.Foreground.ForegroundInverse,
                Colors.Transparent
            )
        }

        Color.Blue   -> when (state) {
            State.Default  -> ButtonTheme(
                Colors.Theme.Default.Primary,
                Colors.Theme.Default.PrimaryForeground,
                Colors.Transparent
            )

            State.Disabled -> ButtonTheme(
                Colors.Theme.Default.PrimaryDisabled,
                Colors.Theme.Default.PrimaryForegroundDisabled,
                Colors.Transparent
            )

            State.Focus    -> ButtonTheme(
                Colors.Theme.Default.PrimaryFocus,
                Colors.Theme.Default.PrimaryForeground,
                Colors.Solid.BlueFocusBorder
            )

            State.Hover    -> ButtonTheme(
                Colors.Theme.Default.PrimaryHover,
                Colors.Theme.Default.PrimaryForeground,
                Colors.Transparent
            )
        }

        Color.Red    -> when (state) {
            State.Default  -> ButtonTheme(
                Colors.Red.Red500,
                Colors.Theme.Foreground.ForegroundInverse,
                Colors.Transparent
            )

            State.Disabled -> ButtonTheme(
                Colors.Red.Red500Disabled,
                Colors.Theme.Foreground.ForegroundInverseDisabled,
                Colors.Transparent
            )

            State.Focus    -> ButtonTheme(
                Colors.Red.Red600,
                Colors.Theme.Foreground.ForegroundInverse,
                Colors.Solid.RedFocusBorder
            )

            State.Hover    -> ButtonTheme(
                Colors.Red.Red600,
                Colors.Theme.Foreground.ForegroundInverse,
                Colors.Transparent
            )
        }

        Color.Yellow -> when (state) {
            State.Default  -> ButtonTheme(
                Colors.Yellow.Yellow500,
                Colors.Theme.Foreground.ForegroundInverse,
                Colors.Transparent
            )

            State.Disabled -> ButtonTheme(
                Colors.Yellow.Yellow500Disabled,
                Colors.Theme.Foreground.ForegroundInverseDisabled,
                Colors.Transparent
            )

            State.Focus    -> ButtonTheme(
                Colors.Yellow.Yellow600,
                Colors.Theme.Foreground.ForegroundInverse,
                Colors.Solid.YellowFocusBorder
            )

            State.Hover    -> ButtonTheme(
                Colors.Yellow.Yellow600,
                Colors.Theme.Foreground.ForegroundInverse,
                Colors.Transparent
            )
        }

        Color.Light  -> when (state) {
            State.Default  -> ButtonTheme(
                Colors.Theme.Background.BackgroundPlain,
                Colors.Theme.Foreground.Inverse,
                Colors.Transparent
            )

            State.Disabled -> ButtonTheme(
                Colors.Theme.Background.BackgroundPlainDisabled,
                Colors.Theme.Foreground.InverseDisabled,
                Colors.Transparent
            )

            State.Focus    -> ButtonTheme(
                Colors.White.White90,
                Colors.Theme.Foreground.Inverse,
                Colors.WhiteColor
            )

            State.Hover    -> ButtonTheme(
                Colors.White.White90,
                Colors.Theme.Foreground.Inverse,
                Colors.Transparent
            )
        }
    }

    Style.Link     -> when (color) {
        Color.Dark   -> when (state) {
            State.Default  -> ButtonTheme(
                Colors.Transparent,
                Colors.Theme.Foreground.Foreground,
                Colors.Transparent
            )

            State.Disabled -> ButtonTheme(
                Colors.Transparent,
                Colors.Theme.Foreground.ForegroundDisabled,
                Colors.Transparent
            )

            State.Focus    -> ButtonTheme(
                Colors.White.White1,
                Colors.Theme.Default.PrimaryFocus,
                Colors.Theme.Border.BorderTransparent
            )

            State.Hover    -> ButtonTheme(
                Colors.Transparent,
                Colors.Theme.Default.PrimaryHover,
                Colors.Transparent
            )
        }

        Color.Gray   -> when (state) {
            State.Default  -> ButtonTheme(
                Colors.Transparent,
                Colors.Theme.Muted.MutedForeground1,
                Colors.Transparent
            )

            State.Disabled -> ButtonTheme(
                Colors.Transparent,
                Colors.Theme.Muted.MutedForeground1Disabled,
                Colors.Transparent
            )

            State.Focus    -> ButtonTheme(
                Colors.White.White1,
                Colors.Theme.Default.PrimaryFocus,
                Colors.Theme.Border.BorderTransparent
            )

            State.Hover    -> ButtonTheme(
                Colors.Transparent,
                Colors.Theme.Default.PrimaryFocus,
                Colors.Transparent
            )
        }

        Color.Green  -> when (state) {
            State.Default  -> ButtonTheme(
                Colors.Transparent,
                Colors.Teal.Teal500,
                Colors.Transparent
            )

            State.Disabled -> ButtonTheme(
                Colors.Transparent,
                Colors.Teal.Teal500DisabledButton,
                Colors.Transparent
            )

            State.Focus    -> ButtonTheme(
                Colors.White.White1,
                Colors.Teal.Teal600,
                Colors.Link.GreenFocusBorder
            )

            State.Hover    -> ButtonTheme(
                Colors.Transparent,
                Colors.Teal.Teal600,
                Colors.Transparent
            )
        }

        Color.Blue   -> when (state) {
            State.Default  -> ButtonTheme(
                Colors.Transparent,
                Colors.Theme.Default.Primary,
                Colors.Transparent
            )

            State.Disabled -> ButtonTheme(
                Colors.Transparent,
                Colors.Theme.Default.PrimaryDisabled,
                Colors.Transparent
            )

            State.Focus    -> ButtonTheme(
                Colors.White.White1,
                Colors.Theme.Default.PrimaryFocus,
                Colors.Link.BlueFocusBorder
            )

            State.Hover    -> ButtonTheme(
                Colors.Transparent,
                Colors.Theme.Default.PrimaryHover,
                Colors.Transparent
            )
        }

        Color.Red    -> when (state) {
            State.Default  -> ButtonTheme(
                Colors.Transparent,
                Colors.Red.Red500,
                Colors.Transparent
            )

            State.Disabled -> ButtonTheme(
                Colors.Transparent,
                Colors.Red.Red500Disabled,
                Colors.Transparent
            )

            State.Focus    -> ButtonTheme(
                Colors.White.White1,
                Colors.Red.Red600,
                Colors.Link.RedFocusBorder
            )

            State.Hover    -> ButtonTheme(
                Colors.Transparent,
                Colors.Red.Red600,
                Colors.Transparent
            )
        }

        Color.Yellow -> when (state) {
            State.Default  -> ButtonTheme(
                Colors.Transparent,
                Colors.Yellow.Yellow500,
                Colors.Transparent
            )

            State.Disabled -> ButtonTheme(
                Colors.Transparent,
                Colors.Yellow.Yellow500Disabled,
                Colors.Transparent
            )

            State.Focus    -> ButtonTheme(
                Colors.White.White1,
                Colors.Yellow.Yellow600,
                Colors.Link.YellowFocusBorder
            )

            State.Hover    -> ButtonTheme(
                Colors.Transparent,
                Colors.Yellow.Yellow600,
                Colors.Transparent
            )
        }

        Color.Light  -> when (state) {
            State.Default  -> ButtonTheme(
                Colors.Transparent,
                Colors.Theme.Foreground.ForegroundInverse,
                Colors.Transparent
            )

            State.Disabled -> ButtonTheme(
                Colors.Transparent,
                Colors.Theme.Foreground.ForegroundInverseDisabled,
                Colors.Transparent
            )

            State.Focus    -> ButtonTheme(
                Colors.White.White1,
                Colors.Theme.Foreground.ForegroundInverse,
                Colors.WhiteColor
            )

            State.Hover    -> ButtonTheme(
                Colors.Transparent,
                Colors.Theme.Foreground.ForegroundInverse,
                Colors.Transparent
            )
        }
    }

    Style.White    -> when (color) {
        Color.Dark   -> when (state) {
            State.Default  -> ButtonTheme(
                Colors.Theme.Layer.Layer,
                Colors.Theme.Layer.LayerForeground,
                Colors.Theme.Border.BorderTransparent
            )

            State.Disabled -> ButtonTheme(
                Colors.Theme.Layer.Layer,
                Colors.Theme.Layer.LayerForeground,
                Colors.Theme.Border.BorderTransparent
            )

            State.Focus    -> ButtonTheme(
                Colors.Theme.Layer.LayerFocus,
                Colors.Theme.Layer.LayerForeground,
                Colors.Theme.Border.BorderTransparent
            )

            State.Hover    -> ButtonTheme(
                Colors.Theme.Layer.LayerHover,
                Colors.Theme.Layer.LayerForeground,
                Colors.Theme.Border.BorderTransparent
            )
        }

        Color.Gray   -> when (state) {
            State.Default  -> ButtonTheme(
                Colors.Theme.Layer.Layer,
                Colors.Theme.Muted.MutedForeground1,
                Colors.Theme.Border.BorderTransparent
            )

            State.Disabled -> ButtonTheme(
                Colors.Theme.Layer.Layer,
                Colors.Theme.Muted.MutedForeground1,
                Colors.Theme.Border.BorderTransparent
            )

            State.Focus    -> ButtonTheme(
                Colors.Theme.Layer.LayerFocus,
                Colors.Theme.Muted.MutedForeground1,
                Colors.Theme.Border.BorderTransparent
            )

            State.Hover    -> ButtonTheme(
                Colors.Theme.Layer.LayerHover,
                Colors.Theme.Muted.MutedForeground1,
                Colors.Theme.Border.BorderTransparent
            )
        }

        Color.Green  -> when (state) {
            State.Default  -> ButtonTheme(
                Colors.Theme.Layer.Layer,
                Colors.Teal.Teal500,
                Colors.Theme.Border.BorderTransparent
            )

            State.Disabled -> ButtonTheme(
                Colors.Theme.Layer.Layer,
                Colors.Teal.Teal500,
                Colors.Theme.Border.BorderTransparent
            )

            State.Focus    -> ButtonTheme(
                Colors.Theme.Layer.LayerFocus,
                Colors.Teal.Teal500,
                Colors.Theme.Border.BorderTransparent
            )

            State.Hover    -> ButtonTheme(
                Colors.Theme.Layer.LayerHover,
                Colors.Teal.Teal500,
                Colors.Theme.Border.BorderTransparent
            )
        }

        Color.Blue   -> when (state) {
            State.Default  -> ButtonTheme(
                Colors.Theme.Layer.Layer,
                Colors.Theme.Default.Primary,
                Colors.Theme.Border.BorderTransparent
            )

            State.Disabled -> ButtonTheme(
                Colors.Theme.Layer.Layer,
                Colors.Theme.Default.Primary,
                Colors.Theme.Border.BorderTransparent
            )

            State.Focus    -> ButtonTheme(
                Colors.Theme.Layer.LayerFocus,
                Colors.Theme.Default.Primary,
                Colors.Theme.Border.BorderTransparent
            )

            State.Hover    -> ButtonTheme(
                Colors.Theme.Layer.LayerHover,
                Colors.Theme.Default.Primary,
                Colors.Theme.Border.BorderTransparent
            )
        }

        Color.Red    -> when (state) {
            State.Default  -> ButtonTheme(
                Colors.Theme.Layer.Layer,
                Colors.Red.Red500,
                Colors.Theme.Border.BorderTransparent
            )

            State.Disabled -> ButtonTheme(
                Colors.Theme.Layer.Layer,
                Colors.Red.Red500,
                Colors.Theme.Border.BorderTransparent
            )

            State.Focus    -> ButtonTheme(
                Colors.Theme.Layer.LayerFocus,
                Colors.Red.Red500,
                Colors.Theme.Border.BorderTransparent
            )

            State.Hover    -> ButtonTheme(
                Colors.Theme.Layer.LayerHover,
                Colors.Red.Red500,
                Colors.Theme.Border.BorderTransparent
            )
        }

        Color.Yellow -> when (state) {
            State.Default  -> ButtonTheme(
                Colors.Theme.Layer.Layer,
                Colors.Yellow.Yellow500,
                Colors.Theme.Border.BorderTransparent
            )

            State.Disabled -> ButtonTheme(
                Colors.Theme.Layer.Layer,
                Colors.Yellow.Yellow500,
                Colors.Theme.Border.BorderTransparent
            )

            State.Focus    -> ButtonTheme(
                Colors.Theme.Layer.LayerFocus,
                Colors.Yellow.Yellow500,
                Colors.Theme.Border.BorderTransparent
            )

            State.Hover    -> ButtonTheme(
                Colors.Theme.Layer.LayerHover,
                Colors.Yellow.Yellow500,
                Colors.Theme.Border.BorderTransparent
            )
        }

        Color.Light  -> when (state) {
            State.Default  -> ButtonTheme(
                Colors.Theme.Layer.Layer,
                Colors.Theme.Foreground.Inverse,
                Colors.Theme.Border.BorderTransparent
            )

            State.Disabled -> ButtonTheme(
                Colors.Theme.Layer.LayerDisabled,
                Colors.Theme.Foreground.InverseDisabled,
                Colors.Theme.Border.BorderTransparent
            )

            State.Focus    -> ButtonTheme(
                Colors.White.White90,
                Colors.Theme.Foreground.Inverse,
                Colors.Transparent
            )

            State.Hover    -> ButtonTheme(
                Colors.White.White90,
                Colors.Theme.Foreground.Inverse,
                Colors.Transparent
            )
        }
    }
}