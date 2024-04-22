package no.uio.ifi.in2000.team_21.ui.settings

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import no.uio.ifi.in2000.team_21.ui.theme.backgroundLight
import no.uio.ifi.in2000.team_21.ui.theme.onContainerLight

@Composable
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun ContactsScreen(navController: NavController) {

    val FUNCTION_NAME = object {}.javaClass.enclosingMethod.name

    Log.d(
        FUNCTION_NAME,
        "called"
    )

    var checked by remember { mutableStateOf(true) } //13.03 Må flyttes til en global ui-state

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Kontakter",
                        color = onContainerLight
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.popBackStack()
                        }
                    ) {
                        Icon(
                            contentDescription = "Tilbake",
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                            tint = onContainerLight,
                            modifier = Modifier
                                .size(30.dp)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(backgroundLight),
            )
        },
        containerColor = backgroundLight,
    ){
            innerPadding->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
                .padding(innerPadding)
        ){
        }
    }
}
@Preview
@Composable
fun ContactsScreenTest() {
    ContactsScreen(navController = rememberNavController())
}