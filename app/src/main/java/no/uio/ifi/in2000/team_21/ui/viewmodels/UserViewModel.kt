package no.uio.ifi.in2000.team_21.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import no.uio.ifi.in2000.team_21.data.database.DatabaseBuilder
import no.uio.ifi.in2000.team_21.data.database.UserEntity
import no.uio.ifi.in2000.team_21.model.user.User
import java.util.Date

class UserViewModel(application: Application) : AndroidViewModel(application) {
    private val db = DatabaseBuilder.getDatabase(application)
    private val userDao = db.userDao()

    var currentUser: LiveData<UserEntity> = userDao.getCurrentUser()

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

    //var currentUser: User = defaultUser

    fun createUser(name: String, hobby: String, userName: String, password: String) {
        viewModelScope.launch {
            val newUser = UserEntity(
                name = name,
                hobby = hobby,
                userName = userName,
                password = password,
                isActive = true
            )
            userDao.deactivateAllUsers()
            userDao.insertUser(newUser)
        }
    }

    fun updateUser(user: UserEntity) {
        viewModelScope.launch {
            userDao.updateUser(user)
        }
    }

    fun logOut(){
        viewModelScope.launch {
            userDao.deactivateAllUsers()
        }
    }

    fun deleteUser(username: String) {
        viewModelScope.launch {
            userDao.deleteUser(username)
        }
    }

    fun setActiveUser(username: String) {
        viewModelScope.launch {
            userDao.setActiveUser(username)
        }
    }

    fun saveUser(user: UserEntity) {
        viewModelScope.launch {
            val existingUser = userDao.getUserByUsername(user.userName)
            if (existingUser == null) {
                userDao.insertUser(user)
            } else {
                userDao.updateUser(user)
            }
        }
    }

    fun testCreateUser(
        name: String,
        hobbyDescription: String,
        userName: String,
        password: String
    ): User {

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
        //currentUser = newUser

        return newUser
    }


    fun getUsers(): MutableList<User> {
        return _users
    }

    fun getNames(): List<String>{
        return _users.map { user -> user.name }
    }

    fun createUsername(
        name: String
    ): String{
        val primary_key: Int = userCount + 1
        return "$name${primary_key.toString().hashCode()}"
    }

}