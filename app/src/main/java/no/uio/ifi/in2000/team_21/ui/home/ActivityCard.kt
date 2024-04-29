package no.uio.ifi.in2000.team_21.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.sharp.Add
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import no.uio.ifi.in2000.team_21.R
import no.uio.ifi.in2000.team_21.model.Activity
import no.uio.ifi.in2000.team_21.model.Kayaking

@Composable
fun ActivityCard(
    activity : Activity,
    viewModel: ActivitiesViewModel
) {
    val aspectRatio = 4f / 2f
    Card(
        modifier = Modifier
            .fillMaxWidth(0.5f)
            .padding(2.dp)
            .background(MaterialTheme.colors.background),
        elevation = 2.dp,
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier
                .background(Color.White)
        ) {

            Row(
                modifier = Modifier
                    .padding(5.dp)
            ) {
                Text(
                    text = activity.type,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .align(Alignment.CenterVertically)
                        .padding(10.dp)
                )
                Icon(
                    imageVector = Icons.Sharp.Add,
                    contentDescription = "Add Activity",
                    modifier = Modifier
                        .size(12.dp)
                        .align(Alignment.CenterVertically)
                        .fillMaxWidth(0.2f)
                        .clickable {
                            // TODO: Legg til aktivitet i favoritter
                            viewModel.addFavorite(activity)
                        }
                )
            }
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth(),
            ){
                Image(
                    painter = painterResource(id = activity.imageId),
                    contentDescription = "Picture of ${activity.type}",
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(aspectRatio)
                )
            }
            Text(
                text = "Forholdene i dag oppsummert: ",
                fontSize = 8.sp,
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(horizontal = 8.dp)
            ) {
                if (activity.icons.isNotEmpty()) {
                    activity.icons.forEach { icon ->
                        WeatherIcon(element = icon, size = 30)
                        Spacer(modifier = Modifier.width(4.dp))
                    }
                }else{ // TODO: Finne plassholder for ikoner
                    WeatherIcon(element = "fair_day", size = 30)
                    Spacer(modifier = Modifier.width(4.dp))
                    WeatherIcon(element = "cloudy", size = 30)
                    Spacer(modifier = Modifier.width(4.dp))
                    WeatherIcon(element = "clearsky_day", size = 30)
                    Spacer(modifier = Modifier.width(4.dp))
                }
            }
            Text(
                text = "I dag er forholdene ${activity.isReccomended()} for ${activity.type.lowercase()}.",
                fontSize = 8.sp, // Halved font size
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            )
            Row(
                horizontalArrangement = Arrangement.Absolute.Right,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Button(
                    onClick = {
                        //TODO: håndter start aktivitet. -> Logge aktiviteten?

                    },
                    modifier = Modifier
                        .padding(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colors.primary
                    )
                ) {
                    Text(
                        text = "Start",
                        fontSize = 12.sp
                    )
                }
            }
        }
    }
}

@Composable
fun ActivityCardSmall(
    activity: Activity = Kayaking(
        air_temperature = 10.0,
        air_temperature_unit = R.string.celsius.toString(),
        sea_water_temperature = 2.0,
        sea_water_temperature_unit = "celsius",
        sea_water_speed = 3.0,
        sea_surface_wave_height = 0.5
    )
){
    Card(
        modifier = Modifier
            .width(102.dp)
            .height(142.dp)
            .padding(start = 10.dp, top = 10.dp, end = 10.dp)
    ) {

    }
}

@Composable
fun ActivityIconSmall(
    activity: Activity = Kayaking(
        air_temperature = 10.0,
        air_temperature_unit = R.string.celsius.toString(),
        sea_water_temperature = 2.0,
        sea_water_temperature_unit = "celsius",
        sea_water_speed = 3.0,
        sea_surface_wave_height = 0.5
    )
){
    Icon(
        imageVector = Icons.Rounded.AccountCircle,
        contentDescription = "",
        modifier = Modifier
            .clickable {  }
    )
}

@Composable
fun ActivityCardHoriznotalWide(
    activity: Activity
){
    Card(

    ) {
        Row(

        ) {
            // TODO: Icon
            // TODO: Fav button icon clickable
        }
    }
}

/*
* Lager Grid med aktiviteskort nedover, 2 og 2 per kolonne.
*/
@Composable
fun ActivityCardGrid(
    activities: List<Activity>,
    activitiesViewModel: ActivitiesViewModel
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.padding(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(activities) { activity ->
            ActivityCard(activity = activity, viewModel = activitiesViewModel)
        }
    }
}

/*

*/
@Composable
fun ActivityCardGridHorizontal(
    activites: List<Activity>
){
    LazyHorizontalGrid(
        rows = GridCells.Fixed(1)
    ) {
        items(activites){activity ->
            ActivityCardSmall(activity)
        }
    }
}

/*

*/
@Composable
fun ActivityCardGridHorizontalSmall(
    activities: List<Activity>
) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(1)
    ) {
        items(activities){activity ->

        }
    }
}
