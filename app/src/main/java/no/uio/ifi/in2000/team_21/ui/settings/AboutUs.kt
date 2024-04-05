package no.uio.ifi.in2000.team_21.ui.settings


import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import no.uio.ifi.in2000.team_21.APP_ROUTES
import no.uio.ifi.in2000.team_21.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
@ExperimentalMaterial3Api
fun AboutUsScreen(navController: NavController) {

    val FUNCTION_NAME = object {}.javaClass.enclosingMethod.name
    val names = listOf("Joachim", "Jonas", "Kaja", "Mari", "Sebastian", "Victor")

    Log.d(
        FUNCTION_NAME,
        "called"
    )
//Her vil jeg egt ha pil uten den horisontale streken, får d ikke til.
    Scaffold(
        topBar = { TopAppBar(title = { Text("Om oss", color = Color(0xFF00145D))},
            navigationIcon = { IconButton(onClick = { navController.navigate(APP_ROUTES.SETTING_SCREEN) },)
            {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Tilbake",
                    tint = Color(0xFF00145D)
                )
            }
            }
        )
        },
                modifier = Modifier
                .background(color = Color(0xFFF7F8FF))
    ) { innerPadding ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            content = {
                items(names.size) {
                    AboutUsCard(names[it])
                }
            },
            modifier = Modifier
                .padding(innerPadding)
                .padding(15.dp)
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
            .fillMaxWidth()
            .height(200.dp)
            .padding(15.dp)
            .border(
                width = 2.dp,
                color = Color(0xFF5062A4.toInt()),
                shape = RoundedCornerShape(12.dp)
            ),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFDDE4FF))
    ){
        Column(
            verticalArrangement = Arrangement.spacedBy(0.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(15.dp)
        ) {
            Text(
                text = name,
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 16.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF00145D),
                    textAlign = TextAlign.Center,
                    letterSpacing = 0.5.sp,
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(16.dp)
            )
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun AboutUsScreenTest(){
    AboutUsScreen(navController = rememberNavController())
}

