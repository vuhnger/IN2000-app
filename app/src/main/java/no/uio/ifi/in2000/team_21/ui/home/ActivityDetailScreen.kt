package no.uio.ifi.in2000.team_21.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material3.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import no.uio.ifi.in2000.team_21.model.activity.ActivityModel
import no.uio.ifi.in2000.team_21.model.activity.ActivityModels

@Composable
fun ActivityDetailScreen(
    activitiesViewModel: ActivitiesViewModel,
    activityName : String?,
    navController: NavController
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {

        val activity: ActivityModel = ActivityModels.find(
            activityName ?: ""
        ) ?: ActivityModels.FISHING

        Image(
            painter = painterResource(activity.imageId),
            contentDescription = "Image of ${activity.activityName}",
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(4f / 2f),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.padding(16.dp))

        Row(
           modifier = Modifier
               .fillMaxWidth()
               .padding(horizontal = 8.dp)
        ){

            val buttonSize: Dp = 48.dp

            Button(
                onClick = { navController.popBackStack() },
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colors.background,
                    contentColor = MaterialTheme.colors.primary
                ),
                modifier = Modifier
                    .width(20.dp)
                    .weight(1f)
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                    contentDescription = "Tilbakeknapp til hjemskjerm.",
                    modifier = Modifier
                )
            }

            Button(
                onClick = { /*TODO pop up vindu med sliders*/ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colors.background,
                    contentColor = MaterialTheme.colors.primary
                ),
                modifier = Modifier
                    .weight(1f)
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.List,
                    contentDescription = "Knapp for å endre værnivåer."
                )
            }
        }

        Spacer(modifier = Modifier.padding(vertical = 16.dp))

        Text(
            text = activity.activityName,
            style = TextStyle(
                fontSize = 20.sp,
                lineHeight = 20.sp,
                //fontFamily = FontFamily(Font(R.font.roboto)),
                fontWeight = FontWeight(400),
                color = androidx.compose.material3.MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center,
                letterSpacing = 0.1.sp,
            ),
            modifier = Modifier
                .weight(0.5f)
        )

        //Beregning av forhold
        Text(
            text = "Forholdene er nå: "
        )

        // Info om aktivitet

        // Info om beregning

        // Startknapp med logging

        Row(

        ) {
            Button(
                onClick = { /*TODO logg startet aktivitet på tidspunkt*/ }
            ) {
                Text(
                    text = "Start aktivitet"
                )
            }
        }

    }
}

@Composable
fun SliderScreen(
    activity: ActivityModel
){
    // TODO: sliders for temp osv, må faktisk endre objektet
}