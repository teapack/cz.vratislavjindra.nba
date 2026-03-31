package cz.vratislavjindra.nba.core.ui.component.topappbar

import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

data class TopAppBarModel(
    val title: String,
    val upNavigationAction: (() -> Unit)? = null,
    val actions: ImmutableList<TopAppBarAction> = persistentListOf(),
) {

    data class TopAppBarAction(
        val icon: ImageVector,
        val contentDescription: String,
        val onClick: () -> Unit,
    )
}
