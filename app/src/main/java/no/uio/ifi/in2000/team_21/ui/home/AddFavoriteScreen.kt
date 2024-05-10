package no.uio.ifi.in2000.team_21.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import no.uio.ifi.in2000.team_21.ui.theme.Background
import no.uio.ifi.in2000.team_21.ui.theme.ContainerBlue

import no.uio.ifi.in2000.team_21.ui.theme.MidnightBlue

import no.uio.ifi.in2000.team_21.ui.viewmodels.ActivitiesViewModel
import no.uio.ifi.in2000.team_21.ui.viewmodels.ForecastViewModel
import no.uio.ifi.in2000.team_21.ui.home.ActivityCardHorizontalWide

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddFavoriteScreen(
    activitiesViewModel: ActivitiesViewModel,
    forecastViewModel: ForecastViewModel,
    navController: NavController
){
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Legg til Favoritt",
                        color = MidnightBlue
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.popBackStack()
                        }
                    ) {
                        Icon(
                            contentDescription = "Tilbake",
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                            tint = MidnightBlue,
                            modifier = Modifier
                                .size(30.dp)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(Background),
            )
        },
        containerColor = Background
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(16.dp)
                .padding(innerPadding)
        ) {
            Card(
                colors = CardDefaults.cardColors(ContainerBlue)
            ){
                Text(
                    text = "Legg til en aktivitet i dine favoritter for raskere tilgang. ",
                    color = MidnightBlue,
                    modifier = Modifier
                        .padding(5.dp)
                )
            }

            activitiesViewModel.activityUIstate.activities.forEach { activity ->
                // Denne komponenten tegner cards på favoritt-skjermen
                ActivityCardHorizontalWide(
                    activity = activity,
                    activitiesViewModel = activitiesViewModel,
                    navController = navController
                )
                //Spacer(modifier = Modifier.padding(8.dp))
            }
        }
    }
}