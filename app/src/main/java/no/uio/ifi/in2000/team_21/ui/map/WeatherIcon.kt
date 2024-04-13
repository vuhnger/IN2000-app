package no.uio.ifi.in2000.team_21.ui.map

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil.compose.AsyncImage

@Composable
fun WeatherIcon(
    element: String
){
    AsyncImage(
        model = "https://raw.githubusercontent.com/metno/weathericons/main/weather/png/$element"
        ,contentDescription = "Icon of current weather."
    )
}