package no.uio.ifi.in2000.team_21.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.AlertDialog
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import no.uio.ifi.in2000.team_21.model.activity.ActivityModels
import no.uio.ifi.in2000.team_21.ui.theme.Background
import no.uio.ifi.in2000.team_21.ui.theme.ContainerBlue
import no.uio.ifi.in2000.team_21.ui.theme.MidnightBlue
import no.uio.ifi.in2000.team_21.ui.viewmodels.ActivitiesViewModel
import no.uio.ifi.in2000.team_21.ui.viewmodels.ActivityConditionCheckerViewModel
import no.uio.ifi.in2000.team_21.ui.viewmodels.UserViewModel
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter


@Composable
fun ActivityDetailScreen(
    activitiesViewModel: ActivitiesViewModel,
    activityConditionCheckerViewModel: ActivityConditionCheckerViewModel,
    userViewModel: UserViewModel,
    activityName: String?,
    navController: NavController
) {
    val currentUser by userViewModel.currentUser.observeAsState()


    Column(
        modifier = Modifier
            .fillMaxSize() // Fill entire screen (improves layout)
            .background(Background)
    ) {
        val activity = activityConditionCheckerViewModel.get(
            activityName = activityName ?: ""
        ) ?: ActivityModels.FISHING

        var showDialog by remember{
            mutableStateOf(false)
        }

        if (showDialog){
            AlertDialog(
                onDismissRequest = {
                    showDialog = false
                    navController.popBackStack()
                },
                title = { Text(text = "Aktivitet loggført!")},
                text = { Text(text = "Du finner denne i historikk.")},
                buttons = {
                    Button(onClick = {
                        showDialog = false
                        navController.popBackStack()
                    }) {
                        Text(text = "Lukk")
                    }
                }
            )
        }

        Image(
            painter = painterResource(activity.imageId),
            contentDescription = "Image of ${activity.activityName}",
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(4f / 2f),
            contentScale = ContentScale.Crop
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Background),// Consistent padding

            horizontalArrangement = Arrangement.SpaceBetween // Space buttons evenly
        ) {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                    contentDescription = "Tilbakeknapp til hjemskjerm.",

                    )
            }
        }

        Spacer(modifier = Modifier.padding(vertical = 16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier
                    .padding(8.dp),
                text = activity.activityName,
                style = TextStyle(
                    fontSize = 28.sp, // Increase font size for title
                    lineHeight = 28.sp, // Adjust line height for better readability
                    fontWeight = FontWeight.Bold, // Make title bold
                    color = MidnightBlue, // Use MaterialTheme colors

                )
            )
            Image(
                painter = painterResource(
                    id = activity.getFlagColorId()
                ),
                contentDescription = "Flagg med farge for aktivitet",
                modifier = Modifier
                    .height(50.dp)
                    .width(50.dp)
                    .offset(x = (-24).dp)
            )
        }


        Spacer(modifier = Modifier.padding(vertical = 8.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
        ) {

            Row(
                horizontalArrangement = Arrangement.Center ,
                modifier = Modifier
                    .fillMaxWidth() // Center contents
            ) {
                Text(
                    text = activity.getFlagDescription(),
                    style = TextStyle(
                        fontSize = 18.sp,
                        lineHeight = 24.sp,
                        fontWeight = FontWeight.Normal,
                        color = MidnightBlue
                    ),
                    modifier = Modifier
                        .padding(end = 8.dp, bottom = 14.dp),
                )
            }
        }

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
        ) {

            ConditionCard(
                conditionTitle = "Forholdene nå:",
                conditionDescription = activity.conditionDescription
            )
        }


        Spacer(modifier = Modifier.padding(vertical = 24.dp)) // Increase bottom padding

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 28.dp, vertical = 10.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                modifier = Modifier
                    .size(width = 250.dp, height = 80.dp),
                onClick = {
                    val norwayZone = ZoneId.of("Europe/Oslo")
                    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm").withZone(norwayZone)
                    val time = ZonedDateTime.now(norwayZone).format(formatter)
                    currentUser?.let {
                        activitiesViewModel.logActivity(
                            username = it.userName,
                            activity = activity
                        )
                    }
                    showDialog = true
                },
                colors = ButtonDefaults.buttonColors(MidnightBlue)
            ) {
                Text(
                    text = "Loggfør aktivitet",
                    fontSize = 20.sp,
                    color = Background
                )
            }
        }
    }
}

@Composable
fun ConditionCard(conditionTitle: String, conditionDescription: String) {
    Card(
        modifier = Modifier
            .padding(start = 10.dp, top = 20.dp, end = 10.dp),
        colors = CardDefaults.cardColors(containerColor = ContainerBlue),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = conditionTitle,
                style = TextStyle(
                    fontSize = 20.sp,
                    lineHeight = 24.sp,
                    fontWeight = FontWeight.Normal,
                    color = MidnightBlue,
                    textAlign = TextAlign.Center
                )
            )
            Spacer(modifier = Modifier.padding(vertical = 4.dp))
            Text(
                text = conditionDescription,
                style = TextStyle(
                    fontSize = 18.sp,
                    lineHeight = 24.sp,
                    fontWeight = FontWeight.Normal,
                    color = MidnightBlue,
                    textAlign = TextAlign.Center
                )
            )
        }
    }
}

