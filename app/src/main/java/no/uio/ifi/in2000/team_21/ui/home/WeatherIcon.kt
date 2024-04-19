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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage


// element: Tekststreng som sendes med i responsen fra locationforecast
@Composable
fun WeatherIcon(
    element: String?,
    size: Int = 50 // Default size parameter allows specification of image size.
){
    Box(
        modifier = Modifier
            .size(size.dp) // Set the size of the box to the passed size, ensuring the entire container scales.
            .clip(CircleShape)
            .padding(4.dp)
    ){
        AsyncImage(
            model = "https://raw.githubusercontent.com/metno/weathericons/main/weather/png/$element.png",
            contentDescription = "Icon of current weather state.",
            contentScale = ContentScale.FillBounds, // Ensures the image fills the bounds of the container.
            modifier = Modifier
                .fillMaxSize() // Ensure the image fills the Box.
        )
    }
}


@Composable
fun ImageList(
    modifier: Modifier = Modifier,
    imageUrlList: List<String>?,
) {
    if (imageUrlList != null) {
        LazyRow { // Set max width
            items(imageUrlList) { image ->
                WeatherIcon(
                    element = image
                )
            }
        }
    } else {
        Log.d("IMAGE_LIST", "icons list was null")
    }
}