package no.uio.ifi.in2000.team_21.ui.home

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import no.uio.ifi.in2000.team_21.Screen
import no.uio.ifi.in2000.team_21.model.activity.ActivityModel
import no.uio.ifi.in2000.team_21.model.activity.ConditionStatus
import no.uio.ifi.in2000.team_21.ui.theme.Background
import no.uio.ifi.in2000.team_21.ui.theme.ContainerBlue
import no.uio.ifi.in2000.team_21.ui.theme.MidnightBlue
import no.uio.ifi.in2000.team_21.ui.viewmodels.ActivityConditionCheckerViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AllActivitiesScreen(
    navController: NavController,
    activityConditionCheckerViewModel: ActivityConditionCheckerViewModel
) {
    val activities by activityConditionCheckerViewModel.activities.observeAsState(initial = emptyList())
    Log.d("All_Activites_screen", "Activites: $activities")

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    androidx.compose.material3.Text(
                        "Alle aktiviteter",
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
        LazyColumn(
            modifier = Modifier
                .padding(16.dp)
                .padding(innerPadding)
        ) {
            items(activities) { activity ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .clickable {
                            navController.navigate(
                                Screen.ActivityDetailScreen.withArgs(
                                    activity.activityName
                                )
                            )
                        },
                    //elevation = CardDefaults.cardElevation(10.dp),
                    shape = RoundedCornerShape(16.dp),
                    backgroundColor = ContainerBlue,
                    border = BorderStroke(1.dp, MidnightBlue),
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        Column{
                            val id = when (activity.activityName){
                                "Kajakk" -> no.uio.ifi.in2000.team_21.R.drawable.kayaking_dark
                                "Fisking" -> no.uio.ifi.in2000.team_21.R.drawable.fishing_icon
                                "Seiling" -> no.uio.ifi.in2000.team_21.R.drawable.sailing_icon
                                "Roing" -> no.uio.ifi.in2000.team_21.R.drawable.final_rowing
                                "Padling" -> no.uio.ifi.in2000.team_21.R.drawable.rowing_icon
                                "Surfing" -> no.uio.ifi.in2000.team_21.R.drawable.surfing_dark
                                "Snorkle" -> no.uio.ifi.in2000.team_21.R.drawable.scuba_dark
                                "Svømme" -> no.uio.ifi.in2000.team_21.R.drawable.swimming_dark
                                "Vannski" -> no.uio.ifi.in2000.team_21.R.drawable.waterski_icon
                                else -> null
                            }
                            id?.let { painterResource(it) }
                                ?.let { Icon(painter = it, contentDescription = "ikon", tint = MidnightBlue) }
                            Text(text = activity.activityName, color = MidnightBlue)
                            ActivityListItem(activity = activity)
                        }
                    }
                    //ActivityListItem(activity = activity)
                }
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
fun ActivityListItem(activity: ActivityModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(getActivityConditionText(activity.conditionStatus, activity.activityName), color = MidnightBlue)
        }
    }
}

fun getActivityConditionText(conditionStatus: ConditionStatus, activityName: String): String {
    return when (conditionStatus) {
        ConditionStatus.ALL_MET -> "Nå er det optimale forhold for $activityName"
        ConditionStatus.SOME_MET -> "Noen forhold er oppfylt for $activityName"
        ConditionStatus.NONE_MET -> "Ingen forhold er oppfylt for $activityName"
    }
}

@Preview
@Composable
fun PreviewAllActivitiesScreen() {
    val navController = rememberNavController()

    val mockViewModel = object : ActivityConditionCheckerViewModel() {
        init {
            checkActivityConditions("2024-05-06T20", 59.0, 10.0)
        }
    }
    AllActivitiesScreen(navController = navController, activityConditionCheckerViewModel = mockViewModel)
}
