package cz.vratislavjindra.nba.core.ui.component.topappbar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.Chat
import androidx.compose.material.icons.automirrored.rounded.Help
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import kotlinx.collections.immutable.persistentListOf

internal class TopAppBarModelPreviewProvider : PreviewParameterProvider<TopAppBarModel> {

    override val values: Sequence<TopAppBarModel>
        get() = sequenceOf(
            TopAppBarModel(
                title = "Title",
            ),
            TopAppBarModel(
                title = "Title",
                upNavigationAction = {},
            ),
            TopAppBarModel(
                title = "Title",
                actions = persistentListOf(
                    TopAppBarModel.TopAppBarAction(
                        icon = Icons.AutoMirrored.Rounded.Help,
                        contentDescription = "Help",
                        onClick = {},
                    ),
                ),
            ),
            TopAppBarModel(
                title = "Title",
                upNavigationAction = {},
                actions = persistentListOf(
                    TopAppBarModel.TopAppBarAction(
                        icon = Icons.AutoMirrored.Rounded.Help,
                        contentDescription = "Help",
                        onClick = {},
                    ),
                ),
            ),
            TopAppBarModel(
                title = "Title",
                upNavigationAction = {},
                actions = persistentListOf(
                    TopAppBarModel.TopAppBarAction(
                        icon = Icons.AutoMirrored.Rounded.Help,
                        contentDescription = "Help",
                        onClick = {},
                    ),
                    TopAppBarModel.TopAppBarAction(
                        icon = Icons.AutoMirrored.Rounded.Chat,
                        contentDescription = "Help",
                        onClick = {},
                    ),
                ),
            ),
        )
}
