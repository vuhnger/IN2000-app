package no.uio.ifi.in2000.team_21.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
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
                activity -> Icon(
                    painter = painterResource(id = activity.icon),
                    contentDescription = "",
                    modifier = Modifier
                        .clickable {
                            activitiesViewModel.addFavorite(activity)
                        }
                )
        }
    }
}