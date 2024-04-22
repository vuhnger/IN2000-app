package no.uio.ifi.in2000.team_21.ui.home

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun WeatherIcon(
    element: String?
){
    Box (
        modifier = Modifier
            .clip(CircleShape)
            .padding(4.dp)
    ){
        AsyncImage(
            model = "https://raw.githubusercontent.com/metno/weathericons/main/weather/png/$element.png",
            contentDescription = "Icon of current weather."
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

@Composable
fun drawImages(
    viewModel: ForecastViewModel = ForecastViewModel()
) {

    Log.d("IMAGE_LIST", "drawing ${viewModel.icons.size} images")
    ImageList(imageUrlList = viewModel.icons)

    LaunchedEffect(key1 = viewModel) {
        // Launch an effect when the ViewModel changes
        viewModel.fetchIcons()
    }
}