package com.example.enchipai.enchipai.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontFamily
import net.simplifiedcoding.ui.theme.AppTypography
import net.simplifiedcoding.ui.theme.LocalSpacing
import net.simplifiedcoding.ui.theme.Spacing
import net.simplifiedcoding.ui.theme.md_theme_dark_background
import net.simplifiedcoding.ui.theme.md_theme_dark_error
import net.simplifiedcoding.ui.theme.md_theme_dark_errorContainer
import net.simplifiedcoding.ui.theme.md_theme_dark_inverseOnSurface
import net.simplifiedcoding.ui.theme.md_theme_dark_inversePrimary
import net.simplifiedcoding.ui.theme.md_theme_dark_inverseSurface
import net.simplifiedcoding.ui.theme.md_theme_dark_onBackground
import net.simplifiedcoding.ui.theme.md_theme_dark_onError
import net.simplifiedcoding.ui.theme.md_theme_dark_onErrorContainer
import net.simplifiedcoding.ui.theme.md_theme_dark_onPrimary
import net.simplifiedcoding.ui.theme.md_theme_dark_onPrimaryContainer
import net.simplifiedcoding.ui.theme.md_theme_dark_onSecondary
import net.simplifiedcoding.ui.theme.md_theme_dark_onSecondaryContainer
import net.simplifiedcoding.ui.theme.md_theme_dark_onSurface
import net.simplifiedcoding.ui.theme.md_theme_dark_onSurfaceVariant
import net.simplifiedcoding.ui.theme.md_theme_dark_onTertiary
import net.simplifiedcoding.ui.theme.md_theme_dark_onTertiaryContainer
import net.simplifiedcoding.ui.theme.md_theme_dark_outline
import net.simplifiedcoding.ui.theme.md_theme_dark_primary
import net.simplifiedcoding.ui.theme.md_theme_dark_primaryContainer
import net.simplifiedcoding.ui.theme.md_theme_dark_secondary
import net.simplifiedcoding.ui.theme.md_theme_dark_secondaryContainer
import net.simplifiedcoding.ui.theme.md_theme_dark_surface
import net.simplifiedcoding.ui.theme.md_theme_dark_surfaceTint
import net.simplifiedcoding.ui.theme.md_theme_dark_surfaceVariant
import net.simplifiedcoding.ui.theme.md_theme_dark_tertiary
import net.simplifiedcoding.ui.theme.md_theme_dark_tertiaryContainer
import net.simplifiedcoding.ui.theme.md_theme_light_background
import net.simplifiedcoding.ui.theme.md_theme_light_error
import net.simplifiedcoding.ui.theme.md_theme_light_errorContainer
import net.simplifiedcoding.ui.theme.md_theme_light_inverseOnSurface
import net.simplifiedcoding.ui.theme.md_theme_light_inversePrimary
import net.simplifiedcoding.ui.theme.md_theme_light_inverseSurface
import net.simplifiedcoding.ui.theme.md_theme_light_onBackground
import net.simplifiedcoding.ui.theme.md_theme_light_onError
import net.simplifiedcoding.ui.theme.md_theme_light_onErrorContainer
import net.simplifiedcoding.ui.theme.md_theme_light_onPrimary
import net.simplifiedcoding.ui.theme.md_theme_light_onPrimaryContainer
import net.simplifiedcoding.ui.theme.md_theme_light_onSecondary
import net.simplifiedcoding.ui.theme.md_theme_light_onSecondaryContainer
import net.simplifiedcoding.ui.theme.md_theme_light_onSurface
import net.simplifiedcoding.ui.theme.md_theme_light_onSurfaceVariant
import net.simplifiedcoding.ui.theme.md_theme_light_onTertiary
import net.simplifiedcoding.ui.theme.md_theme_light_onTertiaryContainer
import net.simplifiedcoding.ui.theme.md_theme_light_outline
import net.simplifiedcoding.ui.theme.md_theme_light_primary
import net.simplifiedcoding.ui.theme.md_theme_light_primaryContainer
import net.simplifiedcoding.ui.theme.md_theme_light_secondary
import net.simplifiedcoding.ui.theme.md_theme_light_secondaryContainer
import net.simplifiedcoding.ui.theme.md_theme_light_surface
import net.simplifiedcoding.ui.theme.md_theme_light_surfaceTint
import net.simplifiedcoding.ui.theme.md_theme_light_surfaceVariant
import net.simplifiedcoding.ui.theme.md_theme_light_tertiary
import net.simplifiedcoding.ui.theme.md_theme_light_tertiaryContainer


