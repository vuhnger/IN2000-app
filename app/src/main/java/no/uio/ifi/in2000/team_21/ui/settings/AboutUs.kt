package no.uio.ifi.in2000.team_21.ui.settings


import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import no.uio.ifi.in2000.team_21.APP_ROUTES


@OptIn(ExperimentalMaterial3Api::class)
@Composable
@ExperimentalMaterial3Api
fun AboutUsScreen(navController: NavController) {

    val FUNCTION_NAME = object {}.javaClass.enclosingMethod.name
    val names = listOf<String>("Joachim", "Jonas", "Kaja", "Mari", "Sebastian", "Victor")

    Log.d(
        FUNCTION_NAME,
        "called"
    )

    Scaffold(
        topBar = { TopAppBar(title = { Text("Om oss") },
            navigationIcon = { IconButton(onClick = { navController.navigate(APP_ROUTES.SETTING_SCREEN) })
            {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Tilbake"
                )
            }
            }
        )
        }
    ) { innerPadding ->
        LazyVerticalGrid(
            columns = GridCells.FixedSize(145.dp),
            content = {
                items(names.size) {
                    AboutUsCard(names[it])
                }
            },
            modifier = Modifier
                .padding(innerPadding)
                .padding(start = 15.dp)
        )
    }
}
@Composable
fun AboutUsCard(
    //Legge til parameter om oss
    name: String
) {

    Log.d(
        "AboutUsCard",
        "Created card with $name"
    )

    Card(
        modifier = Modifier
            .size(width = 135.dp, height = 135.dp)
            .padding(15.dp),
        colors =
        CardDefaults.cardColors(
            containerColor = Color(0xFFE8DEF8),
        )
    ){
        //Innhold i kortet
        Column() {
            Text(text = name)
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun AboutUsScreenTest(){
    AboutUsScreen(navController = rememberNavController())
}