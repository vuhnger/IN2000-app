package no.uio.ifi.in2000.team_21.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import no.uio.ifi.in2000.team_21.Screen
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import no.uio.ifi.in2000.team_21.ui.theme.containerLight
import no.uio.ifi.in2000.team_21.ui.theme.onContainerLight


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarComponent(
    navController: NavController
) {
    val currentDestination = navController.currentBackStackEntry?.destination?.route

    TopAppBar(
        title = { /**/ },
        actions = {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    TextButton(onClick = {
                        if (currentDestination != Screen.HomeScreen.route) {
                            navController.navigate(Screen.HomeScreen.route) {
                                popUpTo(navController.graph.startDestinationRoute!!)
                            }
                        }
                    }) {
                        Text(
                            "Hjem",
                            color = onContainerLight,
                            fontSize = 20.sp,
                            maxLines = 1,
                            style = if (currentDestination == Screen.HomeScreen.route) {
                                TextStyle(textDecoration = TextDecoration.Underline)
                            } else {
                                MaterialTheme.typography.bodyLarge
                            }

                        )
                    }
                    Spacer(modifier = Modifier.width(48.dp))
                    TextButton(onClick = {
                        if (currentDestination != Screen.MapScreen.route) {
                            navController.navigate(Screen.MapScreen.route) {
                                popUpTo(navController.graph.startDestinationRoute!!)
                            }
                        }
                    }) {
                        Text(
                            "Kart",
                            color = onContainerLight,
                            fontSize = 20.sp,
                            style = if (currentDestination == Screen.MapScreen.route) {
                                TextStyle(textDecoration = TextDecoration.Underline)
                            } else {
                                MaterialTheme.typography.bodyLarge
                            }
                        )
                    }
                }
                IconButton(onClick = { navController.navigate(Screen.SettingScreen.route) },
                    modifier = Modifier.align(Alignment.CenterEnd)
                ) {
                    Icon(Icons.Default.Settings, contentDescription = "Settings icon", tint = onContainerLight)
                }
            }
        },
        modifier = Modifier,
        colors = TopAppBarColors(
            containerColor = containerLight,
            titleContentColor = Color.White,
            navigationIconContentColor = Color.White,
            actionIconContentColor = Color.White,
            scrolledContainerColor = containerLight,
        )
    )
}