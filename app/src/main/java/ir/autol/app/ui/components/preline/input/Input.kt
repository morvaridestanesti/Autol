package ir.autol.app.ui.components.preline.input

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.autol.app.R
import ir.autol.app.ui.components.preline.Colors
import ir.autol.app.ui.components.preline.avatar.Avatar
import ir.autol.app.ui.components.preline.avatar.AvatarTheme
import ir.autol.app.ui.components.preline.badge.Badge
import ir.autol.app.ui.components.preline.badge.BadgeTheme
import ir.autol.app.ui.components.preline.input.InputTheme.InteractionState
import ir.autol.app.ui.components.preline.input.InputTheme.Shape
import ir.autol.app.ui.components.preline.input.InputTheme.Size
import ir.autol.app.ui.components.preline.input.InputTheme.Type
import ir.autol.app.ui.components.preline.input.InputTheme.ValidationState
import ir.autol.app.ui.components.preline.input.data.InputContent
import ir.autol.app.ui.components.preline.input.data.InputTag

@Composable
fun Input(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String? = null,
    secondaryLabel: String? = null,
    placeholder: String? = null,
    feedbackMessage: String? = null,
    tags: List<InputTag> = emptyList(),
    isTagMode: Boolean = false,
    onNewTag: ((String) -> Unit)? = null,
    leadingContent: InputContent? = null,
    leadingDivider: Boolean = false,
    trailingContent: InputContent? = null,
    trailingDivider: Boolean = false,
    enabled: Boolean = true,
    singleLine: Boolean = true,
    validationState: ValidationState = ValidationState.None,
    size: Size = Size.Default,
    type: Type = Type.Bordered,
    shape: Shape = Shape.Rounded,
    keyboardType: KeyboardType = KeyboardType.Text
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isFocused by interactionSource.collectIsFocusedAsState()
    val isHovered by interactionSource.collectIsHoveredAsState()
    val isFilled = value.isNotEmpty()

    val interactionState = when {
        !enabled -> InteractionState.Disabled
        isFocused && isFilled -> InteractionState.FocusFilled
        isFocused -> InteractionState.Focus
        isHovered -> InteractionState.Hover
        else -> InteractionState.Default
    }

    val theme = getTheme(type, interactionState, validationState, size, shape)

    Column(modifier = modifier.fillMaxWidth()) {
        label?.let { labelText ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = labelText,
                    color = theme.labelColor,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(Modifier.weight(1f))
                secondaryLabel?.let { secondaryLabelText ->
                    Text(
                        text = secondaryLabelText,
                        color = theme.secondaryLabelColor,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
            Spacer(Modifier.height(10.dp))
        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(theme.containerHeight),
            colors = CardDefaults.cardColors(containerColor = theme.backgroundColor),
            border = if (type == Type.Underline) null else BorderStroke(theme.borderWidth, theme.borderColor),
            elevation = CardDefaults.cardElevation(0.dp),
            shape = theme.shape
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .let {
                        if (type == Type.Underline) {
                            it.drawBehind {
                                val strokeWidthPx = theme.borderWidth.toPx()
                                val offsetY = this.size.height - strokeWidthPx / 2
                                drawLine(
                                    color = theme.borderColor,
                                    start = Offset(0f, offsetY),
                                    end = Offset(this.size.width, offsetY),
                                    strokeWidth = strokeWidthPx
                                )
                            }
                        } else {
                            it
                        }
                    }
                    .padding(horizontal = theme.containerPadding),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(theme.contentSpacing)
            ) {
                leadingContent?.let { InputContentSlot(it, theme) }
                if (leadingDivider) InputDivider()
                Row(
                    modifier = Modifier.weight(1f),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(theme.contentSpacing)
                ) {
                    tags.forEach { tag -> InputTagChip(tag = tag) }
                    Box(modifier = Modifier.weight(1f)) {
                        if (value.isEmpty() && placeholder != null) {
                            Text(
                                text = placeholder,
                                fontSize = theme.textSize,
                                color = theme.placeholderColor
                            )
                        }
                        BasicTextField(
                            value = value,
                            onValueChange = onValueChange,
                            enabled = enabled,
                            singleLine = singleLine,
                            interactionSource = interactionSource,
                            textStyle = TextStyle(
                                fontSize = theme.textSize,
                                color = theme.textColor
                            ),
                            keyboardOptions = KeyboardOptions(keyboardType = keyboardType, imeAction = ImeAction.Done),
                            keyboardActions = KeyboardActions(onDone = {
                                if (isTagMode) {
                                    onNewTag?.invoke(value)
                                    onValueChange("")
                                }
                            }),
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
                if (trailingDivider) InputDivider()
                trailingContent?.let { InputContentSlot(it, theme) }
            }
        }
        feedbackMessage?.let { InputFeedbackMessage(message = it, inputTheme = theme) }
    }
}

@Composable
internal fun InputContentSlot(content: InputContent, inputTheme: InputTheme) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        content.iconStart?.let {
            Icon(
                painter = it,
                contentDescription = null,
                modifier = Modifier.size(inputTheme.iconSize),
                tint = inputTheme.placeholderColor
            )
        }
        content.avatarUrl?.let {
            Avatar(
                imageUrl = it,
                shape = AvatarTheme.Shape.Circular
            )
        } ?: content.avatarPainter?.let {
            Avatar(
                imagePainter = it,
                shape = AvatarTheme.Shape.Circular
            )
        }
        content.text?.let {
            Text(
                text = it,
                color = inputTheme.placeholderColor,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )
        }
        content.iconEnd?.let {
            Icon(
                painter = it,
                contentDescription = null,
                modifier = Modifier.size(inputTheme.iconSize),
                tint = inputTheme.placeholderColor
            )
        }
    }
}

@Composable
internal fun InputDivider() {
    VerticalDivider(
        modifier = Modifier.fillMaxHeight(),
        thickness = 1.dp,
        color = Colors.Theme.Layer.LayerBorder
    )
}

@Composable
internal fun InputTagChip(tag: InputTag) {
    Badge(
        placeholder = tag.title,
        onCloseClick = { tag.onRemove?.invoke(tag) },
        type = BadgeTheme.Type.White,
        color = BadgeTheme.Color.White,
        shape = BadgeTheme.Shape.Pilled
    )
}

@Composable
internal fun InputFeedbackMessage(message: String, inputTheme: InputTheme) {
    Text(
        text = message,
        fontSize = inputTheme.textSize,
        color = inputTheme.feedbackTextColor,
        modifier = Modifier.padding(top = 4.dp)
    )
}

@Preview(showBackground = true)
@Composable
private fun Basic() {
    val email = remember { mutableStateOf("") }

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Input(
                value = email.value,
                onValueChange = { email.value = it },
                label = "Email",
                placeholder = "you@email.com",
                leadingContent = InputContent(
                    iconStart = painterResource(R.drawable.autol),
                    avatarPainter = painterResource(R.drawable.autol),
                    text = "Email",
                    iconEnd = painterResource(R.drawable.autol)
                ),
                leadingDivider = true,
                trailingDivider = true,
                trailingContent = InputContent(
                    iconEnd = painterResource(R.drawable.autol)
                ),
                keyboardType = KeyboardType.Email
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Label() {
    val v1 = remember { mutableStateOf("") }
    val v2 = remember { mutableStateOf("+1 (000) 000-0000") }

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Input(
                value = v1.value,
                onValueChange = { v1.value = it },
                label = "Email",
                secondaryLabel = "Optional",
                placeholder = "you@email.com",
                feedbackMessage = "We'll never share your details."
            )
            Input(
                value = v2.value,
                onValueChange = { v2.value = it },
                label = "Phone",
                secondaryLabel = "Required"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Sizes() {
    val smallVal = remember { mutableStateOf("") }
    val defaultVal = remember { mutableStateOf("") }
    val largeVal = remember { mutableStateOf("") }

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Input(
                value = smallVal.value,
                onValueChange = { smallVal.value = it },
                placeholder = "Input-sm",
                size = Size.Small
            )
            Input(
                value = defaultVal.value,
                onValueChange = { defaultVal.value = it },
                placeholder = "Input",
                size = Size.Default
            )
            Input(
                value = largeVal.value,
                onValueChange = { largeVal.value = it },
                placeholder = "Input-lg",
                size = Size.Large
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Types() {
    val v1 = remember { mutableStateOf("you@email.com") }
    val v2 = remember { mutableStateOf("you@email.com") }
    val v3 = remember { mutableStateOf("you@email.com") }

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Input(
                value = v1.value,
                onValueChange = { v1.value = it },
                label = "Bordered",
                type = Type.Bordered,
                shape = Shape.Rounded
            )
            Input(
                value = v2.value,
                onValueChange = { v2.value = it },
                label = "Underline",
                type = Type.Underline,
                shape = Shape.None
            )
            Input(
                value = v3.value,
                onValueChange = { v3.value = it },
                label = "Gray (Light)",
                type = Type.Gray,
                shape = Shape.Rounded
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Shapes() {
    val v1 = remember { mutableStateOf("") }
    val v2 = remember { mutableStateOf("") }

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Input(
                value = v1.value,
                onValueChange = { v1.value = it },
                placeholder = "Rounded (Default)",
                shape = Shape.Rounded
            )
            Input(
                value = v2.value,
                onValueChange = { v2.value = it },
                placeholder = "Pilled",
                shape = Shape.Pilled
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun States() {
    val invalidVal = remember { mutableStateOf("you@email.com") }
    val successVal = remember { mutableStateOf("you@email.com") }

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Input(
                value = invalidVal.value,
                onValueChange = { invalidVal.value = it },
                label = "Invalid",
                validationState = ValidationState.Invalid,
                feedbackMessage = "Please enter a valid email address."
            )
            Input(
                value = successVal.value,
                onValueChange = { successVal.value = it },
                label = "Success",
                validationState = ValidationState.Success,
                feedbackMessage = "Looks good!"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Disabled() {
    val value = remember { mutableStateOf("you@email.com") }
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            Input(
                value = value.value,
                onValueChange = { value.value = it },
                label = "Disabled",
                enabled = false
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Tags() {
    val text = remember { mutableStateOf("") }
    val tags = remember { mutableStateOf(emptyList<InputTag>()) }
    val value = listOf(
        InputTag(title = "Badge", onRemove = { tag -> tags.value = tags.value.filter { it != tag } }),
        InputTag(title = "Badge", onRemove = { tag -> tags.value = tags.value.filter { it != tag } })
    )
    tags.value = value

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            Input(
                value = text.value,
                onValueChange = { text.value = it },
                label = "Tags",
                tags = tags.value,
                isTagMode = true,
                onNewTag = { tags.value + InputTag(title = it, onRemove = { tag -> tags.value = tags.value.filter { currentTag -> currentTag != tag } }) },
                placeholder = "Add people"
            )
        }
    }
}
