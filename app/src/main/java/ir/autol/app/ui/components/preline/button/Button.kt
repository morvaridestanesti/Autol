package ir.autol.app.ui.components.preline.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.autol.app.R
import ir.autol.app.ui.components.preline.button.ButtonTheme.Color
import ir.autol.app.ui.components.preline.button.ButtonTheme.Size
import ir.autol.app.ui.components.preline.button.ButtonTheme.State
import ir.autol.app.ui.components.preline.button.ButtonTheme.Style

@Composable
fun Button(
    modifier: Modifier = Modifier,
    style: Style = Style.Solid,
    color: Color = Color.Dark,
    state: State = State.Default,
    size: Size = Size.Default,
    leadingIcon: Painter? = null,
    leadingAvatar: Painter? = null,
    leadingDivider: Boolean = false,
    placeholder: String? = null,
    badge: Int? = null,
    trailingIcon: Painter? = null,
    trailingAvatar: Painter? = null,
    trailingDivider: Boolean = false,
    isFilled: Boolean = false,
    onClick: () -> Unit,
) {
    val theme = getTheme(style, color, state)
    val horizontalPadding = getContainerPadding(size)
    val verticalPadding = getContainerPadding(size, false)

    Card(
        modifier = modifier.clickable(interactionSource = remember { MutableInteractionSource() }, indication = null) { onClick() },
        colors = CardDefaults.cardColors(theme.background),
        border = BorderStroke(1.dp, theme.stroke),
        elevation = CardDefaults.cardElevation(0.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier
                .then(if (isFilled) Modifier.fillMaxWidth() else Modifier)
                .padding(vertical = verticalPadding, horizontal = horizontalPadding),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally)
        ) {
            leadingIcon?.let { icon ->
                Icon(
                    painter = icon,
                    contentDescription = null,
                    modifier = Modifier.size(14.dp),
                    tint = theme.foreground
                )
            }
            leadingAvatar?.let { avatar ->
                Image(
                    painter = avatar,
                    contentDescription = null,
                    modifier = Modifier.size(18.dp)
                )
            }
            if (leadingDivider) {
                VerticalDivider(
                    thickness = 1.dp,
                    color = theme.foreground
                )
            }
            placeholder?.let { label ->
                Text(
                    text = label,
                    color = theme.foreground,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                )
            }
            if (trailingDivider) {
                VerticalDivider(
                    thickness = 1.dp,
                    color = theme.foreground
                )
            }
            trailingAvatar?.let { avatar ->
                Image(
                    painter = avatar,
                    contentDescription = null,
                    modifier = Modifier.size(18.dp)
                )
            }
            trailingIcon?.let { icon ->
                Icon(
                    painter = icon,
                    contentDescription = null,
                    modifier = Modifier.size(14.dp),
                    tint = theme.foreground
                )
            }
            badge?.let { count ->
                Card(
                    colors = CardDefaults.cardColors(theme.foreground),
                    elevation = CardDefaults.cardElevation(0.dp),
                    shape = CircleShape
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Text(
                            text = count.toString(),
                            textAlign = TextAlign.Center,
                            color = theme.background,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Normal,
                            modifier = Modifier.padding(horizontal = 4.dp)
                        )
                    }
                }
            }
        }
    }
}

private fun getContainerPadding(size: Size, horizontal: Boolean = true): Dp = when (size) {
    Size.Default -> 16.dp
    Size.Large   -> 20.dp
    Size.Small   -> if (horizontal) 12.dp else 8.dp
}

@Preview
@Composable
private fun ButtonPlaceholder() {
    Button(
        placeholder = "Button",
    ) { }
}

@Preview
@Composable
private fun ButtonPlaceholderIcon() {
    Button(
        placeholder = "Button",
        trailingIcon = painterResource(R.drawable.autol),
    ) { }
}

@Preview
@Composable
private fun ButtonPlaceholderAvatar() {
    Button(
        placeholder = "Button",
        trailingAvatar = painterResource(R.drawable.autol)
    ) { }
}
