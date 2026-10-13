package ir.autol.app.ui.components.spinner

sealed interface Size {
    object Large : Size
    object Default : Size
    object Small : Size
    object XS : Size
}