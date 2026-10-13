package ir.autol.app.ui.components.button

sealed interface State {
   object Default: State
   object Disabled: State
   object Focus: State
   object Hover: State
}