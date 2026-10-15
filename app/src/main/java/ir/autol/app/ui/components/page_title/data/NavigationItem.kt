package ir.autol.app.ui.components.page_title.data

import androidx.compose.ui.graphics.painter.Painter

data class NavigationItem(
    val icon: Painter,
    val onClick: () -> Unit,
)
