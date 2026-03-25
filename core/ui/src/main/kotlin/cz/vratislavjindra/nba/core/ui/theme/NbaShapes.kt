package cz.vratislavjindra.nba.core.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

data class NbaShapes(
    val roundedCornerSmall: Shape = RoundedCornerShape(size = 8.dp),
    val roundedCornerDefault: Shape = RoundedCornerShape(size = 16.dp),
    val roundedCornerLarge: Shape = RoundedCornerShape(size = 24.dp),
)

internal val LocalShapes = staticCompositionLocalOf { NbaShapes() }
