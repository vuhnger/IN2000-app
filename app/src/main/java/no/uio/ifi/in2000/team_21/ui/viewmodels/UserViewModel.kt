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
        creationDate = Date()
    )

    private var userCount: Int = -1

    val currentUser: User = defaultUser

    fun createUser(
        id: String,
        name: String,
        hobbyDescription: String,
        creationDate: Date
    ){
        _users.add(
            User(
                id = (userCount + 1).toString(),
                name = name,
                hobby = hobbyDescription,
                creationDate = Date()
            )
        )
        userCount = userCount + 1
    }



}