package no.uio.ifi.in2000.team_21.ui.home

import android.os.Bundle
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
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.sharp.Add
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import no.uio.ifi.in2000.team_21.R
import no.uio.ifi.in2000.team_21.Screen
import no.uio.ifi.in2000.team_21.model.ActivityModel

@Composable
fun ActivityCard(
    activity : ActivityModel,
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
                    text = activity.activityName,
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

                if (activity.imageId != null){
                    Image(
                        painter = painterResource(activity.imageId),
                        contentDescription = "Picture of ${activity.activityName}",
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(aspectRatio)
                    )
                }
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

                // TODO: Hente ikoner for i dag

                WeatherIcon(element = "fair_day", size = 30)
                Spacer(modifier = Modifier.width(4.dp))
                WeatherIcon(element = "cloudy", size = 30)
                Spacer(modifier = Modifier.width(4.dp))
                WeatherIcon(element = "clearsky_day", size = 30)
                Spacer(modifier = Modifier.width(4.dp))

            }
            Text(
                text = "", // TODO: bruke beregning fra modell
                fontSize = 8.sp,
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
    activity: ActivityModel,
    navController: NavController,
    activitiesViewModel: ActivitiesViewModel
){
    Card(
        modifier = Modifier
            .width(102.dp)
            .height(142.dp)
            .padding(start = 10.dp, top = 10.dp, end = 10.dp)
            .clickable {
                navController.navigate(
                    Screen.ActivityDetailScreen.withArgs(
                        activity.activityName
                    )
                )
            }
    ) {
        Column(

        ) {
            Text(
                text = activity.activityName
            )
            Icon(
                painter = painterResource(id = activity.icon),
                contentDescription = "Icon of ${activity.activityName}",
                modifier = Modifier
            )
        }
    }
}

@Composable
fun ActivityIconSmall(
    activity: ActivityModel,
    activitiesViewModel: ActivitiesViewModel
){
    //TODO : Make clickable and add to favorites
    Icon(
        painter = painterResource(id = activity.icon),
        contentDescription = "Icon of ${activity.activityName}",
        modifier = Modifier
            .padding(15.dp)
            //.shadow(5.dp)
            .clip(shape = RoundedCornerShape(15.dp, 15.dp))
    )
}

@Composable
fun ActivityCardHoriznotalWide(
    activity: ActivityModel,
    activitiesViewModel: ActivitiesViewModel
){
    Card(
    modifier = Modifier
        .fillMaxWidth()
        .padding(
            horizontal = 10.dp
        ),
        elevation = 10.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Icon(
                painter = painterResource(id = activity.icon),
                contentDescription = "",
                modifier = Modifier
                    .padding(horizontal = 10.dp)
            )

            Button(
                onClick = {
                    activitiesViewModel.addFavorite(activity)
                },
                colors = ButtonDefaults.buttonColors(
                    contentColor = MaterialTheme.colors.primary,
                    containerColor = MaterialTheme.colors.background
                )
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = ""
                )
            }
        }
    }
}

/*
* Lager Grid med aktiviteskort nedover, 2 og 2 per kolonne.
*/
@Composable
fun ActivityCardGrid(
    activities: List<ActivityModel>,
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
    activites: List<ActivityModel>,
    navController: NavController,
    activitiesViewModel: ActivitiesViewModel
){
    LazyHorizontalGrid(
        rows = GridCells.Fixed(1)
    ) {
        items(activites){activity ->
            ActivityCardSmall(
                activity,
                navController,
                activitiesViewModel = activitiesViewModel
            )
        }
    }
}

/*

*/
@Composable
fun ActivityCardGridHorizontalSmall(
    activitiesViewModel: ActivitiesViewModel
) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(1),
        modifier = Modifier
            .height(84.dp)
    ) {
        items(activitiesViewModel.activityUIstate.favorites){activity ->
            ActivityIconSmall(activity = activity, activitiesViewModel = activitiesViewModel)
        }
    }
}
