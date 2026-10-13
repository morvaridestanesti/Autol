package ir.autol.app.ui.components.button

sealed interface Style {
    object Ghost : Style
    object Outlined : Style
    object Soft : Style
    object Solid : Style
    object Link : Style
    object White : Style
}