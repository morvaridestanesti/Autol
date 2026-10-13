package ir.autol.app.ui.components.button

sealed interface Color {
    object Dark : Color

    object Gray : Color

    object Green : Color

    object Blue : Color

    object Red : Color

    object Yellow : Color

    object Light : Color
}