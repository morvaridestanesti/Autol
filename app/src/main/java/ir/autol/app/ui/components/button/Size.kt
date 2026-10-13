package ir.autol.app.ui.components.button

sealed interface Size {
    object Default : Size
    object Large : Size
    object Small : Size
}