package no.uio.ifi.in2000.team_21

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.currentBackStackEntryAsState
import no.uio.ifi.in2000.team_21.ui.home.drawImages
import no.uio.ifi.in2000.team_21.ui.settings.AboutUsScreen
import no.uio.ifi.in2000.team_21.ui.home.HomeScreen
import no.uio.ifi.in2000.team_21.ui.settings.AboutUsScreen
import no.uio.ifi.in2000.team_21.ui.home.ActivitiesViewModel
import no.uio.ifi.in2000.team_21.ui.home.ActivityCardGrid
import no.uio.ifi.in2000.team_21.ui.home.ActivityCardSmall
import no.uio.ifi.in2000.team_21.ui.settings.AddActivityScreen
import no.uio.ifi.in2000.team_21.ui.settings.ContactsScreen
import no.uio.ifi.in2000.team_21.ui.settings.FriendsActivityScreen
import no.uio.ifi.in2000.team_21.ui.settings.MyActivityScreen
import no.uio.ifi.in2000.team_21.ui.settings.NotificationScreen
import no.uio.ifi.in2000.team_21.ui.settings.ProfileScreen
import no.uio.ifi.in2000.team_21.ui.settings.SettingScreen
import no.uio.ifi.in2000.team_21.ui.settings.TrophyWallScreen
import no.uio.ifi.in2000.team_21.ui.theme.Team21Theme
import com.mapbox.mapboxsdk.Mapbox

sealed class Screen(val route: String){
    object HomeScreen: Screen(route = "HomeScreen")
    object MapScreen: Screen(route = "MapScreen")
    object SettingScreen: Screen(route = "SettingScreen")
    object AboutUsScreen: Screen(route = "AboutUsScreen")
    object AddActivitiyScreen: Screen(route = "AddActivityScreen")
    object ProfileScreen: Screen(route = "ProfileScreen")
    object FriendsActivityScreen: Screen(route = "FriendsActivityScreen")
    object MyActivityScreen: Screen(route = "MyActivityScreen")
    object TrophyWallScreen: Screen(route = "TrophyWallScreen")
    object NotificationScreen: Screen(route = "NotificationScreen")
    object ContactsScreen: Screen(route = "ContactsScreen")

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
                    drawImages()
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
        startDestination = Screen.SettingScreen.route
        // startDestination = Screen.HomeScreen.route
    ){

        composable(Screen.HomeScreen.route){
            HomeScreen(navController = navController) // Per 11.03 er HomeScreen komponenten med kartet, men det skal refaktoreres. :)
        }

        composable(Screen.SettingScreen.route){
            SettingScreen(navController = navController)
        }

        composable(Screen.AboutUsScreen.route){
            AboutUsScreen(navController = navController)
        }

        composable(Screen.AddActivitiyScreen.route){
            AddActivityScreen(navController = navController)
        }
        composable(Screen.ProfileScreen.route){
            ProfileScreen(navController = navController)
        }
        composable(Screen.FriendsActivityScreen.route){
            FriendsActivityScreen(navController = navController)
        }
        composable(Screen.MyActivityScreen.route){
            MyActivityScreen(navController = navController)
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
    }
}