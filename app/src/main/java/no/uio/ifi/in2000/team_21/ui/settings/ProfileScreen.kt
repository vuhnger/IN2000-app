package no.uio.ifi.in2000.team_21.ui.settings

import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults.cardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import no.uio.ifi.in2000.team_21.R
import no.uio.ifi.in2000.team_21.data.database.UserEntity
import no.uio.ifi.in2000.team_21.ui.theme.Background
import no.uio.ifi.in2000.team_21.ui.theme.MidnightBlue
import no.uio.ifi.in2000.team_21.ui.theme.White
import no.uio.ifi.in2000.team_21.ui.viewmodels.UserViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen (
    navController: NavController,
    userViewModel: UserViewModel
) {
    val user by userViewModel.currentUser.observeAsState()
    var name by rememberSaveable { mutableStateOf(user?.name ?: "") }
    var hobby by rememberSaveable { mutableStateOf(user?.hobby ?: "") }
    var username by rememberSaveable { mutableStateOf(user?.userName ?: "") }
    var password by rememberSaveable { mutableStateOf("") }


    val FUNCTION_NAME = object {}.javaClass.enclosingMethod.name

    val notification = rememberSaveable { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current

    if (notification.value.isNotEmpty()) {
        Toast.makeText(LocalContext.current, notification.value, Toast.LENGTH_LONG).show()
        notification.value = ""
        
    }

    Log.d(
        FUNCTION_NAME,
        "called"
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Profil",
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
                colors = TopAppBarDefaults.topAppBarColors(Background)
            )
        },
        containerColor = Background
    ) {innerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(innerPadding)
                .padding(15.dp)
                .fillMaxWidth()
        ){
            EditProfileImage()


            OutlinedTextField(

                value = name,
                onValueChange = {
                    name = it
                },
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(
                    onDone = {keyboardController?.hide()}
                ),
                label = { Text("Navn", color = MidnightBlue) },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = MidnightBlue,
                    unfocusedTextColor = MidnightBlue,
                    disabledTextColor = MidnightBlue,
                    unfocusedBorderColor = MidnightBlue,
                    focusedBorderColor = MidnightBlue,
                    focusedContainerColor = White,
                    unfocusedContainerColor = White
                ),

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 40.dp)
            )

            OutlinedTextField(
                value = hobby,
                onValueChange = {
                    hobby = it
                },
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(
                    onDone = {keyboardController?.hide()}
                ),
                label = { Text("Hobby", color = MidnightBlue) },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = MidnightBlue,
                    unfocusedTextColor = MidnightBlue,
                    disabledTextColor = MidnightBlue,
                    unfocusedBorderColor = MidnightBlue,
                    focusedBorderColor = MidnightBlue,
                    focusedContainerColor = White,
                    unfocusedContainerColor = White
                ),

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 40.dp)
            )

            OutlinedTextField(

                value = username,
                onValueChange = {
                    username = it
                },
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(
                    onDone = {keyboardController?.hide()}
                ),
                label = { Text("Brukernavn", color = MidnightBlue) },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = MidnightBlue,
                    unfocusedTextColor = MidnightBlue,
                    disabledTextColor = MidnightBlue,
                    unfocusedBorderColor = MidnightBlue,
                    focusedBorderColor = MidnightBlue,
                    focusedContainerColor = White,
                    unfocusedContainerColor = White
                ),

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 40.dp)
            )

            OutlinedTextField(
                value = password,
                onValueChange = {
                    password = it
                },
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(
                    onDone = {keyboardController?.hide()}
                ),
                label = { Text("Passord", color = MidnightBlue) },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = MidnightBlue,
                    unfocusedTextColor = MidnightBlue,
                    disabledTextColor = MidnightBlue,
                    unfocusedBorderColor = MidnightBlue,
                    focusedBorderColor = MidnightBlue,
                    focusedContainerColor = White,
                    unfocusedContainerColor = White
                ),

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 40.dp)
            )


            OutlinedButton(
                onClick = {
                    notification.value = "Profil oppdatert"
                    userViewModel.saveUser(
                        UserEntity(
                            name = name,
                            hobby = hobby,
                            userName = username,
                            password = password,
                            isActive = true
                        )
                    )
                },
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Background,
                    containerColor = MidnightBlue,

                ),
                modifier = Modifier
                    .padding(top = 40.dp)
            ) {
                Text("Lagre")
            }
        }
    }
}

@Composable
fun EditProfileImage(){

    val IMAGE_DEFAULT_VALUE = ""

    val image = rememberSaveable {
        mutableStateOf("")
    }

    val painter = if(!image.value.lowercase().equals("null")){
        painterResource(id = R.drawable.user)
    } else{
        painterResource(id = image.value.toInt())
    }

    val launcher = rememberLauncherForActivityResult(
        ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let { image.value = it.toString()}
    }

    Card(
        shape = CircleShape,
        elevation = cardElevation(
            pressedElevation = 30.dp
        ),
        colors = CardColors(
            contentColor = MidnightBlue,
            containerColor = MidnightBlue,
            disabledContainerColor = MidnightBlue,
            disabledContentColor = MidnightBlue
        ),
        modifier = Modifier
            .size(120.dp)
            .clickable { launcher.launch("Image/*") }
    ){
        Image(painter = painter,
            contentDescription = null,
            modifier = Modifier
                .wrapContentSize()
                .padding(20.dp)
                .size(80.dp)
                .clip(CircleShape),
                //.clickable { },
            contentScale = ContentScale.Crop
        )
    }
}


@Composable
fun EditTextField(text: String) {
    var text by rememberSaveable {
        mutableStateOf(text)
    }

}

@Preview
@Composable
fun ProfileScreenTest() {
    //ProfileScreen(navController = rememberNavController())
}