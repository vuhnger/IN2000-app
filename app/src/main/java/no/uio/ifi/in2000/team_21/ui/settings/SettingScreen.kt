package no.uio.ifi.in2000.team_21.ui.settings

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
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
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
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
                        }},
                colors = TopAppBarDefaults.topAppBarColors(backgroundLight),
            )},
        containerColor = backgroundLight,
    ){
            innerPadding->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
                .padding(innerPadding)
        ){
            //Profile
            ProfileCard(navController)
            Spacer(modifier = Modifier.padding(6.dp))


            //Darkmode
            DarkModeCard(navController,
                checked = remember {mutableStateOf(checked)}
            )
            Spacer(modifier = Modifier.padding(6.dp))


            //All activities
            AllSettingsCard(navController,
                mainText = "Alle aktiviteter",
                onClick = {
                    //handle event
                }
            )
            Spacer(modifier = Modifier.padding(6.dp))
            //History
            HistorySettings(navController)
            Spacer(modifier = Modifier.padding(6.dp))


            //Settings
            SettingsGroupCard(navController)
            Spacer(modifier = Modifier.padding(6.dp))


            AllSettingsCard(navController,
                mainText = "Om oss",
                onClick = {
                    //handle event
                }
            )
            Spacer(modifier = Modifier.padding(6.dp))
            AllSettingsCard(navController,
                mainText = "Logg ut",
                onClick = {
                    //handle event
                },
            )
        }
    }
}


//Profile
@Composable
fun ProfileCard(navController: NavController){
    Card(
        onClick = {},
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp),
        colors = CardColors(
            contentColor = containerLight,
            containerColor = containerLight,
            disabledContainerColor = containerLight,
            disabledContentColor = containerLight
        )
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 25.dp, end = 25.dp, top = 10.dp, bottom = 10.dp)
        ) {
            ProfileImage()
            Column {
                Text(
                    modifier = Modifier
                        .width(190.dp)
                        .padding(bottom = 5.dp, start = 15.dp),
                    text = "Ola Nordmann",


                    style = TextStyle(
                        fontSize = 18.sp,
                        lineHeight = 20.sp,
                        fontWeight = FontWeight(500),
                        color = onContainerLight,
                        letterSpacing = 0.1.sp
                    )
                )
                Text(
                    modifier = Modifier
                        .width(190.dp)
                        .padding(start = 15.dp),
                    text = "Fritidsfisker",
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 20.sp,
                        color = onContainerLight,
                        letterSpacing = 0.1.sp
                    )
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                contentDescription = "Min profil",
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                tint = onContainerLight
            )
        }
    }
}


//DarkMode
@Composable
fun DarkModeCard(navController: NavController, checked: MutableState<Boolean>){
    Card(onClick = {},
        modifier = Modifier
            .clickable { }
            .fillMaxWidth()
            .height(56.dp),
        colors = CardColors(
            contentColor = containerLight,
            containerColor = containerLight,
            disabledContainerColor = containerLight,
            disabledContentColor = containerLight)
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
                text = "Darkmode",
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


//All settings-cards
@Composable
fun AllSettingsCard(navController: NavController, mainText: String, onClick:()->Unit){
    Card(
        onClick = {
            onClick()
        },
        modifier = Modifier
            .clickable { }
            .fillMaxWidth()
            .height(56.dp),
        colors = CardColors(
            contentColor = containerLight,
            containerColor = containerLight,
            disabledContainerColor = containerLight,
            disabledContentColor = containerLight)
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 25.dp, end = 25.dp, top = 15.dp, bottom = 15.dp)
        ) {
            Text(
                modifier = Modifier
                    .width(190.dp),
                text = mainText,
                style = TextStyle(
                    fontSize = 15.sp,
                    lineHeight = 20.sp,
                    fontWeight = FontWeight(500),
                    color = onContainerLight,
                    letterSpacing = 0.1.sp
                )
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                contentDescription = mainText,
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                tint = onContainerLight
            )
        }
    }
}
//History settings
//Ikke helt happy med hvordan kortene ligge over hverandre, kommer tydelig frem når man klikker på dem
@Composable
fun HistorySettings(navController: NavController){
    Card(
        modifier = Modifier
            //.clickable { }
            .fillMaxWidth()
            .height(168.dp),
        colors = CardColors(
            contentColor = containerLight,
            containerColor = containerLight,
            disabledContainerColor = containerLight,
            disabledContentColor = containerLight)
    ){ Column (){
        //Friends
        AllSettingsCard(navController,
            mainText = "Venners aktivitet",
            onClick = {
                //handle event
            }
        )
        HorizontalDivider(
            color = profileLight,
            modifier = Modifier
                .padding(start = 25.dp, end = 25.dp)
        )
        //Me
        AllSettingsCard(navController,
            mainText = "Min aktivitet",
            onClick = {
                //handle event
            }
        )
        HorizontalDivider(
            color = profileLight,
            modifier = Modifier
                .padding(start = 25.dp, end = 25.dp)
        )
        //Badges
        AllSettingsCard(navController,
            mainText = "Trofeskap",
            onClick = {
                //handle event
            }
        )
    }}
}
//Other settings
@Composable
fun SettingsGroupCard(navController: NavController){
    Card(
        modifier = Modifier
            .clickable { }
            .fillMaxWidth()
            .height(112.dp),
        colors = CardColors(
            contentColor = containerLight,
            containerColor = containerLight,
            disabledContainerColor = containerLight,
            disabledContentColor = containerLight)
    ){Column{
        //Notifications
        AllSettingsCard(navController,
            mainText = "Varslinger",
            onClick = {
                //handle event
            }
        )
        HorizontalDivider(
            color = profileLight,
            modifier = Modifier
                .padding(start = 25.dp, end = 25.dp)
        )
        //Contacts
        AllSettingsCard(navController,
            mainText = "Kontakter",
            onClick = {
                //handle event
            }
        )
    } }
}


@Composable
fun ProfileImage(){
    val image = rememberSaveable {
        mutableStateOf("")
    }
    val painter = if(image.value.isEmpty()){
        painterResource(id = R.drawable.user)
    } else{
        painterResource(id = image.value.toInt())
    }
    
    Card(
        shape = CircleShape,
        colors = CardColors(
            contentColor = profileLight,
            containerColor = profileLight,
            disabledContainerColor = profileLight,
            disabledContentColor = profileLight
        ),
        modifier = Modifier
            .size(60.dp)
    ){
        Image(painter = painter,
            contentDescription = null,
            modifier = Modifier
                .wrapContentSize()
                .padding(15.dp)
                .size(30.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
    }
}

@Preview
@Composable
fun SettingScreenTest() {
    SettingScreen(navController = rememberNavController())
}