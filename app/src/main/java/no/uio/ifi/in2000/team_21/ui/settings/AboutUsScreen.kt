package no.uio.ifi.in2000.team_21.ui.settings


import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import no.uio.ifi.in2000.team_21.ui.theme.Background
import no.uio.ifi.in2000.team_21.ui.theme.MidnightBlue


data class TeamMember(
    val name: String,
    val age: Int,
    val personality: String,
    val studyProgramme: String,
)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
@ExperimentalMaterial3Api
fun AboutUsScreen(navController: NavController) {

    val names = listOf(
        TeamMember(
            name = "Joachim Haasted",
            age =  23,
            personality = "ISTJ-A (Assertive Logistician)",
            studyProgramme = "Informatikk: programmering og systemarkitektur"
        ),
        TeamMember(
            name  = "Jonas Holmboe",
            age = 22,
            personality = "INTP-A (Assertive Logician)",
            studyProgramme = "Informatikk: programmering og systemarkitektur"
        ),
        TeamMember(
            name = "Kaja Stenen",
            age = 23,
            personality = "ESTJ-A (Executive)",
            studyProgramme = "Informatikk: design, bruk og interaksjon"
        ),
        TeamMember(
            name = "Mari Stenbrenden",
            age = 22,
            personality = "ESFP-A (Entertainer)",
            studyProgramme = "Informatikk: design, bruk og interaksjon"
        ),
        TeamMember(
            name = "Sebastian Hareide",
            age = 22,
            personality = "ENFJ-T (Protagonist)",
            studyProgramme = "Informatikk: programmering og systemarkitektur"
        ),
        TeamMember(
            name = "Victor Uhnger", age = 22,
            personality = "INTJ-A (Architect)",
            studyProgramme = "Informatikk: språkteknologi"
        )
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Om oss",
                        color = MidnightBlue
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
                            tint = MidnightBlue,
                            modifier = Modifier
                                .size(30.dp)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(Background),
            )
        },
        containerColor = Background
    ) { innerPadding ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            content = {
                items(names) {teamMember ->
                    AboutUsCard(teamMember = teamMember)
                }
            },
            modifier = Modifier
                .padding(innerPadding)
                .padding(15.dp)
        )
    }
}

@Composable
fun AboutUsCard(teamMember: TeamMember){
    Log.d(
        "AboutUsCard",
        "Created card with ${teamMember.name}"
    )
    Card(
        modifier = Modifier
            .height(230.dp)
            .padding(15.dp)
            .border(
                width = 2.dp,
                color = MidnightBlue,
                shape = RoundedCornerShape(12.dp)
            ),
        colors = CardDefaults.cardColors(MidnightBlue)
    ){
        Column(
            verticalArrangement = Arrangement.spacedBy(0.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(15.dp)
        ) {
            Text(
                text = teamMember.name,
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 16.sp,
                    fontWeight = FontWeight(500),
                    color = Background,
                    textAlign = TextAlign.Center,
                    letterSpacing = 0.5.sp,
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(16.dp)
            )
            Text(
                text = teamMember.age.toString() + " år",
                style = TextStyle(
                    fontSize = 12.sp,
                    color = Background,
                    textAlign = TextAlign.Center,
                ),
                modifier = Modifier
                    .padding(top = 15.dp)
            )
            Text(
                text = teamMember.personality,
                style = TextStyle(
                    fontSize = 12.sp,
                    color = Background,
                    textAlign = TextAlign.Center,
                ),
                modifier = Modifier
                    .padding(top = 15.dp)
            )
            Text(
                text = teamMember.studyProgramme,
                style = TextStyle(
                    fontSize = 12.sp,
                    color = Background,
                    textAlign = TextAlign.Center,
                ),
                modifier = Modifier
                    .padding(top = 15.dp, bottom = 10.dp)

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

