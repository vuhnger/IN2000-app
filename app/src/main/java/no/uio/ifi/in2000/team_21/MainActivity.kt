package no.uio.ifi.in2000.team_21

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import no.uio.ifi.in2000.team_21.ui.settings.AboutUsScreen
import com.mapbox.mapboxsdk.Mapbox
import no.uio.ifi.in2000.team_21.ui.home.HomeScreen
import no.uio.ifi.in2000.team_21.ui.settings.AddActivityScreen
import no.uio.ifi.in2000.team_21.ui.settings.SettingScreen
import no.uio.ifi.in2000.team_21.ui.theme.Team21Theme

sealed class Screen(val route: String){
    object HomeScreen: Screen(route = "HomeScreen")
    object MapScreen: Screen(route = "MapScreen")
    object SettingScreen: Screen(route = "SettingScreen")
    object AboutUsScreen: Screen(route = "AboutUsScreen")
    object AddActivitiyScreen: Screen(route = "AddActivityScreen")

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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Mapbox.getInstance(applicationContext, "pk.eyJ1Ijoiandob2xtYm8iLCJhIjoiY2x1MDQ0MHg2MDYxNjJrdDR4eTAwanVhOSJ9.UJ531h6BwXp56LYSIOxwFQ")
        setContent {
            Team21Theme {
                // A surface container using the 'background' color from the theme
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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App(){

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route
    ){

        composable(Screen.HomeScreen.route){
            entry -> HomeScreen(navController = navController) // Per 11.03 er HomeScreen komponenten med kartet, men det skal refaktoreres. :)
        }

        composable(Screen.SettingScreen.route){
            entry -> SettingScreen(navController = navController)
        }

        composable(Screen.AboutUsScreen.route){
            entry -> AboutUsScreen(navController = navController)
        }

        composable(Screen.AddActivitiyScreen.route){
            entry -> AddActivityScreen(navController = navController)
        }

    }

}