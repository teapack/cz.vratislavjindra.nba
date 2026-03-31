package cz.vratislavjindra.nba.core.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class NbaDimensions(
    val elevationDefault: Dp = Dimensions.grid1,
    val paddingExtraSmall: Dp = Dimensions.grid1,
    val paddingSmall: Dp = Dimensions.grid2,
    val paddingDefault: Dp = Dimensions.grid4,
    val paddingLarge: Dp = Dimensions.grid6,
    val paddingExtraLarge: Dp = Dimensions.grid8,
)

internal val LocalDimensions = staticCompositionLocalOf { NbaDimensions() }
