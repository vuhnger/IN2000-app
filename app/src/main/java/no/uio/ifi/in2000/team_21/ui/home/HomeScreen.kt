package no.uio.ifi.in2000.team_21.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import no.uio.ifi.in2000.team_21.Screen
import no.uio.ifi.in2000.team_21.ui.map.MapboxMapView


@Composable
fun HomeScreen(navController: NavController) {
    Box {
        MapboxMapView().apply {
            //Modifier.padding(innerPadding)
        }
        Column {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Spacer(modifier = Modifier.weight(1.0f))
                SettingsButton(
                    onClick = {
                        navController.navigate(
                            route = Screen.SettingScreen.route
                        )
                    }
                )
            }
        }
    }
}

@Composable
fun SettingsButton(onClick: () -> Unit) {
    IconButton(onClick = onClick) {
        Icon(Icons.Filled.Settings, contentDescription = "Settings")
    }
}
/*
@Composable
fun BottomBarWithIcons() {
    BottomNavigation(
        modifier = Modifier.height(56.dp),
        backgroundColor = Color.White,
        elevation = 8.dp
    ) {
        repeat(1) { index ->
            BottomNavigationItem(
                icon = {
                    Box(
                        Modifier
                            .size(24.dp)
                            .background(Color.Gray, CircleShape)
                    )
                },
                label = { Text("Icon $index") },
                selected = false,
                onClick = {  }
            )
        }
    }
}

 */