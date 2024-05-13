package no.uio.ifi.in2000.team_21

import no.uio.ifi.in2000.team_21.ui.viewmodels.UserViewModel
import org.junit.Test


// Vi skal implementere en funksjon som lager et unikt brukernavn, gitt et navn, ved bruk av f.eks primærnøkkel

class TestUsernameCreation {

    val userViewModel: UserViewModel = UserViewModel()
    val name: String = "Jonas"

    val testUser = userViewModel.testCreateUser(
        name = "Jonas",
        hobbyDescription = "Fisker",
        userName = userViewModel.createUsername("Jonas"),
        password = "Passord123"
    )

    @Test
    fun testUsernameCreation(){
        val unique_username: String = userViewModel.createUsername(name)
        println("test: ${testUser.userName}, result: $unique_username")
        assert(unique_username != testUser.userName)
    }

}





