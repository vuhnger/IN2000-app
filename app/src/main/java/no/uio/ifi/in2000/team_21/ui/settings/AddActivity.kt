package no.uio.ifi.in2000.team_21.ui.settings

import android.annotation.SuppressLint
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import no.uio.ifi.in2000.team_21.APP_ROUTES

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun addActivity(navController: NavController) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Om oss") },
            navigationIcon = {
                IconButton(
                    onClick = {
                        navController.navigate(APP_ROUTES.SETTING_SCREEN)
                    }
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Tilbake"
                    )
                }
            }
        )
        }
    ) {
        LazyColumn(){}

    }

}