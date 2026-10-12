package ir.autol.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import ir.autol.app.ui.navigation.AppNavHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MainActivityUi() }
    }
}

@Composable
fun MainActivityUi() = AppNavHost(rememberNavController())

@Preview(showBackground = true)
@Composable
fun GreetingPreview() = MainActivityUi()