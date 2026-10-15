package ir.autol.app.ui.components.preline.avatar

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import ir.autol.app.R
import ir.autol.app.ui.components.preline.Colors
import ir.autol.app.ui.components.preline.avatar.AvatarTheme.Color
import ir.autol.app.ui.components.preline.avatar.AvatarTheme.Shape
import ir.autol.app.ui.components.preline.avatar.AvatarTheme.Size
import ir.autol.app.ui.components.preline.avatar.AvatarTheme.Type

@Composable
fun Avatar(
    modifier: Modifier = Modifier,
    imageUrl: String? = null,
    imagePainter: Painter? = null,
    placeholder: String? = null,
    statusIcon: Painter? = null,
    internalPadding: Dp = 0.dp,
    type: Type = Type.Image,
    color: Color = Color.Image,
    size: Size = Size.XS,
    shape: Shape = Shape.Rounded,
) {
    val theme = getTheme(type, color, size, shape)
    Box(modifier = Modifier.size(theme.height)) {
        val padding = if (shape == Shape.Rounded) theme.statusSize / 2 else 0.dp
        Card(
            modifier = modifier
                .size(theme.height)
                .padding(top = padding, end = padding),
            colors = CardDefaults.cardColors(theme.background),
            border = BorderStroke(1.dp, theme.stroke),
            elevation = CardDefaults.cardElevation(0.dp),
            shape = theme.shape
        ) { Content(imagePainter, imageUrl, placeholder, theme, internalPadding) }
        if (statusIcon != null) {
            Icon(
                painter = statusIcon,
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .size(theme.statusSize),
                tint = Colors.Theme.Default.Primary
            )
        }
    }
}

@Composable
private fun Content(
    imagePainter: Painter?,
    imageUrl: String?,
    placeholder: String?,
    avatarTheme: AvatarTheme,
    internalPadding: Dp
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(internalPadding),
        contentAlignment = Alignment.Center
    ) {
        when {
            imagePainter != null -> {
                Image(
                    painter = imagePainter,
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }

            imageUrl != null     -> {
                AsyncImage(
                    model = imageUrl,
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }

            placeholder != null  -> {
                Text(
                    text = getInitials(placeholder),
                    color = avatarTheme.foreground,
                    textAlign = TextAlign.Center,
                    fontSize = avatarTheme.fontSize,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}

private fun getInitials(name: String): String {
    return name
        .trim()
        .split(Regex("\\s+"))
        .filter { it.isNotEmpty() }
        .take(2)
        .map { it.first().uppercaseChar() }
        .joinToString("")
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun AvatarPreview() {
    Avatar(
        placeholder = "Preline",
        size = Size.Default,
        modifier = Modifier,
        imageUrl = null,
        imagePainter = painterResource(R.drawable.autol),
        color = Color.Green,
        shape = Shape.Circular,
        type = Type.Solid
    )
}
