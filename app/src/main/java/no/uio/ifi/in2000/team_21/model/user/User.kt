package no.uio.ifi.in2000.team_21.model.user

import no.uio.ifi.in2000.team_21.model.activity.ActivityLog
import java.util.Date

data class User(
    val id: String,
    val name: String,
    val hobby: String,
    val creationDate: Date,
    val history: List<ActivityLog> = listOf(),
    val password: String,
    val userName: String
)
