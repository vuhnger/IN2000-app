package no.uio.ifi.in2000.team_21.ui.settings

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import no.uio.ifi.in2000.team_21.data.database.UserLogEntity
import no.uio.ifi.in2000.team_21.ui.theme.Background
import no.uio.ifi.in2000.team_21.ui.theme.ContainerBlue
import no.uio.ifi.in2000.team_21.ui.theme.MidnightBlue
import no.uio.ifi.in2000.team_21.ui.viewmodels.ActivitiesViewModel
import java.time.ZoneId
import java.time.format.DateTimeFormatter

@Composable
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun MyActivityScreen(
    navController: NavController,
    activitiesViewModel: ActivitiesViewModel
) {
    val logs = activitiesViewModel.userLogs.observeAsState(initial = listOf())

    val FUNCTION_NAME = object {}.javaClass.enclosingMethod.name

    Log.d(
        FUNCTION_NAME,
        "called"
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Historikk",
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
        containerColor = Background,
    ){
            innerPadding->
        Column(modifier = Modifier.padding(innerPadding)) {
            if (logs.value.isEmpty()) {
                EmptyLogsMessage()
            } else {
                LogsList(logs.value)
            }
        }
    }
}

@Composable
fun ActivityLogCard(
    userLog: UserLogEntity
){
    val norwayZone = ZoneId.of("Europe/Oslo")
    val formatter = DateTimeFormatter.ofPattern("dd:MM:yyyy:HH:mm").withZone(norwayZone)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        elevation = 5.dp,
        contentColor = MidnightBlue,
        backgroundColor = ContainerBlue
    ) {
        Text(
            text = "Du gjennomførte ${userLog.activityName.lowercase()} ${userLog.timestamp.format(formatter)}",
            modifier = Modifier
                .padding(8.dp)
        )
    }
}

@Composable
fun EmptyLogsMessage() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .padding()
    ) {
        Text("Dine gjennomførte aktiviteter vises her.")
    }
}

@Composable
fun LogsList(logs: List<UserLogEntity>) {
    LazyColumn(
        modifier = Modifier.padding(8.dp)
    ) {
        items(logs) { log ->
            ActivityLogCard(log)
        }
    }
}