private val LightColors = lightColorScheme(
    primary = md_theme_light_primary,
    onPrimary = md_theme_light_onPrimary,
    primaryContainer = md_theme_light_primaryContainer,
    onPrimaryContainer = md_theme_light_onPrimaryContainer,
    secondary = md_theme_light_secondary,
    onSecondary = md_theme_light_onSecondary,
    secondaryContainer = md_theme_light_secondaryContainer,
    onSecondaryContainer = md_theme_light_onSecondaryContainer,
    tertiary = md_theme_light_tertiary,
    onTertiary = md_theme_light_onTertiary,
    tertiaryContainer = md_theme_light_tertiaryContainer,
    onTertiaryContainer = md_theme_light_onTertiaryContainer,
    error = md_theme_light_error,
    errorContainer = md_theme_light_errorContainer,
    onError = md_theme_light_onError,
    onErrorContainer = md_theme_light_onErrorContainer,
    background = md_theme_light_background,
    onBackground = md_theme_light_onBackground,
    surface = md_theme_light_surface,
    onSurface = md_theme_light_onSurface,
    surfaceVariant = md_theme_light_surfaceVariant,
    onSurfaceVariant = md_theme_light_onSurfaceVariant,
    outline = md_theme_light_outline,
    inverseOnSurface = md_theme_light_inverseOnSurface,
    inverseSurface = md_theme_light_inverseSurface,
    inversePrimary = md_theme_light_inversePrimary,
    surfaceTint = md_theme_light_surfaceTint,
)


private val DarkColors = darkColorScheme(
    primary = md_theme_dark_primary,
    onPrimary = md_theme_dark_onPrimary,
    primaryContainer = md_theme_dark_primaryContainer,
    onPrimaryContainer = md_theme_dark_onPrimaryContainer,
    secondary = md_theme_dark_secondary,
    onSecondary = md_theme_dark_onSecondary,
    secondaryContainer = md_theme_dark_secondaryContainer,
    onSecondaryContainer = md_theme_dark_onSecondaryContainer,
    tertiary = md_theme_dark_tertiary,
    onTertiary = md_theme_dark_onTertiary,
    tertiaryContainer = md_theme_dark_tertiaryContainer,
    onTertiaryContainer = md_theme_dark_onTertiaryContainer,
    error = md_theme_dark_error,
    errorContainer = md_theme_dark_errorContainer,
    onError = md_theme_dark_onError,
    onErrorContainer = md_theme_dark_onErrorContainer,
    background = md_theme_dark_background,
    onBackground = md_theme_dark_onBackground,
    surface = md_theme_dark_surface,
    onSurface = md_theme_dark_onSurface,
    surfaceVariant = md_theme_dark_surfaceVariant,
    onSurfaceVariant = md_theme_dark_onSurfaceVariant,
    outline = md_theme_dark_outline,
    inverseOnSurface = md_theme_dark_inverseOnSurface,
    inverseSurface = md_theme_dark_inverseSurface,
    inversePrimary = md_theme_dark_inversePrimary,
    surfaceTint = md_theme_dark_surfaceTint,
)


@Composable
fun EnchipaiTheme(
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (!useDarkTheme) {
        LightColors
    } else {
        DarkColors
    }

    CompositionLocalProvider(LocalSpacing provides Spacing()) {
        MaterialTheme(
            colorScheme = colors,
            content = content,
            typography = AppTypography
        )
    }
}