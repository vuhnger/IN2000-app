package no.uio.ifi.in2000.team_21.ui.home


import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import no.uio.ifi.in2000.team_21.Screen
import no.uio.ifi.in2000.team_21.model.AlertsInfo
import no.uio.ifi.in2000.team_21.ui.LocationViewModel
import no.uio.ifi.in2000.team_21.ui.map.AlertsViewModel
import androidx.compose.ui.Modifier
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

@Composable
fun WeatherCard(
    temperature: String,
    alertColor: Color = Color(0xFFF7F7F7),
    isAlertActive: Boolean = false,
    icon: String,
    waveheight: String,
    windSpeed: String
) {

    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Card(
            modifier = Modifier
                .padding(40.dp)
                .fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 16.dp),
            colors = CardDefaults.cardColors(containerColor = alertColor)
        ) {
            Column (
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Min posisjon",
                    style = TextStyle(
                        fontSize = 25.sp,
                        lineHeight = 20.sp,
                        //fontFamily = FontFamily(Font(R.font.roboto)),
                        fontWeight = FontWeight(500),
                        color = Color(0xFF00145D),
                        textAlign = TextAlign.Center,
                        letterSpacing = 0.1.sp,
                    )
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    text = "Oslo",
                    style = TextStyle(
                        fontSize = 18.sp,
                        lineHeight = 20.sp,
                        //fontFamily = FontFamily(Font(R.font.roboto)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF00145D),
                        textAlign = TextAlign.Center,
                        letterSpacing = 0.1.sp,
                    )
                )
                Spacer(Modifier.height(16.dp))
                Box(
                    contentAlignment = Alignment.CenterStart,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 40.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        WeatherIcon(
                            element = icon,
                        )
                        Spacer(modifier = Modifier.padding(4.dp))
                        Text(
                            text = temperature,
                            style = TextStyle(
                                fontSize = 70.sp,
                                lineHeight = 16.sp,
                                //fontFamily = FontFamily(Font(R.font.roboto)),
                                fontWeight = FontWeight(400),
                                color = Color(0xFF00145D),
                                textAlign = TextAlign.Center,
                                letterSpacing = 0.5.sp,
                            ),
                        )
                        if (isAlertActive) {
                            Icon(
                                imageVector = Icons.Default.Warning,
                                contentDescription = "Alert active",
                                modifier = Modifier
                                    .padding(start = 8.dp)
                                    .size(48.dp)
                            )
                        }
                    }
                }
                Spacer(Modifier.height(4.dp))
                Text(
                    text = icon,
                    style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 20.sp,
                        //fontFamily = FontFamily(Font(R.font.roboto)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF00145D),
                        textAlign = TextAlign.Center,
                        letterSpacing = 0.1.sp,
                    )
                )
                Spacer(Modifier.height(4.dp))

                Row(

                ) {
                    Text(
                        text = "Vind: " + windSpeed,
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 20.sp,
                            //fontFamily = FontFamily(Font(R.font.roboto)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF00145D),
                            textAlign = TextAlign.Center,
                            letterSpacing = 0.1.sp,
                        ),
                        modifier = Modifier
                            .weight(1f)
                    )

                    Text(
                        text = "Bølger: " + waveheight ,
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 20.sp,
                            //fontFamily = FontFamily(Font(R.font.roboto)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF00145D),
                            textAlign = TextAlign.Center,
                            letterSpacing = 0.1.sp,
                        ),
                        modifier = Modifier
                            .weight(1f)
                    )
                }
            }
        }
    }
}

@Composable
fun ActivityFavorites(
    viewModel: ActivitiesViewModel,
    navController: NavController,
    activityConditionCheckerViewModel: ActivityConditionCheckerViewModel
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {

            Text(
                text = "Favoritter",
                style = TextStyle(
                    fontSize = 20.sp,
                    lineHeight = 20.sp,
                    //fontFamily = FontFamily(Font(R.font.roboto)),
                    fontWeight = FontWeight(400),
                    color = MaterialTheme.colorScheme.primary,
                    textAlign = TextAlign.Center,
                    letterSpacing = 0.1.sp,
                ),
                modifier = Modifier
                    .weight(1f)
            )

            Button(
                onClick = { navController.navigate(Screen.AddActivitiyScreen.route) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = androidx.compose.material.MaterialTheme.colors.background,
                    contentColor = androidx.compose.material.MaterialTheme.colors.primary
                ),
                modifier = Modifier
                    .weight(1f)
                    .width(20.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Button add to favorites",
                    modifier = Modifier
                        .padding(1.dp)
                )
            }

        }

        Spacer(Modifier.height(8.dp))

        ActivityCardGridHorizontalSmall(activitiesViewModel = viewModel)

    }
}

