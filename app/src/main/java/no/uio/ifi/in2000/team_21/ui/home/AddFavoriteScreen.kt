package no.uio.ifi.in2000.team_21.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController


@Composable
fun AddFavoriteScreen(
    activitiesViewModel: ActivitiesViewModel,
    navController: NavController
){
    Column(
        
    ) {
        Button(onClick = { navController.popBackStack() }) {
            Text(text = "Tilbake")
        }
        activitiesViewModel.activityUIstate.activities.forEach {
                activity -> ActivityIconSmall(
                    activity = activity,
                    activitiesViewModel = activitiesViewModel
                )
        }
    }
}