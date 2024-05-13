package no.uio.ifi.in2000.team_21.ui.home

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage


// element: Tekststreng som sendes med i responsen fra locationforecast
@Composable
fun WeatherIcon(
    element: String?,
    size: Int = 50
){
    Box(
        modifier = Modifier
            .size(size.dp)
            .clip(CircleShape)
            .padding(8.dp)
    ){
        AsyncImage(
            model = "https://raw.githubusercontent.com/metno/weathericons/main/weather/png/$element.png",
            contentDescription = "Icon of current weather state.",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxSize()
                .scale(1.5f)
        )
    }
}