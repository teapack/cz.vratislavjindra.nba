package cz.vratislavjindra.nba.core.ui.component.navigationcard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewParameter
import coil3.compose.rememberAsyncImagePainter
import coil3.request.ImageRequest
import cz.vratislavjindra.nba.core.ui.component.text.TextModel
import cz.vratislavjindra.nba.core.ui.theme.CardShape
import cz.vratislavjindra.nba.core.ui.theme.NbaTheme
import cz.vratislavjindra.nba.core.ui.theme.Theme
import cz.vratislavjindra.nba.core.ui.utils.DevicePreviews
import cz.vratislavjindra.nba.core.ui.utils.ThemePreviews

@Composable
fun NbaNavigationCard(
    model: NavigationCardModel,
    modifier: Modifier = Modifier,
) {
    Card(
        onClick = model.onClick,
        modifier = modifier.fillMaxWidth(),
        shape = when (model.cardShape) {
            CardShape.ROUNDED_CORNER_NONE -> Theme.shapes.roundedCornerNone
            CardShape.ROUNDED_CORNER_TOP -> Theme.shapes.roundedCornerDefaultTop
            CardShape.ROUNDED_CORNER_BOTTOM -> Theme.shapes.roundedCornerDefaultBottom
            CardShape.ROUNDED_CORNER_ALL -> Theme.shapes.roundedCornerDefaultAll
        },
        colors = CardDefaults.cardColors(containerColor = Theme.colors.surface),
    ) {
        Row(
            modifier = Modifier.padding(all = Theme.dimensions.paddingDefault),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            NavigationCardIcon(
                image = model.leadingImage,
                modifier = Modifier.padding(end = Theme.dimensions.paddingDefault),
            )
            Column(
                modifier = Modifier.weight(weight = 1f),
            ) {
                Text(
                    text = model.title,
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold,
                )
                model.description?.let { description ->
                    Text(
                        text = description,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Normal,
                    )
                }
            }
            NavigationCardIcon(
                image = model.trailingImage,
                modifier = Modifier.padding(start = Theme.dimensions.paddingDefault),
            )
        }
    }
}

@Composable
private fun NavigationCardIcon(
    image: NavigationCardModel.Image?,
    modifier: Modifier = Modifier,
) {
    image?.let {
        when (image) {
            is NavigationCardModel.Image.Url -> Icon(
                painter = rememberAsyncImagePainter(
                    model = ImageRequest.Builder(context = LocalContext.current)
                        .data(data = image.url)
                        .build()
                ),
                contentDescription = when (val contentDescription = image.contentDescription) {
                    is TextModel.StringText -> contentDescription.text
                    is TextModel.ResourceText -> stringResource(id = contentDescription.textResourceId)
                },
                modifier = modifier,
            )
            is NavigationCardModel.Image.Vector -> Icon(
                imageVector = image.imageVector,
                contentDescription = when (val contentDescription = image.contentDescription) {
                is TextModel.StringText -> contentDescription.text
                    is TextModel.ResourceText -> stringResource(id = contentDescription.textResourceId)
                },
                modifier = modifier,
                tint = MaterialTheme.colorScheme.primary,
            )
        }
    }
}

@Composable
@DevicePreviews
@ThemePreviews
private fun NbaNavigationCardPreview(
    @PreviewParameter(provider = NavigationCardModelPreviewProvider::class) model: NavigationCardModel,
) {
    NbaTheme {
        NbaNavigationCard(model = model)
    }
}
