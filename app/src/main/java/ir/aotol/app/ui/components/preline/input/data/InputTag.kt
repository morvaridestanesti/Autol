package ir.aotol.app.ui.components.preline.input.data

data class InputTag(
    val title: String,
    val onRemove: ((InputTag) -> Unit)? = null
)