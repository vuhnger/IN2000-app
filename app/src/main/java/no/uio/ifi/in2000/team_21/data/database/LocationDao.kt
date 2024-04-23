package no.uio.ifi.in2000.team_21.data.database

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

interface LocationDao {
    @Query("SELECT * FROM locations")
    fun getAll(): List<UserMarker>

    @Insert
    fun insert(vararg locations: UserMarker)

    @Update
    fun update(location: UserMarker)

    @Delete
    fun delete(location: UserMarker)
}