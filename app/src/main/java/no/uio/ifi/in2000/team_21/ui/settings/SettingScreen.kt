package no.uio.ifi.in2000.team_21.ui.settings

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import no.uio.ifi.in2000.team_21.APP_ROUTES

@Composable
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun SettingScreen(navController: NavController) {

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
                        "Innstillinger"
                    )
                },
                        navigationIcon = { IconButton(onClick = { navController.navigate(APP_ROUTES.HOME) })
                        {
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
    ){innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(30.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .background(
                        color = Color(0xFFEBEFFF),
                        shape = RoundedCornerShape(size = 100.dp)
                    )
                    .padding(start = 25.dp, end = 25.dp)

            ) {
                Text(
                    modifier = Modifier
                        .width(190.dp)
                        .height(20.dp),
                    text = "Darkmode",

                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 20.sp,
                        fontWeight = FontWeight(500),
                        color = Color(0xFF191D2B),
                        letterSpacing = 0.1.sp,
                        )
                )

                Spacer(modifier = Modifier.weight(1f))

                Switch(
                    checked = checked,
                    onCheckedChange = {
                        checked = it
                    },
                    modifier = Modifier
                        .width(52.dp)
                        .height(32.dp)
                        .background(
                            color = Color(0xFF5058A4),
                            shape = RoundedCornerShape(size = 100.dp)
                        )
                        .padding(start = 4.dp, top = 2.dp, end = 4.dp, bottom = 2.dp)
                )
            }

            Spacer(modifier = Modifier.padding(6.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .background(
                        color = Color(0xFFEBEFFF),
                        shape = RoundedCornerShape(size = 100.dp)
                    )
                    .padding(start = 25.dp, end = 25.dp)
            ) {
                Text(

                    modifier = Modifier
                        .width(206.dp)
                        .height(20.dp),
                    text = "Om oss",

                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 20.sp,
                        fontWeight = FontWeight(500),
                        color = Color(0xFF191D2B),
                        letterSpacing = 0.1.sp,
                    )
                )

                Spacer(modifier = Modifier.weight(1f))

                IconButton(
                    onClick = {
                        navController.navigate(APP_ROUTES.ABOUT_US_SCREEN)
                    }
                ) {
                    Icon(
                        contentDescription = "Om oss",
                        imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                        tint = Color(0xFF191D2B)
                    )
                }
            }

            Spacer(modifier = Modifier.padding(6.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .background(
                        color = Color(0xFFEBEFFF),
                        shape = RoundedCornerShape(size = 100.dp)
                    )
                    .padding(start = 25.dp, end = 25.dp)

            ) {
                Text(

                    modifier = Modifier
                        .width(190.dp)
                        .height(20.dp),
                    text = "Legg til aktivitet",


                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 20.sp,
                        fontWeight = FontWeight(500),
                        color = Color(0xFF191D2B),
                        letterSpacing = 0.1.sp,
                    )
                )

                Spacer(modifier = Modifier.weight(1f))

                IconButton(
                    onClick = {
                        navController.navigate(APP_ROUTES.ADD_ACTIVITY)
                    }
                ) {
                    Icon(
                        contentDescription = "Om oss",
                        imageVector =  Icons.Default.Add,
                        tint = Color(0xFF191D2B)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun SettingScreenTest() {
    SettingScreen(navController = rememberNavController())
}