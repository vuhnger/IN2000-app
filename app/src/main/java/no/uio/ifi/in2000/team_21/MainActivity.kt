package no.uio.ifi.in2000.team_21

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import no.uio.ifi.in2000.team_21.ui.home.HomeScreen
import no.uio.ifi.in2000.team_21.ui.theme.Team21Theme
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost // Riktig import av navhost
import no.uio.ifi.in2000.team_21.ui.settings.AboutUsScreen
import no.uio.ifi.in2000.team_21.ui.settings.AboutUsScreenTest
import no.uio.ifi.in2000.team_21.ui.settings.SettingScreen
import androidx.compose.ui.res.stringResource

// Vi legger strenger i dette objektet fremfor å hardkode de inn i appen. Disse skal senere flyttes til StringResources.
public object APP_ROUTES{
    const val HOME = "home"
    const val MAP_SCREEN = "map"
    const val SETTING_SCREEN = "settings"
    const val ABOUT_US_SCREEN = "aboutUS"
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
        startDestination = APP_ROUTES.HOME
    ){

        composable(APP_ROUTES.HOME){
            HomeScreen(navController = navController) // Per 11.03 er HomeScreen komponenten med kartet, men det skal refaktoreres. :)
        }

        composable(APP_ROUTES.SETTING_SCREEN){
            SettingScreen(navController = navController)
        }

        composable(APP_ROUTES.ABOUT_US_SCREEN){
            AboutUsScreen(navController = navController)
        }

    }

}