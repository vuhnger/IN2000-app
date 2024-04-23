package no.uio.ifi.in2000.team_21.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "locations")
data class UserMarker(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val latitude: Double,
    val longitude: Double
)
