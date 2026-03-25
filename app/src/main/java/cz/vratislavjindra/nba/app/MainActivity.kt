package cz.vratislavjindra.nba.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cz.vratislavjindra.nba.core.ui.component.topappbar.NbaTopAppBar
import cz.vratislavjindra.nba.core.ui.component.topappbar.TopAppBarModel
import cz.vratislavjindra.nba.core.ui.theme.NbaTheme
import cz.vratislavjindra.nba.core.ui.theme.Theme
import cz.vratislavjindra.nba.core.ui.utils.DevicePreviews
import cz.vratislavjindra.nba.core.ui.utils.ThemePreviews
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
                ) { innerPadding ->
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = innerPadding,
                    ) {
                        items(count = 100) { index ->
                            Greeting(name = "Android $index")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(
    name: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = "Hello $name!",
        modifier = modifier
            .fillMaxWidth()
            .padding(all = Theme.dimensions.paddingDefault),
    )
}

@Composable
@DevicePreviews
@ThemePreviews
fun GreetingPreview() {
    NbaTheme {
        Greeting(name = "Android")
    }
}
