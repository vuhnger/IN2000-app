package no.uio.ifi.in2000.team_21.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import no.uio.ifi.in2000.team_21.ui.map.MapboxMapView


@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        bottomBar = { BottomBarWithIcons() }
    ) { innerPadding ->
        Box {
            MapboxMapView().apply {
                Modifier.padding(innerPadding)
            }
            Column {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    SOSButton(onClick = {  })
                    SettingsButton(onClick = {  })
                }
            }
        }
    }
}

@Composable
fun SOSButton(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red),
        modifier = Modifier
            .size(70.dp)
            .clip(RoundedCornerShape(20.dp))
    ) {
        Text(
            text = "SOS",
            color = Color.White,
            fontSize = 18.sp
        )
    }
}

@Composable
fun SettingsButton(onClick: () -> Unit) {
    IconButton(onClick = onClick) {
        Icon(Icons.Filled.Settings, contentDescription = "Settings")
    }
}

@Composable
fun BottomBarWithIcons() {
    BottomNavigation(
        modifier = Modifier.height(56.dp),
        backgroundColor = Color.White,
        elevation = 8.dp
    ) {
        repeat(5) { index ->
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