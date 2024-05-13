package no.uio.ifi.in2000.team_21

import android.os.Build
import android.os.Bundle
import android.view.animation.OvershootInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mapbox.common.MapboxOptions
import no.uio.ifi.in2000.team_21.ui.LocationViewModel
import no.uio.ifi.in2000.team_21.ui.home.ActivitiesViewModel
import no.uio.ifi.in2000.team_21.ui.home.ActivityConditionCheckerViewModel
import androidx.navigation.navArgument
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import kotlinx.coroutines.delay
import no.uio.ifi.in2000.team_21.ui.home.ActivityDetailScreen
import no.uio.ifi.in2000.team_21.ui.home.AddFavoriteScreen
import no.uio.ifi.in2000.team_21.ui.home.HomeScreen
import no.uio.ifi.in2000.team_21.ui.map.AlertsViewModel
import no.uio.ifi.in2000.team_21.ui.map.MapboxMapView
import no.uio.ifi.in2000.team_21.ui.settings.AboutUsScreen
import no.uio.ifi.in2000.team_21.model.activity.ActivityModel
import no.uio.ifi.in2000.team_21.model.activity.ActivityModels
import no.uio.ifi.in2000.team_21.ui.home.ForecastViewModel
import no.uio.ifi.in2000.team_21.ui.home.OceanForecastViewModel
import no.uio.ifi.in2000.team_21.ui.settings.AddActivityScreen
import no.uio.ifi.in2000.team_21.ui.settings.ContactsScreen
import no.uio.ifi.in2000.team_21.ui.settings.FriendsActivityScreen
import no.uio.ifi.in2000.team_21.ui.settings.MyActivityScreen
import no.uio.ifi.in2000.team_21.ui.settings.NotificationScreen
import no.uio.ifi.in2000.team_21.ui.settings.ProfileScreen
import no.uio.ifi.in2000.team_21.ui.settings.SettingScreen
import no.uio.ifi.in2000.team_21.ui.settings.TrophyWallScreen
import no.uio.ifi.in2000.team_21.ui.theme.Team21Theme


sealed class Screen(val route: String){
    object SplashScreen: Screen(route = "SplashScreen")
    object HomeScreen: Screen(route = "HomeScreen")
    object MapScreen: Screen(route = "MapScreen")
    object SettingScreen: Screen(route = "SettingScreen")
    object AboutUsScreen: Screen(route = "AboutUsScreen")
    object AddActivityScreen: Screen(route = "AddActivityScreen")
    object ProfileScreen: Screen(route = "ProfileScreen")
    object FriendsActivityScreen: Screen(route = "FriendsActivityScreen")
    object MyActivityScreen: Screen(route = "MyActivityScreen")
    object TrophyWallScreen: Screen(route = "TrophyWallScreen")
    object NotificationScreen: Screen(route = "NotificationScreen")
    object ContactsScreen: Screen(route = "ContactsScreen")
    object AddFavoriteScreen: Screen(route = "AddFavoriteScreen")
    object ActivityDetailScreen: Screen(route = "ActivityDetailScreen")

    object AllActivitiesScreen : Screen(route = "AllActivitiesScreen")

    // Funksjonen bygger en streng av argumenter som kan sendes med et kall på navigate til en skjerm.
    // Dersom du bruker funksjonen, erstatt:
    // navController.navigate(Screen.ExampleScreen.route)
    // med:
    // navController.navigate(Screen.ExampleScreen.withArgs([ExampleArgs]))
    fun withArgs(vararg args: String): String{
        return buildString {
            append(route)
            args.forEach {
             arg -> append("/$arg")
            }
        }
    }

}


class MainActivity : ComponentActivity() {

    private var fusedLocationClient: FusedLocationProviderClient? = null

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        MapboxOptions.accessToken = "pk.eyJ1Ijoiandob2xtYm8iLCJhIjoiY2x1MDQ0MHg2MDYxNjJrdDR4eTAwanVhOSJ9.UJ531h6BwXp56LYSIOxwFQ"
        setContent {
            Team21Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    App()

                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App(){

    val navController = rememberNavController()
    val locationViewModel: LocationViewModel = viewModel()
    val activitiesViewModel: ActivitiesViewModel = viewModel(LocalContext.current as ComponentActivity)
    val forecastViewModel: ForecastViewModel = viewModel(LocalContext.current as ComponentActivity)
    val alertsViewModel: AlertsViewModel = viewModel()
    val activityConditionCheckerViewModel: ActivityConditionCheckerViewModel = viewModel()
    val oceanForecastViewModel: OceanForecastViewModel = viewModel()

    val defaultActivity: ActivityModel = ActivityModels.FISHING

    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route
    ){

        composable(Screen.SplashScreen.route){
            SplashScreen(navController = navController)
        }
        composable(Screen.MapScreen.route){
            MapboxMapView()
        }

        composable(Screen.HomeScreen.route){
            HomeScreen(
                navController = navController,
                activitiesViewModel = activitiesViewModel,
                forecastViewModel = forecastViewModel,
                alertsViewModel = alertsViewModel,
                locationViewModel = locationViewModel,
                activityConditionCheckerViewModel = activityConditionCheckerViewModel,
                oceanForecastViewModel = oceanForecastViewModel
            )
        }

        composable(Screen.SettingScreen.route){
            SettingScreen(navController = navController)
        }

        composable(Screen.AboutUsScreen.route){
            AboutUsScreen(navController = navController)
        }

        composable(Screen.AddActivityScreen.route){
            AddActivityScreen(navController = navController)
        }
        composable(Screen.ProfileScreen.route){
            ProfileScreen(navController = navController)
        }
        composable(Screen.FriendsActivityScreen.route){
            FriendsActivityScreen(navController = navController)
        }
        composable(Screen.MyActivityScreen.route){
            MyActivityScreen(
                navController = navController,
                activitiesViewModel = activitiesViewModel
            )
        }

        composable(Screen.TrophyWallScreen.route){
            TrophyWallScreen(navController = navController)
        }
        composable(Screen.NotificationScreen.route){
            NotificationScreen(navController = navController)
        }
        composable(Screen.ContactsScreen.route){
            ContactsScreen(navController = navController)
        }

        composable(Screen.AddActivityScreen.route){
            AddFavoriteScreen(
                navController = navController,
                forecastViewModel =  forecastViewModel,
                activitiesViewModel = activitiesViewModel
            )
        }

        composable(
            route = Screen.ActivityDetailScreen.route + "/{activityName}",
            arguments = listOf(
                navArgument(name = "activityName"){
                    type = NavType.StringType
                    defaultValue = defaultActivity.activityName
                    nullable = true
                }
            )
            ){entry ->
            ActivityDetailScreen(
                activitiesViewModel = activitiesViewModel,
                activityConditionCheckerViewModel = activityConditionCheckerViewModel,
                navController = navController,
                activityName = entry.arguments?.getString("activityName")
            )
        }
    }
}
@Composable
fun SplashScreen(navController: NavController) {
    val scale = remember {
        Animatable(0f)
    }

    // AnimationEffect
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 1.0f,
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(4f).getInterpolation(it)
                })
        )
        delay(3000L)
        navController.navigate(Screen.HomeScreen.route)
    }

    // Image
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxWidth().background(color = Color(0xFFE7F3FC))) {
        Image(painter = painterResource(id = R.drawable.prototype78),
            contentDescription = "Logo",
            modifier = Modifier.scale(scale.value).fillMaxWidth())
    }
}