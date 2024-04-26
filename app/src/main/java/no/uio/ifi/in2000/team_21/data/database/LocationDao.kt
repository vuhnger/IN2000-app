package no.uio.ifi.in2000.team_21.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface LocationDao {
    @Query("SELECT * FROM locations")
    suspend fun getAll(): List<UserMarkerEntity>

    @Insert
    suspend fun insert(vararg locations: UserMarkerEntity)

    @Update
    suspend fun update(location: UserMarkerEntity)

    @Delete
    suspend fun delete(location: UserMarkerEntity)

    @Query("DELETE FROM locations WHERE latitude = :lat AND longitude = :lng")
    suspend fun deleteByLatLong(lat: Double, lng: Double)
}