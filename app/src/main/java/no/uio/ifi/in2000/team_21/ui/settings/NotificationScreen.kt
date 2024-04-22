package no.uio.ifi.in2000.team_21.ui.settings

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import no.uio.ifi.in2000.team_21.ui.theme.backgroundLight
import no.uio.ifi.in2000.team_21.ui.theme.containerLight
import no.uio.ifi.in2000.team_21.ui.theme.onContainerLight



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationScreen (navController:NavController){

    val FUNCTION_NAME = object {}.javaClass.enclosingMethod?.name

    Log.d(
        FUNCTION_NAME,
        "called"
    )

    val checked by remember { mutableStateOf(true) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Varslinger",
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
    ){innerPadding->
        Column(
            modifier = Modifier
                .padding(innerPadding)
        ){
            SwitchCard("Varslinger", checked = remember { mutableStateOf(checked) })
        }
    }
}
@Composable
fun SwitchCard(name: String,checked: MutableState<Boolean>){
    Card(onClick = {},
        modifier = Modifier
            .clickable { }
            .fillMaxWidth()
            .height(56.dp),
        colors = CardDefaults.cardColors(containerLight)
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 25.dp, end = 25.dp, top = 15.dp, bottom = 15.dp)
        ){
            Text(
                modifier = Modifier
                    .width(190.dp),
                text = name,
                style = TextStyle(
                    fontSize = 15.sp,
                    lineHeight = 20.sp,
                    fontWeight = FontWeight(500),
                    color = onContainerLight,
                    letterSpacing = 0.1.sp
                )
            )
            Spacer(modifier = Modifier.weight(1f))
            Switch(
                checked = checked.value,
                onCheckedChange = {
                    checked.value = it
                },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = backgroundLight,
                    checkedTrackColor = onContainerLight,
                    //uncheckedThumbColor = onContainerLight,
                    //uncheckedTrackColor = profileLight
                ),
                modifier = Modifier
                    .width(52.dp)
                    .height(32.dp)
                    .background(
                        color = onContainerLight,
                        shape = RoundedCornerShape(size = 100.dp)
                    )
                    .padding(start = 4.dp, top = 2.dp, end = 4.dp, bottom = 2.dp)
            )
        }
    }
}


@Preview
@Composable
fun NotificationScreenTest() {
    NotificationScreen(navController = rememberNavController())
}