@Composable
fun RecommendationSection(
    viewModel: ActivitiesViewModel,
    navController: NavController
) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text(
            text = "Anbefaling",
            style = TextStyle(
                fontSize = 20.sp,
                lineHeight = 20.sp,
                //fontFamily = FontFamily(Font(R.font.roboto)),
                fontWeight = FontWeight(400),
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center,
                letterSpacing = 0.1.sp,
            )
        )
        Spacer(Modifier.height(8.dp))
        LazyRow {
            this.items(viewModel.activityUIstate.activities){ recommendation ->
                ActivityCardSmall(
                    activity = recommendation,
                    navController = navController
                )
            }
            }
        }
    }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    navController: NavController
) {
    TopAppBar(
        title = {  },
        actions = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Box(Modifier.weight(1f))

                Row {
                    IconButton(
                        onClick = {
                                  // TODO: Tilbake navigering
                                  },
                        modifier = Modifier
                            .sizeIn(minWidth = 96.dp, minHeight = 48.dp)
                    ) {
                        Text("Hjem", style = TextStyle(
                            fontSize = 20.sp
                        )
                        )
                    }
                    IconButton(
                        onClick = { navController.navigate(Screen.MapScreen.route) },
                        modifier = Modifier
                            .sizeIn(minWidth = 96.dp, minHeight = 48.dp)
                    ) {
                        Text("Kart", style = TextStyle(
                            fontSize = 20.sp
                        ))
                    }
                }

                Box(Modifier.weight(1f)) {
                    IconButton(onClick = { navController.navigate(Screen.SettingScreen.route) }) {
                        Icon(
                            Icons.Default.AccountCircle,
                            contentDescription = "Account icon",
                            modifier = Modifier.size(36.dp)
                        )
                    }
                }
            }
        },
        modifier = Modifier
            .padding(top = 16.dp)
    )

}


@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreen(
    navController: NavController,
    activitiesViewModel: ActivitiesViewModel,
    forecastViewModel: ForecastViewModel,
    alertsViewModel: AlertsViewModel,
    locationViewModel: LocationViewModel,
    activityConditionCheckerViewModel: ActivityConditionCheckerViewModel,
    oceanForecastViewModel: OceanForecastViewModel
) {

    val userLocation by locationViewModel.userLocation.collectAsState()
    val filteredFeatures by alertsViewModel.filteredFeatures.observeAsState()
    val oceanData by oceanForecastViewModel.oceanDataState.observeAsState()


    val isAlertActive = remember(filteredFeatures) {
        filteredFeatures?.isNotEmpty() == true
    }

    LaunchedEffect(userLocation) {
        if (userLocation != null) {

            alertsViewModel.fetchAndFilterAlerts(
                AlertsInfo(),
                userLocation!!,
                radius = 500.0
            )

            Log.d("HOME_SCREEN", "User location: ${userLocation!!.latitude()}, ${userLocation!!.longitude()}")

            forecastViewModel.fetchTodaysForecast( // let him cook!
                latitude = userLocation?.latitude() ?: 0.0,
                longitude = userLocation?.longitude() ?: 0.0
            )

            val norwayZone = ZoneId.of("Europe/Oslo")

            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH").withZone(norwayZone)

            val time = ZonedDateTime.now(norwayZone).truncatedTo(ChronoUnit.HOURS).format(formatter)

            activityConditionCheckerViewModel.checkActivityConditions(
                time = time,
                latitude = userLocation?.latitude() ?: 0.0,
                longitude = userLocation?.longitude() ?: 0.0
            )
        }
    }

    val alertColor = when (filteredFeatures?.maxByOrNull { it.properties.severity?.toIntOrNull() ?: 0 }?.properties?.riskMatrixColor) {
        "Yellow" -> Color(0xFFF9F1DC) // Yellow
        "Red" -> Color(0xFFF9DEDC) // Red
        "Green" -> Color(0xFFECF9DC) // Green
        else -> Color(0xFFF7F7F7) // Default case
    }

    Column(
        modifier = Modifier
            .width(360.dp)
            .height(50.dp)
            .background(color = Color(0xFFF7F8FF))
    ) {

        TopBar(
            navController = navController
        )

        WeatherCard(
            temperature = forecastViewModel.today_forecast?.data?.instant?.details?.air_temperature?.toString() ?: "N/A",
            alertColor = alertColor,
            isAlertActive = isAlertActive,
            icon = forecastViewModel.today_forecast?.data?.next_1_hours?.summary?.symbol_code?.toString() ?: "N/A",
            waveheight = "",
            windSpeed = ""
        )

        ActivityFavorites(
            viewModel = activitiesViewModel,
            navController = navController,
            activityConditionCheckerViewModel = activityConditionCheckerViewModel
        )

        RecommendationSection(
            viewModel = activitiesViewModel,
            navController = navController
        )
    }
}
