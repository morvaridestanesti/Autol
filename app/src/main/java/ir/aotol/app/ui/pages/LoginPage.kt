package ir.aotol.app.ui.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import ir.aotol.app.ui.components.preline.alert.data.AlertButton
import ir.aotol.app.R
import ir.aotol.app.ui.components.preline.alert.Alert
import ir.aotol.app.ui.components.preline.alert.AlertTheme
import ir.aotol.app.ui.components.preline.avatar.Avatar
import ir.aotol.app.ui.components.preline.avatar.AvatarTheme
import ir.aotol.app.ui.components.preline.button.Button
import ir.aotol.app.ui.components.preline.button.ButtonTheme
import ir.aotol.app.ui.components.preline.checkbox.CheckBoxTheme
import ir.aotol.app.ui.components.preline.checkbox.Checkbox
import ir.aotol.app.ui.components.preline.input.Input
import ir.aotol.app.ui.components.preline.input.InputTheme
import ir.aotol.app.ui.components.preline.input.data.InputContent
import ir.aotol.app.ui.theme.AotolTheme
import ir.aotol.app.ui.theme.Colors

@Composable
fun LoginPage(navController: NavController) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
    ) {
        Avatar(
            imagePainter = painterResource(R.drawable.aotol),
            internalPadding = 8.dp,
            color = AvatarTheme.Color.Blue,
            shape = AvatarTheme.Shape.Rounded,
            size = AvatarTheme.Size.Large,
            type = AvatarTheme.Type.Solid
        )
        Spacer(Modifier.height(24.dp))
        Text(
            text = "ورود یا ثبت نام",
            color = Colors.Text.Title,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
        )
        Spacer(Modifier.height(8.dp))
        Text(
            text = "شماره موبایل خود را وارد کنید تا کد تأیید برایتان پیامک شود.",
            color = Colors.Text.Hint,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
        )
        Spacer(Modifier.height(16.dp))
        Text(
            text = "شماره موبایل",
            color = Colors.Text.Label,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
        )
        Spacer(Modifier.height(16.dp))
        Input(
            value = "",
            onValueChange = {},
            placeholder = "09123456789",
            type = InputTheme.Type.Bordered,
            leadingContent = InputContent(iconEnd = painterResource(R.drawable.ic_phone))
        )
        Spacer(Modifier.height(16.dp))
        Alert(
            leadingIcon = painterResource(R.drawable.aotol),
            color = AlertTheme.Color.Yellow,
            type = AlertTheme.Type.Soft,
            messageContent = "تعداد درخواست‌های شما بیش از حد مجاز است. لطفاً 10 دقیقه دیگر تلاش کنید."
        )
        Spacer(Modifier.height(16.dp))
        Alert(
            leadingIcon = painterResource(R.drawable.aotol),
            color = AlertTheme.Color.Red,
            type = AlertTheme.Type.Soft,
            messageContent = "اتصال اینترنت خود را بررسی کنید.",
            button1 = AlertButton("تلاش مجدد") { }
        )
        Spacer(Modifier.weight(1f))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                label = null,
                type = CheckBoxTheme.Type.Solid,
                size = CheckBoxTheme.Size.Large,
                isFilled = false
            )
            Spacer(Modifier.width(8.dp))
            Text(
                text = "قوانین و مقررات ",
                textDecoration = TextDecoration.Underline,
                color = Colors.Text.Active,
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
            )
            Text(
                text = "را مطالعه کرده و می پذیرم",
                color = Colors.Text.Hint,
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
            )
        }
        Spacer(Modifier.height(12.dp))
        Button(
            placeholder = "ادامه",
            modifier = Modifier.fillMaxWidth(),
            color = ButtonTheme.Color.Gray,
            state = ButtonTheme.State.Disabled,
            isFilled = true
        ) { }
    }
}

@Preview(showBackground = true, apiLevel = 36, showSystemUi = true)
@Composable
private fun Preview() = AotolTheme { LoginPage(rememberNavController()) }