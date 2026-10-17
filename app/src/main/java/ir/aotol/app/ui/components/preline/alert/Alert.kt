package ir.aotol.app.ui.components.preline.alert

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import ir.aotol.app.ui.components.preline.alert.data.AlertButton
import ir.aotol.app.R
import ir.aotol.app.helperes.invisibleClickable
import ir.aotol.app.ui.components.preline.Colors
import ir.aotol.app.ui.components.preline.alert.AlertTheme.Color
import ir.aotol.app.ui.components.preline.alert.AlertTheme.Type
import ir.aotol.app.ui.components.preline.button.Button
import ir.aotol.app.ui.components.preline.button.ButtonTheme
import ir.aotol.app.ui.components.preline.styled_icon.StyledIcon
import ir.aotol.app.ui.components.preline.styled_icon.StyledIconTheme

@Composable
fun Alert(
    modifier: Modifier = Modifier,
    featuredIcon: Boolean = false,
    avatar: Painter? = null,
    leadingIcon: Painter? = null,
    title: String? = null,
    subtitle: String? = null,
    messageContent: String? = null,
    button1: AlertButton? = null,
    button2: AlertButton? = null,
    type: Type = Type.Solid,
    color: Color = Color.Dark,
    onClose: (() -> Unit)? = null
) {
    val theme = getTheme(type, color)
    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(theme.container),
        border = BorderStroke(1.dp, theme.stroke),
        elevation = CardDefaults.cardElevation(0.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(intrinsicSize = IntrinsicSize.Min)
                    .padding(16.dp),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                if (featuredIcon) {
                    StyledIcon(
                        icon = painterResource(R.drawable.ic_check),
                        type = StyledIconTheme.Type.SoftOutlined,
                        color = theme.featuredIconColor,
                        size = StyledIconTheme.Size.Small,
                        shape = StyledIconTheme.Shape.Circular
                    )
                }
                avatar?.let {
                    Card(
                        modifier = Modifier.size(36.dp),
                        colors = CardDefaults.cardColors(Colors.WhiteColor),
                        elevation = CardDefaults.cardElevation(0.dp),
                        shape = CircleShape
                    ) {
                        Image(
                            painter = it,
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize(),
                        )
                    }
                }
                leadingIcon?.let {
                    Icon(
                        painter = it,
                        contentDescription = null,
                        modifier = Modifier
                            .padding(top = 4.dp)
                            .size(16.dp),
                        tint = theme.leadingIcon
                    )
                }
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        title?.let {
                            Text(
                                text = it,
                                color = theme.primaryForeground,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                        subtitle?.let {
                            Text(
                                text = it,
                                color = theme.secondaryForeground,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }
                    messageContent?.let {
                        Text(
                            text = it,
                            color = theme.secondaryForeground,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                    button1?.let { b1 ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 10.dp),
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            Button(
                                placeholder = b1.title,
                                trailingIcon = painterResource(R.drawable.ic_chevron_forward),
                                style = when (type) {
                                    Type.Solid, Type.Soft -> ButtonTheme.Style.Soft
                                    Type.White            -> ButtonTheme.Style.Link
                                },
                                color = when (type) {
                                    Type.Solid -> ButtonTheme.Color.Light
                                    Type.Soft  -> when (color) {
                                        Color.White  -> ButtonTheme.Color.Blue
                                        Color.Dark   -> ButtonTheme.Color.Dark
                                        Color.Gray   -> ButtonTheme.Color.Gray
                                        Color.Green  -> ButtonTheme.Color.Green
                                        Color.Blue   -> ButtonTheme.Color.Blue
                                        Color.Red    -> ButtonTheme.Color.Red
                                        Color.Yellow -> ButtonTheme.Color.Yellow
                                        Color.Light  -> ButtonTheme.Color.Light
                                    }

                                    Type.White -> ButtonTheme.Color.Blue
                                },
                                size = ButtonTheme.Size.Small,
                            ) { b1.onClick() }
                            button2?.let { b2 ->
                                Button(
                                    placeholder = b2.title,
                                    style = ButtonTheme.Style.Link,
                                    color = when (type) {
                                        Type.Solid -> when (color) {
                                            Color.Light -> ButtonTheme.Color.Dark
                                            else        -> ButtonTheme.Color.Light
                                        }

                                        Type.Soft  -> when (color) {
                                            Color.White  -> ButtonTheme.Color.Blue
                                            Color.Dark   -> ButtonTheme.Color.Dark
                                            Color.Gray   -> ButtonTheme.Color.Gray
                                            Color.Green  -> ButtonTheme.Color.Green
                                            Color.Blue   -> ButtonTheme.Color.Blue
                                            Color.Red    -> ButtonTheme.Color.Red
                                            Color.Yellow -> ButtonTheme.Color.Yellow
                                            Color.Light  -> ButtonTheme.Color.Light
                                        }

                                        Type.White -> ButtonTheme.Color.Gray
                                    },
                                    size = ButtonTheme.Size.Small,
                                ) { b2.onClick() }
                            }
                        }
                    }
                }
            }
            onClose?.let {
                Box(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(top = 6.dp, end = 6.dp)
                        .size(24.dp)
                        .invisibleClickable { it() },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_clear),
                        contentDescription = null,
                        modifier = Modifier.size(16.dp),
                        tint = theme.secondaryForeground
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun AlertPreview() = Alert(
    modifier = Modifier,
    featuredIcon = false,
    avatar = painterResource(R.mipmap.ic_launcher),
    leadingIcon = null,
    title = "Alert Message",
    subtitle = "5 min ago",
    messageContent = "This is an alert message!",
    button1 = AlertButton("Buttom-sm") { },
    button2 = AlertButton("Buttom-sm-2") { },
    type = Type.Solid,
    color = Color.Blue,
    onClose = {}
)
