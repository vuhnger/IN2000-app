package no.uio.ifi.in2000.team_21.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [UserMarkerEntity::class], version = 6)
abstract class AppDatabase : RoomDatabase() {
    abstract fun locationDao(): LocationDao
}