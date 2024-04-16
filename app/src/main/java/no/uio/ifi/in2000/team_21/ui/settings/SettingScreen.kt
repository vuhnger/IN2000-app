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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import no.uio.ifi.in2000.team_21.R
import no.uio.ifi.in2000.team_21.Screen
import no.uio.ifi.in2000.team_21.ui.theme.backgroundLight
import no.uio.ifi.in2000.team_21.ui.theme.containerLight
import no.uio.ifi.in2000.team_21.ui.theme.onContainerLight
import no.uio.ifi.in2000.team_21.ui.theme.profileLight

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
                        "Innstillinger",
                        color = onContainerLight
                    )
                },
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                navController.navigate(route = Screen.HomeScreen.route)
                            }
                        ) {
                            Icon(
                                contentDescription = "Tilbake",
                                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                                tint = onContainerLight,
                                modifier = Modifier
                                    .size(30.dp)
                            )
                        }},
                colors = TopAppBarDefaults.topAppBarColors(backgroundLight)
            )},
        containerColor = backgroundLight
    ){innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(15.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .background(
                        color = containerLight,
                        shape = RoundedCornerShape(size = 20.dp)
                    )
                    .padding(start = 25.dp, end = 25.dp)

            ) {
                //fyll inn om bruker
                ProfileImage()
            }

            Spacer(modifier = Modifier.padding(6.dp))

            //Darkmode container
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .background(
                        color = containerLight,
                        shape = RoundedCornerShape(size = 20.dp)
                    )
                    .padding(start = 25.dp, end = 25.dp)

            ) {
                Text(
                    modifier = Modifier
                        .width(190.dp),
                    text = "Darkmode",

                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 20.sp,
                        fontWeight = FontWeight(500),
                        color = onContainerLight,
                        letterSpacing = 0.1.sp,
                        )
                )

                Spacer(modifier = Modifier.weight(1f))

                Switch(
                    checked = checked,
                    onCheckedChange = {
                        checked = it
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

            Spacer(modifier = Modifier.padding(6.dp))

            //Alle aktiviteter container
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .background(
                        color = containerLight,
                        shape = RoundedCornerShape(size = 20.dp)
                    )
                    .padding(start = 25.dp, end = 25.dp)
            ) {
                Text(

                    modifier = Modifier
                        .width(206.dp),
                    text = "Alle aktiviteter",

                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 20.sp,
                        fontWeight = FontWeight(500),
                        color = onContainerLight,
                        letterSpacing = 0.1.sp,
                    )
                )

                Spacer(modifier = Modifier.weight(1f))

                //endre navigasjon på alle IconButtons
                IconButton(
                    onClick = {
                        navController.navigate(route = Screen.AboutUsScreen.route)
                    },
                        modifier = Modifier.size(24.dp)
                ) {
                    Icon(
                        contentDescription = "Alle aktiviteter",
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                        tint = onContainerLight
                    )
                }
            }
            Spacer(modifier = Modifier.padding(6.dp))

            //Historikk container
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(168.dp)
                    .background(
                        color = containerLight,
                        shape = RoundedCornerShape(size = 20.dp)
                    )
                    .padding(start = 25.dp, end = 25.dp)
            ) {
                Column (){
                    //Venner
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp)
                    ) {
                        Text(
                            modifier = Modifier
                                .width(206.dp),
                            text = "Venners aktivitet",

                            style = TextStyle(
                                fontSize = 14.sp,
                                lineHeight = 20.sp,
                                fontWeight = FontWeight(500),
                                color = onContainerLight,
                                letterSpacing = 0.1.sp,
                            )
                        )
                        Spacer(modifier = Modifier.weight(1f))

                        IconButton(
                            onClick = {
                                navController.navigate(route = Screen.AboutUsScreen.route)
                            },
                            modifier = Modifier.size(24.dp)
                        ) {
                            Icon(
                                contentDescription = "Venners aktivitet",
                                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                                tint = onContainerLight
                            )
                        }
                    }
                    HorizontalDivider(
                        color = profileLight
                    )
                    //Mine
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp)
                    ) {
                        Text(

                            modifier = Modifier
                                .width(206.dp),
                            text = "Min aktivitet",

                            style = TextStyle(
                                fontSize = 14.sp,
                                lineHeight = 20.sp,
                                fontWeight = FontWeight(500),
                                color = onContainerLight,
                                letterSpacing = 0.1.sp,
                            )
                        )
                        Spacer(modifier = Modifier.weight(1f))

                        IconButton(
                            onClick = {
                                navController.navigate(route = Screen.AboutUsScreen.route)
                            },
                            modifier = Modifier.size(24.dp)
                        ) {
                            Icon(
                                contentDescription = "Min aktivitet",
                                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                                tint = onContainerLight
                            )
                        }
                    }
                    HorizontalDivider(
                        color = profileLight
                    )
                    //Badges
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp)
                    ) {
                        Text(

                            modifier = Modifier
                                .width(206.dp),
                            text = "Trofeskap",

                            style = TextStyle(
                                fontSize = 14.sp,
                                lineHeight = 20.sp,
                                fontWeight = FontWeight(500),
                                color = onContainerLight,
                                letterSpacing = 0.1.sp,
                            )
                        )
                        Spacer(modifier = Modifier.weight(1f))

                        IconButton(
                            onClick = {
                                navController.navigate(route = Screen.AboutUsScreen.route)
                            },
                            modifier = Modifier.size(24.dp)
                        ) {
                            Icon(
                                contentDescription = "Badges",
                                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                                tint = onContainerLight
                            )
                        }
                    }
            }}

            Spacer(modifier = Modifier.padding(6.dp))

            //Settings container
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(112.dp)
                    .background(
                        color = containerLight,
                        shape = RoundedCornerShape(size = 20.dp)
                    )
                    .padding(start = 25.dp, end = 25.dp)
            ) {
                Column {
                    Row (
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp)
                    ){
                        Text(
                            modifier = Modifier
                                .width(206.dp),
                            text = "Varslinger",

                            style = TextStyle(
                                fontSize = 14.sp,
                                lineHeight = 20.sp,
                                fontWeight = FontWeight(500),
                                color = onContainerLight,
                                letterSpacing = 0.1.sp,
                            )
                        )
                        Spacer(modifier = Modifier.weight(1f))

                        IconButton(
                            onClick = {
                                navController.navigate(route = Screen.AboutUsScreen.route)
                            },
                            modifier = Modifier.size(24.dp)
                        ) {
                            Icon(
                                contentDescription = "Varslinger",
                                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                                tint = onContainerLight
                            )
                        }
                    }
                    HorizontalDivider(
                        color = profileLight
                    )
                    Row (
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp)
                    ){
                        Text(

                            modifier = Modifier
                                .width(206.dp),
                            text = "Kontakter",

                            style = TextStyle(
                                fontSize = 14.sp,
                                lineHeight = 20.sp,
                                fontWeight = FontWeight(500),
                                color = onContainerLight,
                                letterSpacing = 0.1.sp,
                            )
                        )
                        Spacer(modifier = Modifier.weight(1f))

                        IconButton(
                            onClick = {
                                navController.navigate(route = Screen.AboutUsScreen.route)
                            },
                            modifier = Modifier.size(24.dp)
                        ) {
                            Icon(
                                contentDescription = "Kontakter",
                                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                                tint = onContainerLight
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.padding(6.dp))

            //About us container
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .background(
                        color = containerLight,
                        shape = RoundedCornerShape(size = 20.dp)
                    )
                    .padding(start = 25.dp, end = 25.dp)
            ) {
                Text(

                    modifier = Modifier
                        .width(206.dp),
                    text = "Om oss",

                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 20.sp,
                        fontWeight = FontWeight(500),
                        color = onContainerLight,
                        letterSpacing = 0.1.sp,
                    )
                )

                Spacer(modifier = Modifier.weight(1f))

                IconButton(
                    onClick = {
                        navController.navigate(route = Screen.AboutUsScreen.route)
                    }
                    ,
                    modifier = Modifier.size(24.dp)
                ) {
                    Icon(
                        contentDescription = "Om oss",
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                        tint = onContainerLight
                    )
                }
            }

            Spacer(modifier = Modifier.padding(6.dp))

            //Log out container
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .background(
                        color = containerLight,
                        shape = RoundedCornerShape(size = 20.dp)
                    )
                    .padding(start = 25.dp, end = 25.dp)
            ) {
                Text(

                    modifier = Modifier
                        .width(206.dp),
                    text = "Logg ut",

                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 20.sp,
                        fontWeight = FontWeight(500),
                        color = onContainerLight,
                        letterSpacing = 0.1.sp,
                    )
                )

                Spacer(modifier = Modifier.weight(1f))

                IconButton(
                    onClick = {
                        navController.navigate(route = Screen.AboutUsScreen.route)
                    }
                    ,
                    modifier = Modifier.size(24.dp)
                ) {
                    Icon(
                        contentDescription = "Logg ut",
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                        tint = onContainerLight
                    )
                }
            }
        }
    }
}

@Composable
fun ProfileImage(){
    val image = rememberSaveable {
        mutableStateOf("")
    }
    val painter = rememberAsyncImagePainter(
        if(image.value.isEmpty())
            R.drawable.user
        else{
            image.value
        }
    )
    Card(
        shape = CircleShape,
        modifier = Modifier
            .padding(8.dp)
            .size(60.dp)
        ){

    }
}

@Preview
@Composable
fun SettingScreenTest() {
    SettingScreen(navController = rememberNavController())
}