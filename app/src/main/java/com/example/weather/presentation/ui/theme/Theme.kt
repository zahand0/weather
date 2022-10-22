package com.example.weather.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = DarkBlue,
    background = DeepBlue,
    onBackground = Color.White,
    surface = Color.DarkGray,
    onSurface = Color.LightGray
)

private val LightColorPalette = lightColors(
    primary = Color(0xFFADB8CB),
    background = Color(0xFFE9EDF3),
    onBackground = Color(0xFF394957),
    surface = Color.LightGray,
    onSurface = Color.DarkGray
)

@Composable
fun WeatherTheme(nightTime: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (nightTime) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}