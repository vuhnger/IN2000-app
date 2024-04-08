package no.uio.ifi.in2000.team_21.ui.settings

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import no.uio.ifi.in2000.team_21.APP_ROUTES

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddActivity(navController: NavController) {

    val FUNCTION_NAME = object {}.javaClass.enclosingMethod.name
    var text by remember { mutableStateOf("") }

    Log.d(
        FUNCTION_NAME,
        "called"
    )


    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Legg til aktivitet") },
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
        },
        modifier = Modifier
            .background(color = Color(0xFFF7F8FF))
    ) {innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
        ){
            items(count = 1){
                OutlinedTextField(
                    value = text,
                    onValueChange = { text = it },
                    label = { Text("Vannaktivitet")},
                )
            }
                //settings for weatherconditions}

        }
    }

}

@Preview
@Composable
fun AddActivityScreenTest(){
    AddActivity(navController = rememberNavController())
}