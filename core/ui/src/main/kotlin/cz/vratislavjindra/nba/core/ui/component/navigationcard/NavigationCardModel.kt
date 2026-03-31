package cz.vratislavjindra.nba.core.ui.component.navigationcard

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.KeyboardArrowRight
import androidx.compose.ui.graphics.vector.ImageVector
import cz.vratislavjindra.nba.core.ui.R
import cz.vratislavjindra.nba.core.ui.component.text.TextModel
import cz.vratislavjindra.nba.core.ui.theme.CardShape

data class NavigationCardModel(
    val leadingImage: Image? = null,
    val title: String,
    val description: String? = null,
    val trailingImage: Image = Image.Vector(
        contentDescription = TextModel.ResourceText(
            textResourceId = R.string.content_description_navigation_card_trailing_image,
        ),
        imageVector = Icons.AutoMirrored.Rounded.KeyboardArrowRight,
    ),
    val cardShape: CardShape = CardShape.ROUNDED_CORNER_ALL,
    val onClick: () -> Unit,
) {

    sealed class Image(open val contentDescription: TextModel) {

        data class Url(
            override val contentDescription: TextModel,
            val url: String,
        ) : Image(contentDescription = contentDescription)
        data class Vector(
            override val contentDescription: TextModel,
            val imageVector: ImageVector
        ) : Image(contentDescription = contentDescription)
    }
}
