package ir.autol.app.ui.components.preline.button_icon

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.autol.app.R
import ir.autol.app.ui.components.preline.button_icon.ButtonIconTheme.Color
import ir.autol.app.ui.components.preline.button_icon.ButtonIconTheme.Size
import ir.autol.app.ui.components.preline.button_icon.ButtonIconTheme.State
import ir.autol.app.ui.components.preline.button_icon.ButtonIconTheme.Type

@Composable
fun ButtonIcon(
    modifier: Modifier = Modifier,
    icon: Painter? = null,
    avatar: Painter? = null,
    placeholder: String? = null,
    badge: String? = null,
    type: Type = Type.Solid,
    color: Color = Color.Dark,
    state: State = State.Default,
    size: Size = Size.Default,
    onClick: () -> Unit,
) {
    val theme = getTheme(type, color, state, size)

    Box(modifier = modifier) {
        Box(modifier = Modifier.then(badge?.let { Modifier.padding(top = 10.dp) } ?: Modifier)) {
            Card(
                modifier = Modifier
                    .padding(end = badge?.let { 10.dp } ?: 0.dp)
                    .size(theme.height)
                    .align(Alignment.BottomEnd)
                    .clickable { onClick() },
                colors = CardDefaults.cardColors(theme.background),
                border = BorderStroke(if (state == State.Focus) 2.dp else 1.dp, theme.stroke),
                elevation = CardDefaults.cardElevation(0.dp),
                shape = theme.shape
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(theme.padding),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    placeholder?.let { label ->
                        Text(
                            text = label,
                            color = theme.foreground,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                    avatar?.let { av ->
                        Image(
                            painter = av,
                            contentDescription = null,
                            modifier = Modifier.size(theme.iconSize)
                        )
                    }
                    icon?.let { ic ->
                        Icon(
                            painter = ic,
                            contentDescription = null,
                            modifier = Modifier.size(theme.iconSize),
                            tint = theme.foreground
                        )
                    }
                }
            }
            badge?.let { bd ->
                Card(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .offset(y = (-10).dp),
                    colors = CardDefaults.cardColors(theme.badgeBackground),
                    border = BorderStroke(1.dp, theme.badgeBorder),
                    elevation = CardDefaults.cardElevation(2.dp),
                    shape = theme.badgeShape
                ) {
                    Text(
                        text = bd,
                        color = theme.badgeForeground,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        lineHeight = 16.sp,
                        modifier = Modifier.padding(horizontal = 4.dp),
                        maxLines = 1
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    ButtonIcon(
        icon = painterResource(R.drawable.autol),
        placeholder = "Button",
        type = Type.Solid,
        color = Color.Blue,
        state = State.Default,
        size = Size.Default,
        badge = "5"
    ) {}
}
