package no.uio.ifi.in2000.team_21.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ActivitiesDao {
    @Query("SELECT EXISTS(SELECT 1 FROM activities WHERE name = :name)")
    suspend fun activityExists(name: String): Boolean

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addActivity(activity: ActivityEntity)

    @Query("SELECT * FROM activities")
    fun getAllActivities(): LiveData<List<ActivityEntity>>

    @Delete
    suspend fun delete(activity: ActivityEntity)

    @Query("DELETE FROM activities WHERE name = :name")
    suspend fun deleteByName(name: String)
}
