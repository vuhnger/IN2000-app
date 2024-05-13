package no.uio.ifi.in2000.team_21.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import no.uio.ifi.in2000.team_21.model.activity.ActivityLog

@Entity(tableName = "activity_logs")
data class UserLogEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val username: String,
    val activityName: String,
    val timestamp: String
)

@Entity(tableName = "users")
data class UserEntity(
    val name: String,
    val hobby: String,
    val history: List<ActivityLog> = listOf(),
    var password: String,
    @PrimaryKey val userName: String,
    val isActive: Boolean
)