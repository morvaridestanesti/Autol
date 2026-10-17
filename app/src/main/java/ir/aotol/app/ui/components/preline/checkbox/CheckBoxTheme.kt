package ir.aotol.app.ui.components.preline.checkbox

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ir.aotol.app.ui.components.preline.Colors
import ir.aotol.app.ui.components.preline.checkbox.CheckBoxTheme.Size
import ir.aotol.app.ui.components.preline.checkbox.CheckBoxTheme.State
import ir.aotol.app.ui.components.preline.checkbox.CheckBoxTheme.Style
import ir.aotol.app.ui.components.preline.checkbox.CheckBoxTheme.Type

data class CheckBoxTheme(
    val cardBackground: Color,
    val cardBorder: Color,
    val checkboxBackground: Color,
    val checkboxForeground: Color,
    val checkboxStroke: Color,
    val labelColor: Color,
    val secondaryLabelColor: Color,
    val iconTint: Color,
    val rowPadding: Dp,
    val checkboxSize: Dp,
    val checkboxIconSize: Dp,
    val iconSize: Dp,
    val shape: Shape,
    val checkboxShape: Shape,
) {
    sealed interface Size {
        object Small : Size
        object Default : Size
        object Large : Size
    }

    sealed interface State {
        object Default : State
        object Indeterminate : State
        object Focus : State
        object Disabled : State
        object Invalid : State
        object Success : State
    }

    sealed interface Style {
        object Plain : Style
        object WithinInput : Style
    }

    sealed interface Type {
        object Solid : Type
        object Soft : Type
    }
}

internal fun getTheme(checked: Boolean, type: Type, style: Style, state: State, size: Size): CheckBoxTheme = CheckBoxTheme(
    cardBackground = if (state == State.Disabled) Colors.Theme.Muted.Muted else Colors.Theme.Layer.Layer,
    cardBorder = if (style == Style.WithinInput) Colors.Theme.Layer.LayerBorder else Colors.Transparent,
    checkboxBackground = getCheckboxBackgroundColor(checked, type, state),
    checkboxForeground = getCheckboxForegroundColor(checked, type, state),
    checkboxStroke = getCheckboxStrokeColor(checked, type, state),
    labelColor = getLabelColor(state),
    secondaryLabelColor = getSecondaryLabelColor(state),
    iconTint = Colors.Theme.Muted.MutedForeground1,
    rowPadding = getRowPadding(style, size),
    checkboxSize = getCheckboxSize(state, style, size),
    checkboxIconSize = getCheckboxIconSize(size, style),
    iconSize = getIconSize(size),
    shape = RoundedCornerShape(8.dp),
    checkboxShape = RoundedCornerShape(4.dp)
)

private fun getRowPadding(style: Style, size: Size) = when (style) {
    Style.Plain       -> 0.dp
    Style.WithinInput -> when (size) {
        Size.Small   -> 10.dp
        Size.Default -> 16.dp
        Size.Large   -> 22.dp
    }
}

private fun getCheckboxSize(state: State, style: Style, size: Size) = when (style) {
    Style.Plain -> if (state == State.Focus) 24.dp else 20.dp
    else        -> when (size) {
        Size.Small   -> if (state == State.Focus) 20.dp else 16.dp
        Size.Default -> if (state == State.Focus) 24.dp else 20.dp
        Size.Large   -> if (state == State.Focus) 28.dp else 24.dp
    }
}

private fun getCheckboxIconSize(size: Size, style: Style) = when (style) {
    Style.Plain -> 12.dp
    else        -> when (size) {
        Size.Small   -> 10.dp
        Size.Default -> 12.dp
        Size.Large   -> 14.dp
    }
}

private fun getIconSize(size: Size) = when (size) {
    Size.Small   -> 16.dp
    Size.Default -> 20.dp
    Size.Large   -> 24.dp
}

