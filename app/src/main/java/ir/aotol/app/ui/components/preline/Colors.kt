package ir.aotol.app.ui.components.preline

import androidx.compose.ui.graphics.Color

object Colors {

    val Black = Color(0xFF000000)
    val Transparent = Color(0x00000000)

    object Red {
        val Red100 = Color(0xFFFEE2E2)
        val Red400 = Color(0xFFF87171)
        val Red500 = Color(0xFFEF4444)
        val Red500Disabled = Color(0xFFF29D9D)
        val Red600 = Color(0xFFDC2626)
    }

    object Teal {
        val Teal100 = Color(0xFFCCFBF1)
        val Teal200 = Color(0xFF03DAC5)
        val Teal400 = Color(0xFF2DD4BF)
        val Teal500 = Color(0xFF14B8A6)
        val Teal500DisabledButton = Color(0xFF85D7CE)
        val Teal500DisabledButtonIcon = Color(0xFF83AAA7)
        val Teal600 = Color(0xFF0D9488)
        val Teal700 = Color(0xFF018786)
    }

    object White {
        val White1 = Color(0x03FFFFFF)
        val White10 = Color(0x1AFFFFFF)
        val White10Disabled = Color(0xFFF5F5F5)
        val White20 = Color(0x33FFFFFF)
        val White70 = Color(0xB3FFFFFF)
        val White90 = Color(0xE6FFFFFF)
    }

    object Yellow {
        val Yellow100 = Color(0xFFFEF9C3)
        val Yellow400 = Color(0xFFFACC15)
        val Yellow500 = Color(0xFFEAB308)
        val Yellow500Disabled = Color(0xFFF0D47F)
        val Yellow500DisabledButtonIcon = Color(0xFFF9F7DC)
        val Yellow600 = Color(0xFFCA8A04)
    }

    object Purple {
        val Purple200 = Color(0xFFBB86FC)
        val Purple500 = Color(0xFF6200EE)
        val Purple700 = Color(0xFF3700B3)
    }

    val FeedbackTextColorDisabled = Color(0xFFD1D5DB)

    object Ghost {
        val BlueFocusBorder = Color(0xFF2563EB)
        val GreenFocusBorder = Color(0xFF14B8A6)
        val RedFocusBorder = Color(0xFFEF4444)
        val YellowFocusBorder = Color(0xFFEAB308)
    }

    object Link {
        val BlueFocusBorder = Color(0xFF2563EB)
        val GreenFocusBorder = Color(0xFF14B8A6)
        val RedFocusBorder = Color(0xFFEF4444)
        val YellowFocusBorder = Color(0xFFEAB308)
    }

    object Soft {
        val BlueFocusBorder = Color(0xFF2563EB)
        val GreenFocusBorder = Color(0xFF14B8A6)
        val RedFocusBorder = Color(0xFFEF4444)
        val YellowFocusBorder = Color(0xFFEAB308)
    }

    object Solid {
        val BlueCloseIcon = Color(0xFF5182EF)
        val BlueFocusBorder = Color(0xFF2563EB)
        val GreenCloseIcon = Color(0xFF43C6B8)
        val GreenFocusBorder = Color(0xFF14B8A6)
        val PlainCheckDisabled = Color(0xFF8DACF0)
        val RedCloseIcon = Color(0xFFF26969)
        val RedFocusBorder = Color(0xFFEF4444)
        val YellowCloseIcon = Color(0xFFEEC239)
        val YellowFocusBorder = Color(0xFFEAB308)
    }

    object Text {
        val Invalid = Color(0xFFEF4444)
    }

    object Theme {

        object Accent {

            object Green {
                val Green2 = Color(0xFFCCFBF1)
                val Green3 = Color(0xFFCCFBF1)
                val Green3Disabled = Color(0xFFE1F8F3)
                val Green4 = Color(0xFF99F6E4)
                val Green5 = Color(0xFF99F6E4)
                val Green6 = Color(0xFF99F6E4)
                val Green7 = Color(0xFF115E59)
                val Green7Disabled = Color(0xFF83AAA7)
            }

            object Primary {
                val Primary2 = Color(0xFFDBEAFE)
                val Primary3 = Color(0xFFDBEAFE)
                val Primary3DisabledButton = Color(0xFFE8F0F9)
                val Primary3DisabledButtonIcon = Color(0xFFE8F0FA)
                val Primary4 = Color(0xFFBFDBFE)
                val Primary5 = Color(0xFFBFDBFE)
                val Primary6 = Color(0xFFBFDBFE)
                val Primary7 = Color(0xFF1E40AF)
                val Primary7Disabled = Color(0xFF8A9BD2)
            }

            object Red {
                val Red2 = Color(0xFFFEE2E2)
                val Red3 = Color(0xFFFEE2E2)
                val Red3DisabledButton = Color(0xFFF9ECEC)
                val Red3DisabledButtonIcon = Color(0xFFFAECEC)
                val Red4 = Color(0xFFFECACA)
                val Red5 = Color(0xFFFECACA)
                val Red6 = Color(0xFFFECACA)
                val Red7 = Color(0xFF991B1B)
                val Red7Disabled = Color(0xFFC78888)
            }

