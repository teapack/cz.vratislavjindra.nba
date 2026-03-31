package cz.vratislavjindra.nba.core.ui.component.text

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewParameter
import cz.vratislavjindra.nba.core.ui.theme.NbaTheme
import cz.vratislavjindra.nba.core.ui.utils.DevicePreviews
import cz.vratislavjindra.nba.core.ui.utils.ThemePreviews

@Composable
fun NbaText(
    model: TextModel,
    modifier: Modifier = Modifier,
) {
    Text(
        text = when (model) {
            is TextModel.StringText -> model.text
            is TextModel.ResourceText -> stringResource(id = model.textResourceId)
        },
        modifier = modifier,
        color = MaterialTheme.colorScheme.onSurface,
    )
}

@Composable
@DevicePreviews
@ThemePreviews
private fun NbaTextPreview(
    @PreviewParameter(provider = TextModelPreviewProvider::class) model: TextModel,
) {
    NbaTheme {
        NbaText(model = model)
    }
}
