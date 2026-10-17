package ir.aotol.app.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.aotol.app.ui.theme.Colors

@Composable
fun PinView(
    otpLength: Int = 6,
    value: String = "",
    onChange: (String) -> Unit,
) {
    val otpValue = remember { mutableStateOf(value) }
    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current
    LaunchedEffect(Unit) { focusRequester.requestFocus() }
    BasicTextField(
        value = otpValue.value,
        onValueChange = { newValue ->
            if (newValue.length <= otpLength && newValue.all { it.isDigit() }) {
                otpValue.value = newValue
                onChange(newValue)
                if (newValue.length == otpLength) {
                    focusManager.clearFocus()
                }
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .focusRequester(focusRequester),
        decorationBox = {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                repeat(otpLength) { index ->
                    PinBox(
                        value = otpValue.value.getOrNull(index)?.toString() ?: "",
                        isFocused = otpValue.value.length == index,
                        modifier = Modifier
                            .weight(1f)
                            .padding(4.dp)
                    )
                }
            }
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword)
    )
}

@Composable
private fun PinBox(
    value: String,
    isFocused: Boolean,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier,
        border = BorderStroke(1.dp, if (isFocused) Colors.Foreground.Focus else Colors.Foreground.Normal),
        colors = CardDefaults.cardColors(Colors.Background.Normal),
        shape = RoundedCornerShape(8.dp)

    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.aspectRatio(1f)
        ) {
            Text(
                text = value,
                color = if (isFocused) Colors.Text.Title else Colors.Text.Normal,
                fontSize = 32.sp,
                fontWeight = FontWeight.Black,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true, apiLevel = 36)
@Composable
private fun Preview() = PinView {}