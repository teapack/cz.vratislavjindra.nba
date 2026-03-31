package cz.vratislavjindra.nba.core.ui.component.text

import androidx.annotation.StringRes

sealed interface TextModel {

    data class StringText(val text: String) : TextModel
    data class ResourceText(@param:StringRes val textResourceId: Int) : TextModel
}
