package ir.autol.app.ui.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import ir.autol.app.R
import ir.autol.app.ui.components.PinView
import ir.autol.app.ui.components.page_title.PageTitle
import ir.autol.app.ui.components.page_title.data.NavigationItem
import ir.autol.app.ui.theme.AutolTheme
import ir.autol.app.ui.theme.Colors

@Composable
fun OtpPage(navController: NavController) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        PageTitle("تأیید شماره موبایل", NavigationItem(painterResource(R.drawable.ic_chevron_back)) { navController.popBackStack() })
        Text(
            text = "کد تایید را وارد کنید",
            color = Colors.Text.Normal,
            fontSize = 24.sp,
            fontWeight = FontWeight.ExtraBold,
        )
        Text(
            text = "کد 6 رقمی به شماره 365****0912 پیامک شد.",
            color = Colors.Text.Hint,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        PinView { }
    }
}

@Preview(showBackground = true, apiLevel = 36, showSystemUi = true)
@Composable
private fun Preview() = AutolTheme { OtpPage(rememberNavController()) }