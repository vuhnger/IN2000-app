package no.uio.ifi.in2000.team_21.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import no.uio.ifi.in2000.team_21.model.ActivityModel
import no.uio.ifi.in2000.team_21.R
import no.uio.ifi.in2000.team_21.Screen
import no.uio.ifi.in2000.team_21.model.ConditionStatus


@Composable
fun AllActivitiesScreen(navController: NavController ,viewModel: ActivityConditionCheckerViewModel = ActivityConditionCheckerViewModel()) {
    val activities by viewModel.activities.observeAsState(initial = emptyList())

    LazyColumn(modifier = Modifier.padding(16.dp)) {
        items(activities) { activity ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                shape = RoundedCornerShape(16.dp),
                backgroundColor = Color(0xFFBCCBFF)
            ) {
                ActivityListItem(activity = activity)
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun ActivityListItem(activity: ActivityModel) {
    Box(modifier = Modifier.padding(16.dp)) {
        Column {
            // Legg til icon bilde av aktiviteten
            Text(text = activity.activityName, color = Color(0xFF49454F)) // Hvit text
            Text(getActivityConditionText(activity.conditionStatus, activity.activityName))
        }
        Image(
            painter = painterResource(id = activity.getFlagColorId()),
            contentDescription = "Condition Status",
            modifier = Modifier.align(Alignment.TopEnd)
        )
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
            checkActivityConditions("2024-05-03T17:00:00Z", 70.081729131417404, 13.424095397874112)

        }
    }

    AllActivitiesScreen(navController = navController, viewModel = mockViewModel)
}
