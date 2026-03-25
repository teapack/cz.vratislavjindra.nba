package cz.vratislavjindra.nba.core.ui.component.topappbar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.PreviewParameter
import cz.vratislavjindra.nba.core.ui.R
import cz.vratislavjindra.nba.core.ui.theme.NbaTheme
import cz.vratislavjindra.nba.core.ui.theme.Theme
import cz.vratislavjindra.nba.core.ui.utils.DevicePreviews
import cz.vratislavjindra.nba.core.ui.utils.ThemePreviews
import cz.vratislavjindra.nba.core.ui.utils.applyTonalElevation

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun NbaTopAppBar(
    model: TopAppBarModel,
    modifier: Modifier = Modifier,
) {
    TopAppBar(
        title = {
            Text(
                text = model.title,
                color = MaterialTheme.colorScheme.onSurface,
                overflow = TextOverflow.Ellipsis,
                maxLines = NbaTopAppBarDefaults.TITLE_MAX_LINES,
                style = MaterialTheme.typography.titleLarge,
            )
        },
        modifier = modifier,
        navigationIcon = {
            model.upNavigationAction?.let { upNavigationAction ->
                AppBarButton(
                    action = TopAppBarModel.TopAppBarAction(
                        icon = Icons.AutoMirrored.Rounded.ArrowBack,
                        contentDescription = stringResource(id = R.string.content_description_button_navigate_up),
                        onClick = upNavigationAction,
                    ),
                )
            }
        },
        actions = {
            model.actions.forEach { action ->
                AppBarButton(action = action)
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme
                .applyTonalElevation(
                    backgroundColor = MaterialTheme.colorScheme.surface,
                    elevation = Theme.dimensions.elevationDefault,
                )
                .copy(alpha = NbaTopAppBarDefaults.ALPHA),
        ),
    )
}

@Composable
private fun AppBarButton(action: TopAppBarModel.TopAppBarAction) {
    IconButton(onClick = action.onClick) {
        Icon(
            imageVector = action.icon,
            contentDescription = action.contentDescription,
            tint = MaterialTheme.colorScheme.onSurface,
        )
    }
}

@Composable
@DevicePreviews
@ThemePreviews
private fun NbaTopAppBarPreview(@PreviewParameter(provider = TopAppBarMockData::class) model: TopAppBarModel) {
    NbaTheme {
        NbaTopAppBar(model = model)
    }
}

private object NbaTopAppBarDefaults {

    const val ALPHA = 0.9f
    const val TITLE_MAX_LINES = 1
}
