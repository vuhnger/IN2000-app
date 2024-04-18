package no.uio.ifi.in2000.team_21.ui.home

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
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
fun HomeScreen(navController: NavController) {
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
    }
}