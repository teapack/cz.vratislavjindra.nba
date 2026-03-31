package cz.vratislavjindra.nba.core.ui.component.text

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

internal class TextModelPreviewProvider : PreviewParameterProvider<TextModel> {

    override val values: Sequence<TextModel>
        get() = sequenceOf(
            TextModel.StringText(text = "String text"),
            TextModel.ResourceText(textResourceId = android.R.string.ok),
        )
}
