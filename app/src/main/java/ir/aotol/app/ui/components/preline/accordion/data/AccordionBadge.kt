package ir.aotol.app.ui.components.preline.accordion.data

import ir.aotol.app.ui.components.preline.badge.BadgeTheme

data class AccordionBadge(
    val title: String,
    val type: BadgeTheme.Type = BadgeTheme.Type.Soft,
    val color: BadgeTheme.Color = BadgeTheme.Color.Blue,
    val size: BadgeTheme.Size = BadgeTheme.Size.Default,
    val shape: BadgeTheme.Shape = BadgeTheme.Shape.Pilled
)