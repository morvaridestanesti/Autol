package ir.aotol.app.helperes

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusProperties

@Composable
fun Modifier.invisibleClickable(focusable: Boolean = true, onClick: () -> Unit): Modifier = focusProperties { canFocus = focusable }.clickable(
    interactionSource = remember { MutableInteractionSource() },
    indication = null
) { onClick() }