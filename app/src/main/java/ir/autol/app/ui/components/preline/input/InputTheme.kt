package ir.autol.app.ui.components.preline.input

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.autol.app.ui.components.preline.Colors
import ir.autol.app.ui.components.preline.input.InputTheme.InteractionState
import ir.autol.app.ui.components.preline.input.InputTheme.Shape
import ir.autol.app.ui.components.preline.input.InputTheme.Size
import ir.autol.app.ui.components.preline.input.InputTheme.Type
import ir.autol.app.ui.components.preline.input.InputTheme.ValidationState
import androidx.compose.ui.graphics.Shape as ComposeShape

data class InputTheme(
    val labelColor: Color,
    val secondaryLabelColor: Color,
    val borderColor: Color,
    val borderWidth: Dp,
    val backgroundColor: Color,
    val textColor: Color,
    val placeholderColor: Color,
    val feedbackTextColor: Color,
    val containerHeight: Dp,
    val containerPadding: Dp,
    val contentSpacing: Dp,
    val textSize: TextUnit,
    val iconSize: Dp,
    val shape: ComposeShape,
) {
    sealed interface InteractionState {
        object Default : InteractionState
        object Hover : InteractionState
        object Focus : InteractionState
        object FocusFilled : InteractionState
        object Disabled : InteractionState
    }

    sealed interface Shape {
        object None : Shape
        object Rounded : Shape
        object Pilled : Shape
    }

    sealed interface Size {
        object Default : Size
        object Large : Size
        object Small : Size
    }

    sealed interface Type {
        object Bordered : Type
        object Underline : Type
        object Gray : Type
    }

    sealed interface ValidationState {
        object None : ValidationState
        object Invalid : ValidationState
        object Success : ValidationState
    }
}

internal fun getTheme(type: Type, interactionState: InteractionState, validationState: ValidationState, size: Size, shape: Shape): InputTheme = InputTheme(
    labelColor = if (interactionState == InteractionState.Disabled) Colors.Theme.Foreground.ForegroundDisabled else Colors.Theme.Foreground.Foreground,
    secondaryLabelColor = if (interactionState == InteractionState.Disabled) Colors.Theme.Muted.MutedForeground1Disabled else Colors.Theme.Muted.MutedForeground1,
    borderColor = getBorderColor(interactionState, validationState),
    borderWidth = if (interactionState in listOf(InteractionState.Focus, InteractionState.FocusFilled)) 2.dp else 1.dp,
    backgroundColor = getBackgroundColor(type, interactionState),
    textColor = if (interactionState == InteractionState.Disabled) Colors.Theme.Foreground.ForegroundDisabled else Colors.Theme.Foreground.Foreground,
    placeholderColor = Colors.Theme.Muted.MutedForeground1,
    feedbackTextColor = getFeedbackTextColor(validationState, interactionState),
    containerHeight = getContainerHeight(size),
    containerPadding = getContainerPadding(size),
    contentSpacing = getContentSpacing(size),
    textSize = getTextSize(size),
    iconSize = getIconSize(size),
    shape = getCornerRadius(if (type == Type.Underline) Shape.None else shape)
)

private fun getBorderColor(
    interactionState: InteractionState,
    validationState: ValidationState
): Color {
    return when {
        validationState == ValidationState.Invalid                                       -> Colors.Theme.Destructive.Destructive
        validationState == ValidationState.Success                                       -> Colors.Teal.Teal500
        interactionState == InteractionState.Disabled                                    -> Colors.Theme.Layer.LayerBorderDisabled
        interactionState == InteractionState.Hover                                       -> Colors.Theme.Border.Border5
        interactionState in listOf(InteractionState.Focus, InteractionState.FocusFilled) -> Colors.Theme.Default.PrimaryFocus
        else                                                                             -> Colors.Theme.Layer.LayerBorder
    }
}

private fun getBackgroundColor(type: Type, interactionState: InteractionState): Color {
    return when {
        interactionState == InteractionState.Disabled -> Colors.Theme.Layer.LayerDisabled
        type == Type.Gray                             -> Colors.Theme.Muted.Muted
        else                                          -> Colors.Theme.Layer.Layer
    }
}

private fun getFeedbackTextColor(validationState: ValidationState, interactionState: InteractionState): Color {
    return when {
        interactionState == InteractionState.Disabled -> Colors.FeedbackTextColorDisabled
        validationState == ValidationState.Invalid    -> Colors.Theme.Destructive.Destructive
        validationState == ValidationState.Success    -> Colors.Teal.Teal500
        else                                          -> Colors.Theme.Muted.MutedForeground1
    }
}

private fun getContainerHeight(size: Size): Dp = when (size) {
    Size.Small   -> 36.dp
    Size.Default -> 44.dp
    Size.Large   -> 60.dp
}

private fun getContainerPadding(size: Size): Dp = when (size) {
    Size.Small   -> 10.dp
    Size.Default -> 12.dp
    Size.Large   -> 16.dp
}

private fun getContentSpacing(size: Size): Dp = when (size) {
    Size.Small   -> 6.dp
    Size.Default -> 8.dp
    Size.Large   -> 10.dp
}

private fun getTextSize(size: Size): TextUnit = when (size) {
    Size.Small   -> 13.sp
    Size.Default -> 14.sp
    Size.Large   -> 16.sp
}

private fun getIconSize(size: Size): Dp = when (size) {
    Size.Small   -> 16.dp
    Size.Default -> 18.dp
    Size.Large   -> 20.dp
}

private fun getCornerRadius(shape: Shape): ComposeShape = when (shape) {
    Shape.None    -> RoundedCornerShape(0.dp)
    Shape.Rounded -> RoundedCornerShape(8.dp)
    Shape.Pilled  -> CircleShape
}
