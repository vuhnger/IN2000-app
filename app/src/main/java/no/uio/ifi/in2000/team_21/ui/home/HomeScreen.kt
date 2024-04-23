package no.uio.ifi.in2000.team_21.ui.home
import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

// Top bar implementation: to work as one component to be used through all the screens.
// Dataclass to define each tab in the navbar
data class TopNavItem(val title: String, val icon: @Composable (() -> Unit)? = null)


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    items : List<TopNavItem>,
    currentSelection: Int,
    onItemSelected: (Int) -> Unit

) {
    var presses by remember { mutableIntStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("Hjem")
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { presses++ }) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Text(
                modifier = Modifier.padding(8.dp),
                text =
                """
                    This is an example of a scaffold. It uses the Scaffold composable's parameters to create a screen with a simple top app bar, bottom app bar, and floating action button.

                    It also contains some basic inner content, such as this text.

                    You have pressed the floating action button $presses times.
                """.trimIndent(),
            )
        }
    }
}

    
@Composable
fun RowScope.TopBarItem(item: TopNavItem, isSelected: Boolean, onItemSelect: () -> Unit) {
    Tab(
        selected = isSelected,
        onClick = onItemSelect,
        text = { Text(item.title) },
        icon = item.icon
    )
}

@Composable
fun WeatherCard(temperature: String, highLowTemp: String, weatherCondition: String) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column (
            modifier = Modifier
            .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Min posisjon", style = MaterialTheme.typography.headlineMedium )
            Spacer(Modifier.height(4.dp))
            Text("Oslo", style = MaterialTheme.typography.labelSmall)
            Spacer(Modifier.height(16.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                /*Icon(/* ... */) */
                 Text(temperature, style = MaterialTheme.typography.labelLarge)
            }
            Spacer(Modifier.height(4.dp))
            Text(weatherCondition, style = MaterialTheme.typography.labelSmall)
            Spacer(Modifier.height(4.dp))
            Text(highLowTemp, style = MaterialTheme.typography.labelSmall)
        }
    }
}

@Composable
fun ActivityFavorites(activities: List<Activity>) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text("Favoritter", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(8.dp))
        Row(horizontalArrangement = Arrangement.SpaceBetween) {
            activities.forEach {activity ->
                ActivityIcon(activity)
            }
        }
    }
}
@Composable
fun ActivityIcon(activity: Activity) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        /*Icon(/* ... */) */
        /*Text(activity.name)*/
        Text("Aktivitet")

    }
}
@Composable
fun RecommendationSection(recommendations: List<Activity>) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text("Anbefaling", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(8.dp))
        LazyRow {
            this.items(recommendations){ recommendation ->
                ActivityCard(recommendation)
            }
            }
        }
    }
@Composable
fun ActivityCard(activity: Activity) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .width(120.dp)
            .height(120.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        // Activity card logic.
    }
}

@Composable
fun HomeScreen(navController: NavController) {
    //TopBar(items = TopNavItem<items>, currentSelection = 1 ) {}


    Column(
        modifier = Modifier
            .width(360.dp)
            .height(50.dp)
            .background(color = Color(0xFFF7F8FF))
    ) {
        Text(text = "Hjem")
        Text(text = "Kart")

        WeatherCard(
            temperature = "14°",
            highLowTemp = "H:16° L:3°",
            weatherCondition = "Skyfritt"
        )
        ActivityFavorites(activities = listOf())
        RecommendationSection(recommendations = listOf())
    }
}
