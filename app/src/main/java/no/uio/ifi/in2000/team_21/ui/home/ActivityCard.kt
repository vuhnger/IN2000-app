package no.uio.ifi.in2000.team_21.ui.home

// import androidx.compose.material.MaterialTheme
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import no.uio.ifi.in2000.team_21.Screen
import no.uio.ifi.in2000.team_21.model.activity.ActivityModel
import no.uio.ifi.in2000.team_21.ui.theme.Background
import no.uio.ifi.in2000.team_21.ui.theme.ContainerBlue
import no.uio.ifi.in2000.team_21.ui.theme.MidnightBlue
import no.uio.ifi.in2000.team_21.ui.viewmodels.ActivitiesViewModel


// Kortene som ligger under Anbefaling seksjonen
@Composable
fun ActivityCardSmall(
    activity: ActivityModel,
    navController: NavController
){
    Card(
        modifier = Modifier
            .width(150.dp)
            .height(260.dp)
            .padding(start = 10.dp, top = 20.dp, end = 10.dp)
            .clickable {
                navController.navigate(
                    Screen.ActivityDetailScreen.withArgs(
                        activity.activityName
                    )
                )
            },
        elevation = CardDefaults.cardElevation(2.dp),
        colors = CardDefaults.cardColors(containerColor = ContainerBlue)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(5.dp)
                .fillMaxSize()
        ) {
            
            Spacer(modifier = Modifier.padding(top = 16.dp))

            Text(
                text = activity.activityName,
                modifier = Modifier.weight(1f),
                style = TextStyle(
                    color = MidnightBlue,
                    fontSize = 20.sp
                )
            )

            Spacer(modifier = Modifier.padding(5.dp))

            Image(
                painter = painterResource(id = activity.imageId),
                contentDescription = "",
                modifier = Modifier
                    .padding(start = 10.dp, end = 10.dp, bottom = 16.dp)
                    .clip(RoundedCornerShape(size = 16.dp))
                    .scale(1.5f)
            )
        }
    }
}

@Composable
fun ActivityIconSmall(
    activity: ActivityModel,
    activitiesViewModel: ActivitiesViewModel,
    navController: NavController
) {
    Box(
        modifier = Modifier
            .height(80.dp)
    ) {
        Icon(
            painter = painterResource(id = activity.icon),
            contentDescription = "Icon of ${activity.activityName}",
            modifier = Modifier
                .padding(start = 15.dp)
                .background(
                    color = ContainerBlue,
                    shape = CircleShape
                ) // Endre bakgrunnsfarge til hvit og bruk sirkel som form
                .clip(CircleShape) // Klipper ikonet til en sirkelform
                //.border(2.dp, Color.Gray, CircleShape) // Legger til en tynn grå border rundt ikonet
                .padding(25.dp) // Justering for å beholde plassering og størrelse
                .scale(2f)
                .clickable {
                    navController.navigate(
                        Screen.ActivityDetailScreen.withArgs(
                            activity.activityName
                        )
                    )
                },
            tint = MidnightBlue
        )
        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = activity.activityName,
            maxLines = 1,
            fontSize = 20.sp,
            color = MidnightBlue,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(Alignment.Center)
                .offset(y = 38.dp)
                .padding(10.dp)
        )


    }
}

@Composable
fun ActivityCardHorizontalWide(
    activity: ActivityModel,
    activitiesViewModel: ActivitiesViewModel,
    navController: NavController
){

    val isFavorite by activitiesViewModel.isFavorite(activity.activityName).observeAsState(false)

    var icon = if (isFavorite) true else false

    Card(
        colors = CardDefaults.cardColors(containerColor = ContainerBlue),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(1.dp, MidnightBlue),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp)
            .height(100.dp)
    ) {

        Log.d(
            "HORIZONTAL_ACTIVITY_CARD",
            "initiated with activity: $activity, found in favorites: ${activity in activitiesViewModel.activityUIstate.favorites}"
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = ContainerBlue)
        ) {
            ActivityIconSmall(
                activity = activity,
                activitiesViewModel = activitiesViewModel,
                navController = navController
            )

            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = {
                    if (activitiesViewModel.favorites.value?.any { it.name == activity.activityName } == true) {
                        activitiesViewModel.removeFavorite(activity.activityName)
                        icon = false
                    } else {
                        activitiesViewModel.addFavorite(activity)
                        icon = true
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    contentColor = MidnightBlue,
                    containerColor = ContainerBlue
                ),
                modifier = Modifier
                    .width(80.dp)
            ) {
                Star(icon)
            }



        }
    }
}

@Composable
fun Star(icon: Boolean) {
    if (icon) {
        Icon(
            painter = painterResource(id = no.uio.ifi.in2000.team_21.R.drawable.baseline_star_24),
            contentDescription = "full stjerne",
            tint = MidnightBlue,
            modifier = Modifier
                .scale(1.5f)
        )
    }
    else {
        Icon(
            painter = painterResource(id = no.uio.ifi.in2000.team_21.R.drawable.baseline_star_outline_24),
            contentDescription = "Settings icon",
            tint = MidnightBlue,
            modifier = Modifier
                .scale(1.5f)
        )
    }
}
@Composable
fun ActivityIconGridHorizontalSmall(
    activitiesViewModel: ActivitiesViewModel,
    navController: NavController
) {
    val favorites = activitiesViewModel.favorites.observeAsState(initial = emptyList())
    if (favorites.value.isEmpty()) {
        Card(
            colors = CardDefaults.cardColors(ContainerBlue),
            modifier = Modifier
                .padding(start = 8.dp, bottom = 8.dp, end = 8.dp)
        ) {
            Text(
                text = "Legg til favorittaktiviteter ved å trykke på +",
                color = MidnightBlue,

                )
        }
    } else {
        LazyRow(
            modifier = Modifier
                .height(84.dp)
                .padding(start = 16.dp)
        ) {
            items(favorites.value) { activityEntity ->
                val activityModel = activitiesViewModel.getActivityModelByName(activityEntity.name)
                activityModel?.let { model ->
                    ActivityIconSmall(
                        activity = model,
                        activitiesViewModel = activitiesViewModel,
                        navController = navController
                    )
                }
            }
        }
    }
}


