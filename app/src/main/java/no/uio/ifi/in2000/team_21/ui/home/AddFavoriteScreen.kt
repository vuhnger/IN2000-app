package no.uio.ifi.in2000.team_21.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun AddFavoriteScreen(
    activitiesViewModel: ActivitiesViewModel,
    forecastViewModel: ForecastViewModel,
    navController: NavController
){

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Button(
            onClick = { navController.popBackStack() },
            colors = ButtonDefaults.buttonColors(
                contentColor = MaterialTheme.colors.primary,
                containerColor = MaterialTheme.colors.background
            )
        ) {
            Text(text = "Tilbake")
        }
        activitiesViewModel.activityUIstate.activities.forEach {
                activity ->
            ActivityCardHorizontalWide(
                activity = activity,
                activitiesViewModel = activitiesViewModel
            )
            Spacer(modifier = Modifier.padding(8.dp))
        }
    }

/*

  ActivityCardGrid(
        forecastViewModel = forecastViewModel,
        activitiesViewModel = activitiesViewModel
    )


* */


}