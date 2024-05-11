package no.uio.ifi.in2000.team_21.ui.settings

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import no.uio.ifi.in2000.team_21.Screen
import no.uio.ifi.in2000.team_21.ui.theme.Background
import no.uio.ifi.in2000.team_21.ui.theme.ContainerBlue
import no.uio.ifi.in2000.team_21.ui.theme.MidnightBlue


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddActivityScreen(navController: NavController) {

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
                        navController.popBackStack()
                    }
                ) {
                    Icon(
                        contentDescription = "Tilbake",
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                        tint = MidnightBlue,
                        modifier = Modifier
                            .size(30.dp)
                    )
                }
            },
                colors = TopAppBarDefaults.topAppBarColors(Background),
            )
        },
        containerColor = Background,
    ) {innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .padding(30.dp)
        ){
            items(count = 1) {
                OutlinedTextField(
                    value = text,
                    onValueChange = { text = it },
                    label = { Text("Vannaktivitet") },
                    modifier = Modifier
                        .fillMaxWidth(),
                    //ikke optimal
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = ContainerBlue,
                        unfocusedBorderColor = ContainerBlue)
                    )
                 Spacer(modifier = Modifier
                     .padding(30.dp)
                 )
                //settings for weatherconditions
                //løkke gjennom en liste av ulike conditions
                WeatherSliders(name = "Vind")

            }                                                           
        }                                                               
    }                                                                   
}
@Composable
fun WeatherSliders(name: String){
    var sliderPosition by remember {   mutableFloatStateOf(0f)}
    Text(text = name)
    Slider(
        value = sliderPosition,
        onValueChange = { sliderPosition = it },
        colors = SliderDefaults.colors(MidnightBlue),
        steps = 4,
        valueRange = 0f..15f
    )
    Text(text = sliderPosition.toString())
}
                                                                        
@Preview                                                                
@Composable                                                             
fun AddActivityScreenTest(){                                            
    AddActivityScreen(navController = rememberNavController())
}