private fun getCheckboxBackgroundColor(checked: Boolean, type: Type, state: State): Color {
    return when (type) {
        Type.Solid -> when (state) {
            State.Default       -> if (checked) Colors.Theme.Default.Primary else Colors.Theme.Layer.Layer
            State.Indeterminate -> Colors.Theme.Default.Primary
            State.Focus         -> Colors.Theme.Default.Primary
            State.Disabled      -> if (checked) Colors.Solid.PlainCheckDisabled else Colors.Theme.Layer.Layer
            State.Invalid       -> Colors.Transparent
            State.Success       -> Colors.Teal.Teal500
        }

        Type.Soft  -> when (state) {
            State.Default       -> if (checked) Colors.Theme.Accent.Primary.Primary4 else Colors.Theme.Layer.Layer
            State.Indeterminate -> Colors.Theme.Accent.Primary.Primary4
            State.Focus         -> Colors.Theme.Accent.Primary.Primary4
            State.Disabled      -> if (checked) Colors.Theme.Accent.Primary.Primary4 else Colors.Theme.Layer.Layer
            State.Invalid       -> Colors.Theme.Layer.Layer
            State.Success       -> Colors.Theme.Accent.Green.Green4
        }
    }
}

private fun getCheckboxForegroundColor(checked: Boolean, type: Type, state: State): Color {
    return when (type) {
        Type.Solid -> when (state) {
            State.Default       -> if (checked) Colors.Theme.Default.PrimaryForeground else Colors.Theme.Layer.Layer
            State.Indeterminate -> Colors.Theme.Default.PrimaryForeground
            State.Focus         -> Colors.Theme.Default.PrimaryForeground
            State.Disabled      -> if (checked) Colors.Theme.Default.PrimaryForeground else Colors.Theme.Layer.Layer
            State.Invalid       -> Colors.Transparent
            State.Success       -> Colors.Theme.Foreground.ForegroundInverse
        }

        Type.Soft  -> when (state) {
            State.Default       -> if (checked) Colors.Theme.Default.Primary else Colors.Theme.Layer.Layer
            State.Indeterminate -> Colors.Theme.Default.Primary
            State.Focus         -> Colors.Theme.Default.Primary
            State.Disabled      -> Colors.Theme.Foreground.ForegroundDisabled
            State.Invalid       -> Colors.Theme.Layer.Layer
            State.Success       -> Colors.Teal.Teal500
        }
    }
}

private fun getCheckboxStrokeColor(checked: Boolean, type: Type, state: State): Color {
    return when (type) {
        Type.Solid -> when (state) {
            State.Default       -> if (checked) Colors.Theme.Default.Primary else Colors.Theme.Layer.LayerBorder
            State.Indeterminate -> Colors.Theme.Default.Primary
            State.Focus         -> Colors.Theme.Default.Primary
            State.Disabled      -> if (checked) Colors.Solid.PlainCheckDisabled else Colors.Theme.Layer.LayerBorder
            State.Invalid       -> Colors.Theme.Destructive.Destructive
            State.Success       -> Colors.Teal.Teal500
        }

        Type.Soft  -> when (state) {
            State.Default       -> Colors.Theme.Layer.LayerBorder
            State.Indeterminate -> Colors.Theme.Default.Primary
            State.Focus         -> Colors.Theme.Default.Primary
            State.Disabled      -> Colors.Theme.Layer.LayerBorder
            State.Invalid       -> Colors.Theme.Destructive.Destructive
            State.Success       -> Colors.Teal.Teal500
        }
    }
}

private fun getLabelColor(state: State): Color {
    return when (state) {
        State.Disabled               -> Colors.Theme.Foreground.ForegroundDisabled
        State.Invalid, State.Success -> Colors.Theme.Surface.Surface
        else                         -> Colors.Theme.Foreground.Foreground
    }
}

private fun getSecondaryLabelColor(state: State): Color {
    return when (state) {
        State.Disabled               -> Colors.Theme.Foreground.ForegroundDisabled
        State.Invalid, State.Success -> Colors.Theme.Surface.Surface
        else                         -> Colors.Theme.Foreground.Foreground
    }
}
