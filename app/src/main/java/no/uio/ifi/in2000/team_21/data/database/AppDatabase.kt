package no.uio.ifi.in2000.team_21.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [UserMarkerEntity::class, ActivityEntity::class, UserLogEntity::class, UserEntity::class], version = 11)
@TypeConverters(ActivityLogConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun locationDao(): LocationDao

    abstract fun activitiesDao(): ActivitiesDao

    abstract fun userLogDao(): UserLogDao

    abstract fun userDao(): UserDao
}