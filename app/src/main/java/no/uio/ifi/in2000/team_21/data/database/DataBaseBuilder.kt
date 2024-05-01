package no.uio.ifi.in2000.team_21.data.database

import android.content.Context
import androidx.room.Room

object DatabaseBuilder {
    @Volatile
    private var INSTANCE: AppDatabase? = null

    fun getDatabase(context: Context): AppDatabase {
        return INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "app_database")
                .fallbackToDestructiveMigration() // Use this during development or if data preservation is not necessary
                .build()
            INSTANCE = instance
            instance
        }
    }

}
