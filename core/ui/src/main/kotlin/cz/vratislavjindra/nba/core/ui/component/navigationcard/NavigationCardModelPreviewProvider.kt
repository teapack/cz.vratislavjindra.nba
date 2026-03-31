package cz.vratislavjindra.nba.core.ui.component.navigationcard

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.Help
import androidx.compose.material.icons.automirrored.rounded.KeyboardArrowRight
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import cz.vratislavjindra.nba.core.ui.component.text.TextModel

internal class NavigationCardModelPreviewProvider : PreviewParameterProvider<NavigationCardModel> {

    override val values: Sequence<NavigationCardModel>
        get() = sequenceOf(
            NavigationCardModel(
                title = "Title",
                onClick = {},
            ),
            NavigationCardModel(
                title = "Title",
                description = "Description",
                onClick = {},
            ),
            NavigationCardModel(
                leadingImage = NavigationCardModel.Image.Vector(
                    contentDescription = TextModel.StringText(text = "Help icon"),
                    imageVector = Icons.AutoMirrored.Rounded.Help,
                ),
                title = "Title",
                description = "Description",
                onClick = {},
            ),
            NavigationCardModel(
                leadingImage = NavigationCardModel.Image.Vector(
                    contentDescription = TextModel.StringText(text = "Help icon"),
                    imageVector = Icons.AutoMirrored.Rounded.Help,
                ),
                title = "Title",
                description = null,
                onClick = {},
            ),
            NavigationCardModel(
                leadingImage = NavigationCardModel.Image.Vector(
                    contentDescription = TextModel.StringText(text = "Help icon"),
                    imageVector = Icons.AutoMirrored.Rounded.Help,
                ),
                title = "Title",
                trailingImage = NavigationCardModel.Image.Vector(
                    contentDescription = TextModel.StringText(text = "Arrow right icon"),
                    imageVector = Icons.AutoMirrored.Rounded.KeyboardArrowRight,
                ),
                onClick = {},
            ),
            NavigationCardModel(
                title = "Title",
                description = "Description",
                trailingImage = NavigationCardModel.Image.Vector(
                    contentDescription = TextModel.StringText(text = "Arrow right icon"),
                    imageVector = Icons.AutoMirrored.Rounded.KeyboardArrowRight,
                ),
                onClick = {},
            ),
            NavigationCardModel(
                leadingImage = NavigationCardModel.Image.Vector(
                    contentDescription = TextModel.StringText(text = "Help icon"),
                    imageVector = Icons.AutoMirrored.Rounded.Help,
                ),
                title = "Title",
                description = "Description",
                trailingImage = NavigationCardModel.Image.Vector(
                    contentDescription = TextModel.StringText(text = "Arrow right icon"),
                    imageVector = Icons.AutoMirrored.Rounded.KeyboardArrowRight,
                ),
                onClick = {},
            ),
        )
}
