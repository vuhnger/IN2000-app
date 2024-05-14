package no.uio.ifi.in2000.team_21.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserLogDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun logActivity(userLogEntity: UserLogEntity)

    @Query("SELECT * FROM activity_logs WHERE username = :username ORDER BY id DESC")
    fun getUserLogs(username: String): LiveData<List<UserLogEntity>>
}

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUser(user: UserEntity)

    @Query("SELECT * FROM users WHERE isActive = 1 LIMIT 1")
    fun getCurrentUser(): LiveData<UserEntity>

    @Query("SELECT * FROM users WHERE userName = :userName")
    suspend fun getUserByUsername(userName: String): UserEntity?

    @Query("UPDATE users SET isActive = 0")
    suspend fun deactivateAllUsers()

    @Query("UPDATE users SET isActive = 1 WHERE userName = :userName")
    suspend fun setActiveUser(userName: String)

    @Query("DELETE FROM users WHERE userName = :userName")
    suspend fun deleteUser(userName: String)

    @Update
    suspend fun updateUser(user: UserEntity)
}