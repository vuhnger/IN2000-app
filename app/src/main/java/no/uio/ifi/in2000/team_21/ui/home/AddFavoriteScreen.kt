package no.uio.ifi.in2000.team_21.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import no.uio.ifi.in2000.team_21.data.database.ActivityEntity
import no.uio.ifi.in2000.team_21.ui.theme.Background
import no.uio.ifi.in2000.team_21.ui.theme.HomeCard


@Composable
fun AddFavoriteScreen(
    activitiesViewModel: ActivitiesViewModel,
    navController: NavController
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Background)
    ) {
        Button(
            onClick = { navController.popBackStack() },
            colors = ButtonDefaults.buttonColors(
                containerColor = Background,
                contentColor = MaterialTheme.colorScheme.primary
            )
        ) {
            Text(text = "Tilbake")
        }
        activitiesViewModel.activityUIstate.activities.forEach {
                activity -> 
            ActivityCardHoriznotalWide(
                activity = activity,
                activitiesViewModel = activitiesViewModel
            )
            Spacer(modifier = Modifier.padding(8.dp))
        }
    }
}