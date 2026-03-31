package cz.vratislavjindra.nba.core.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Shape

data class NbaShapes(
    val roundedCornerNone: Shape = RoundedCornerShape(size = Dimensions.grid0),
    val roundedCornerSmallAll: Shape = RoundedCornerShape(size = Dimensions.grid2),
    val roundedCornerDefaultAll: Shape = RoundedCornerShape(size = Dimensions.grid4),
    val roundedCornerDefaultTop: Shape = RoundedCornerShape(
        topStart = Dimensions.grid4,
        topEnd = Dimensions.grid4,
        bottomStart = Dimensions.grid0,
        bottomEnd = Dimensions.grid0,
    ),
    val roundedCornerDefaultBottom: Shape = RoundedCornerShape(
        topStart = Dimensions.grid0,
        topEnd = Dimensions.grid0,
        bottomStart = Dimensions.grid4,
        bottomEnd = Dimensions.grid4,
    ),
    val roundedCornerLargeAll: Shape = RoundedCornerShape(size = Dimensions.grid6),
)

internal val LocalShapes = staticCompositionLocalOf { NbaShapes() }
