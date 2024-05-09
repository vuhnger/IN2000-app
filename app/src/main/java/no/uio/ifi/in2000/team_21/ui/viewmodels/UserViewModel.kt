package no.uio.ifi.in2000.team_21.ui.viewmodels

import androidx.lifecycle.ViewModel
import no.uio.ifi.in2000.team_21.model.user.User
import java.util.Date

class UserViewModel : ViewModel() {

    private val _users = mutableListOf<User>()

    private val defaultUser: User = User(
        id = "-1",
        name = "Standardbruker",
        hobby = "Standardhobby",
        creationDate = Date(),
        userName = "Standard brukernavn",
        password = ("ABCDEFGH").hashCode().toString().hashCode().toString()
    )

    private var userCount: Int = -1

    var currentUser: User = defaultUser

    fun createUser(
        name: String,
        hobbyDescription: String,
        userName: String,
        password: String
    ){

        val newUser = User(
            id = (userCount + 1).toString(),
            name = name,
            hobby = hobbyDescription,
            creationDate = Date(),
            userName = userName,
            password = password
        )
        _users.add(
            newUser
        )
        userCount += 1
        currentUser = newUser
    }

    fun logOut(){
        currentUser = defaultUser
    }

}