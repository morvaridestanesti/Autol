package ir.autol.app.ui.components.preline.checkbox

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.autol.app.R
import ir.autol.app.ui.components.preline.checkbox.CheckBoxTheme.State
import ir.autol.app.ui.components.preline.checkbox.CheckBoxTheme.Size
import ir.autol.app.ui.components.preline.checkbox.CheckBoxTheme.Style
import ir.autol.app.ui.components.preline.checkbox.CheckBoxTheme.Type

@Composable
fun Checkbox(
    label: String?,
    modifier: Modifier = Modifier,
    secondaryLabel: String? = null,
    leadingIcon: Painter? = null,
    trailingIcon: Painter? = null,
    leading: Boolean = true,
    checked: Boolean = true,
    type: Type = Type.Solid,
    style: Style = Style.Plain,
    state: State = State.Default,
    size: Size = Size.Default,
    isFilled: Boolean = true,
    onCheckedChange: ((Boolean) -> Unit)? = null
) {
    val theme = getTheme(checked, type, style, state, size)

    Card(
        modifier = modifier
            .then(if (isFilled) Modifier.fillMaxWidth() else Modifier)
            .clickable(enabled = state != State.Disabled, interactionSource = remember { MutableInteractionSource() }, indication = null) { onCheckedChange?.invoke(!checked) },
        colors = CardDefaults.cardColors(theme.cardBackground),
        border = BorderStroke(1.dp, theme.cardBorder),
        elevation = CardDefaults.cardElevation(0.dp),
        shape = theme.shape
    ) {
        Row(
            modifier = Modifier
                .then(if (isFilled) Modifier.fillMaxWidth() else Modifier)
                .padding(theme.rowPadding),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            leadingIcon?.let {
                Icon(
                    painter = it,
                    contentDescription = null,
                    modifier = Modifier.size(theme.iconSize),
                    tint = theme.iconTint
                )
            }

            if (leading) CheckboxView(checked = checked, state = state, checkBoxTheme = theme)

            label?.let { label ->
                Column(modifier = Modifier.then(if (isFilled) Modifier.weight(1f) else Modifier)) {
                    Text(
                        text = label,
                        color = theme.labelColor,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    )
                    secondaryLabel?.let { secondaryLabel ->
                        Text(
                            text = secondaryLabel,
                            color = theme.secondaryLabelColor,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }

            if (!leading) CheckboxView(checked = checked, state = state, checkBoxTheme = theme)

            trailingIcon?.let {
                Icon(
                    painter = it,
                    contentDescription = null,
                    modifier = Modifier.size(theme.iconSize),
                    tint = theme.iconTint
                )
            }
        }
    }
}

@Composable
private fun CheckboxView(checked: Boolean, state: State, checkBoxTheme: CheckBoxTheme) {
    Card(
        modifier = Modifier.size(checkBoxTheme.checkboxSize),
        colors = CardDefaults.cardColors(containerColor = checkBoxTheme.checkboxBackground),
        border = BorderStroke(1.dp, checkBoxTheme.checkboxStroke),
        elevation = CardDefaults.cardElevation(0.dp),
        shape = checkBoxTheme.checkboxShape
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            if (state == State.Indeterminate) {
                Icon(
                    painter = painterResource(R.drawable.autol),
                    contentDescription = null,
                    modifier = Modifier.size(checkBoxTheme.checkboxIconSize),
                    tint = checkBoxTheme.checkboxForeground
                )
            } else {
                if (checked) {
                    Icon(
                        painter = painterResource(R.drawable.ic_check),
                        contentDescription = null,
                        modifier = Modifier.size(checkBoxTheme.checkboxIconSize),
                        tint = checkBoxTheme.checkboxForeground
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Normal() {
    val checked = remember { mutableStateOf(false) }
    Checkbox(
        label = "Title",
        secondaryLabel = "Description text",
        checked = checked.value,
        type = Type.Solid,
        style = Style.Plain,
        state = State.Default,
        size = Size.Default
    ) { checked.value = it }
}

@Preview(showBackground = true)
@Composable
private fun Indeterminate() {
    Checkbox(
        label = "Indeterminate",
        type = Type.Solid,
        style = Style.Plain,
        state = State.Indeterminate,
        size = Size.Default
    )
}

@Preview(showBackground = true)
@Composable
private fun Focus() {
    val checked = remember { mutableStateOf(false) }
    Checkbox(
        label = "Focus",
        type = Type.Solid,
        style = Style.Plain,
        state = State.Focus,
        size = Size.Default,
        checked = checked.value
    ) { checked.value = it }
}

@Preview(showBackground = true)
@Composable
private fun Disabled() {
    Checkbox(
        label = "Disabled",
        type = Type.Solid,
        style = Style.Plain,
        state = State.Disabled,
        size = Size.Default,
        checked = false
    )
}

@Preview(showBackground = true)
@Composable
private fun CheckedDisabled() {
    Checkbox(
        label = "Checked Disabled",
        type = Type.Solid,
        style = Style.Plain,
        state = State.Disabled,
        size = Size.Default
    )
}

@Preview(showBackground = true)
@Composable
private fun Success() {
    Checkbox(
        label = "Success",
        type = Type.Solid,
        style = Style.Plain,
        state = State.Success,
        size = Size.Default
    )
}

@Preview(showBackground = true)
@Composable
private fun Invalid() {
    Checkbox(
        label = "Invalid",
        type = Type.Solid,
        style = Style.Plain,
        state = State.Invalid,
        size = Size.Default
    )
}

@Preview(showBackground = true)
@Composable
private fun WithinInput() {
    Checkbox(
        label = "Within Input",
        secondaryLabel = "Description text",
        type = Type.Soft,
        style = Style.WithinInput,
        state = State.Default,
        size = Size.Default,
        leadingIcon = painterResource(R.drawable.autol),
        trailingIcon = painterResource(R.drawable.autol)
    )
}

@Preview(showBackground = true)
@Composable
private fun Plain() {
    Checkbox(
        label = "Plain",
        secondaryLabel = "Description text",
        type = Type.Soft,
        style = Style.Plain,
        state = State.Default,
        size = Size.Default,
        leadingIcon = painterResource(R.drawable.autol),
        trailingIcon = painterResource(R.drawable.autol)
    )
}

@Preview
@Composable
private fun WithoutLabel() {
    Checkbox(
        label = null,
        secondaryLabel = "Description text",
        type = Type.Soft,
        style = Style.Plain,
        state = State.Default,
        size = Size.Default,
        isFilled = false
    )
}