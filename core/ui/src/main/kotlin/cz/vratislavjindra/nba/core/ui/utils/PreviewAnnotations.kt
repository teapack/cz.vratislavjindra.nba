package cz.vratislavjindra.nba.core.ui.utils

import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Preview

@Preview(
    name = "Light Mode",
    group = GROUP_THEMES,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    showBackground = true,
)
@Preview(
    name = "Dark Mode",
    group = GROUP_THEMES,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
)
annotation class ThemePreviews

@Preview(
    name = "Phone",
    group = GROUP_DEVICES,
    device = "spec:width=411dp,height=891dp",
)
@Preview(
    name = "Tablet",
    group = GROUP_DEVICES,
    device = "spec:width=1280dp,height=800dp,orientation=landscape",
)
annotation class DevicePreviews

private const val GROUP_DEVICES = "Devices"
private const val GROUP_THEMES = "Themes"
