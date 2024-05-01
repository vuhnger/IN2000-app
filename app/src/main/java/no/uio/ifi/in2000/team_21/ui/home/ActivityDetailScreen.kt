package no.uio.ifi.in2000.team_21.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import no.uio.ifi.in2000.team_21.R
import no.uio.ifi.in2000.team_21.model.ActivityModel

@Composable
fun ActivityDetailScreen(
    activitiesViewModel: ActivitiesViewModel,
    activity : ActivityModel,
    navController: NavController
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {

        Image(
            painter = painterResource(activity.imageId),
            contentDescription = "Image of ${activity.activityName}",
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.padding(16.dp))

        Row(
           modifier = Modifier
               .fillMaxWidth()
        ){

            Button(
                onClick = { navController.popBackStack() }
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                    contentDescription = "Tilbakeknapp til hjemskjerm."
                )
            }

            Button(
                onClick = { /*TODO pop up vindu med sliders*/ }
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.List,
                    contentDescription = "Knapp for å endre værnivåer."
                )
            }
        }

        // Overskrift

        //Beregning av forhold

        // Info om aktivitet

        // Info om beregning

        // Startknapp med logging

    }
}

@Composable
fun SliderScreen(
    activity: ActivityModel
){
    // TODO: sliders for temp osv, må faktisk endre objektet
}