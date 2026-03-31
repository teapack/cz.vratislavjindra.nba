package cz.vratislavjindra.nba.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.Help
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import cz.vratislavjindra.nba.core.ui.component.navigationcard.NavigationCardModel
import cz.vratislavjindra.nba.core.ui.component.navigationcard.NbaNavigationCard
import cz.vratislavjindra.nba.core.ui.component.text.TextModel
import cz.vratislavjindra.nba.core.ui.component.topappbar.NbaTopAppBar
import cz.vratislavjindra.nba.core.ui.component.topappbar.TopAppBarModel
import cz.vratislavjindra.nba.core.ui.theme.CardShape
import cz.vratislavjindra.nba.core.ui.theme.NbaTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NbaTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        NbaTopAppBar(
                            model = TopAppBarModel(title = "NBA App"),
                        )
                    },
                    containerColor = MaterialTheme.colorScheme.background,
                ) { innerPadding ->
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = innerPadding,
                    ) {
                        items(count = 100) { index ->
                            NbaNavigationCard(
                                model = NavigationCardModel(
                                    leadingImage = NavigationCardModel.Image.Vector(
                                        contentDescription = TextModel.StringText(text = "Help icon"),
                                        imageVector = Icons.AutoMirrored.Rounded.Help,
                                    ),
                                    title = "Title $index",
                                    description = "Description $index",
                                    cardShape = when (index) {
                                        0 -> CardShape.ROUNDED_CORNER_TOP
                                        99 -> CardShape.ROUNDED_CORNER_BOTTOM
                                        else -> CardShape.ROUNDED_CORNER_NONE
                                    },
                                    onClick = {
                                        // TODO: Handle click
                                    },
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}
