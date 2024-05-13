package no.uio.ifi.in2000.team_21.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import no.uio.ifi.in2000.team_21.ui.theme.Background
import no.uio.ifi.in2000.team_21.ui.theme.ContainerBlue

import no.uio.ifi.in2000.team_21.ui.theme.MidnightBlue

import no.uio.ifi.in2000.team_21.ui.viewmodels.ActivitiesViewModel
import no.uio.ifi.in2000.team_21.ui.viewmodels.ForecastViewModel
import no.uio.ifi.in2000.team_21.ui.home.ActivityCardHorizontalWide

@Composable
fun AddFavoriteScreen(
    activitiesViewModel: ActivitiesViewModel,
    forecastViewModel: ForecastViewModel,
    navController: NavController
){
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Button(
            onClick = { navController.popBackStack() },
            colors = ButtonDefaults.buttonColors(
                containerColor = ContainerBlue,
                contentColor = MidnightBlue
            )
        ) {
            Text(text = "Tilbake")
        }

        Card(
            colors = CardColors(
                containerColor = ContainerBlue,
                contentColor = MidnightBlue,
                disabledContainerColor = Color.Gray,
                disabledContentColor = Color.Gray
            )
        ) {
            Text(
                text = "Legg til en aktivitet i dine favoritter for raskere tilgang. ",
                color = MidnightBlue
            )
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Background)
        ) {

            items(activitiesViewModel.activityUIstate.activities){activity ->
                // Denne komponenten tegner cards på favoritt-skjermen
                ActivityCardHorizontalWide(
                    activity = activity,
                    activitiesViewModel = activitiesViewModel,
                    navController = navController
                )
                Spacer(modifier = Modifier.padding(8.dp))

            }


        }




    }


}