            object Yellow {
                val Yellow2 = Color(0xFFFEF9C3)
                val Yellow3 = Color(0xFFFEF9C3)
                val Yellow3DisabledButton = Color(0xFFF9F7DC)
                val Yellow3DisabledButtonIcon = Color(0xFFFAF7DC)
                val Yellow4 = Color(0xFFFEF08A)
                val Yellow5 = Color(0xFFFEF08A)
                val Yellow6 = Color(0xFFFEF08A)
                val Yellow7 = Color(0xFF854D0E)
                val Yellow7Disabled = Color(0xFFBDA182)
            }
        }

        object Background {
            val Background = Color(0xFFFFFFFF)
            val BackgroundInverse = Color(0xFF1F2937)
            val BackgroundPlain = Color(0xFFFFFFFF)
            val BackgroundPlainDisabled = Color(0xFFFAFAFA)
        }

        object Border {
            val Border2 = Color(0xFFE5E7EB)
            val Border5 = Color(0xFF6B7280)
            val Border5Disabled = Color(0xFFB0B4BB)
            val Border8 = Color(0xFF1F2937)
            val Border8Disabled = Color(0xFF8A8F96)
            val BorderInverse = Color(0xFFFFFFFF)
            val BorderInverseDisabled = Color(0xFFFAFAFA)
            val BorderTransparent = Color(0xFFE5E7EB)
        }

        object Card {
            val Card = Color(0xFFFFFFFF)
            val CardBorder = Color(0xFFE5E7EB)
        }

        object Default {
            val Primary = Color(0xFF2563EB)
            val Primary100 = Color(0xFFDBEAFE)
            val PrimaryActive = Color(0xFF1D4ED8)
            val PrimaryDisabled = Color(0xFF8DACF0)
            val PrimaryFocus = Color(0xFF1D4ED8)
            val PrimaryForeground = Color(0xFFFFFFFF)
            val PrimaryForegroundDisabled = Color(0xFFFAFAFA)
            val PrimaryHover = Color(0xFF1D4ED8)
            val PrimarySwitch = Color(0xFF1D4ED8)
            val PrimarySwitchFocusBorder = Color(0xFF2563EB)
        }

        object Destructive {
            val Destructive = Color(0xFFEF4444)
        }

        object Foreground {
            val Foreground = Color(0xFF1F2937)
            val ForegroundDisabled = Color(0xFF8A8F96)
            val ForegroundInverse = Color(0xFFFFFFFF)
            val ForegroundInverseDisabled = Color(0xFFFAFAFA)
            val Inverse = Color(0xFF1F2937)
            val InverseDisabled = Color(0xFF8A8F96)
        }

        object Layer {
            val Layer = Color(0xFFFFFFFF)
            val LayerBorder = Color(0xFFE5E7EB)
            val LayerBorderDisabled = Color(0xFFEDEEF0)
            val LayerDisabled = Color(0xFFFAFAFA)
            val LayerFocus = Color(0xFFF8FAFC)
            val LayerForeground = Color(0xFF1F2937)
            val LayerHover = Color(0xFFF8FAFC)
        }

        object Muted {
            val Muted = Color(0xFFF8FAFC)
            val MutedFocus = Color(0xFFF3F4F6)
            val MutedForeground = Color(0xFF9CA3AF)
            val MutedForeground1 = Color(0xFF6B7280)
            val MutedForeground1Disabled = Color(0xFFB0B4BB)
            val MutedForeground2 = Color(0xFFE3E5E7)
            val MutedHover = Color(0xFFF3F4F6)
        }

        object Secondary {
            val Secondary = Color(0xFF111827)
            val SecondaryDisabled = Color(0xFF83878E)
            val SecondaryFocus = Color(0xFF1F2937)
            val SecondaryForeground = Color(0xFFFFFFFF)
            val SecondaryForegroundDisabled = Color(0xFFFAFAFA)
            val SecondaryHover = Color(0xFF1F2937)
        }

        object Surface {
            val Surface = Color(0xFFF3F4F6)
            val Surface1 = Color(0xFFE5E7EB)
            val Surface2 = Color(0xFFD1D5DB)
            val Surface3 = Color(0xFF9CA3AF)
            val Surface4 = Color(0xFF6B7280)
            val Surface4Disabled = Color(0xFFB0B4BB)
            val Surface5 = Color(0xFF4B5563)
            val SurfaceActive = Color(0xFFE5E7EB)
            val SurfaceBorder = Color(0xFFE5E7EB)
            val SurfaceDisabledButton = Color(0xFFF4F5F5)
            val SurfaceDisabledButtonIcon = Color(0xFFF4F5F6)
            val SurfaceFocus = Color(0xFFE5E7EB)
            val SurfaceForeground = Color(0xFF1F2937)
            val SurfaceForegroundDisabled = Color(0xFF8A8F96)
            val SurfaceHover = Color(0xFFE5E7EB)
        }

        object Switch {
            val Switch = Color(0xFFFFFFFF)
        }
    }

    val WhiteColor = Color(0xFFFFFFFF)
}