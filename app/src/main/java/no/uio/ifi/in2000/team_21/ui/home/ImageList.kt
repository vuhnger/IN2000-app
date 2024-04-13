package no.uio.ifi.in2000.team_21.ui.home

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import no.uio.ifi.in2000.team_21.ui.map.WeatherIcon
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items


@Composable
fun ImageList(
    modifier: Modifier = Modifier,
    imageUrlList: List<String>?,
) {
    if (imageUrlList != null) {
        LazyRow { // Set max width
            items(imageUrlList) { image ->
                WeatherIcon(
                    element = "$image.png"
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