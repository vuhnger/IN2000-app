package no.uio.ifi.in2000.team_21.data.database

import androidx.room.TypeConverter
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken
import com.google.gson.Gson
import no.uio.ifi.in2000.team_21.model.activity.ActivityLog

class ActivityLogConverter {
    private val gson = Gson()

    @TypeConverter
    fun activityLogToString(activityLog: ActivityLog): String {
        return gson.toJson(activityLog)
    }

    @TypeConverter
    fun stringToActivityLog(data: String): ActivityLog {
        return gson.fromJson(data, ActivityLog::class.java)
    }

    @TypeConverter
    fun activityLogListToString(activityLogs: List<ActivityLog>): String {
        return gson.toJson(activityLogs)
    }

    @TypeConverter
    fun stringToActivityLogList(data: String): List<ActivityLog> {
        val listType = object : TypeToken<List<ActivityLog>>() {}.type
        return gson.fromJson(data, listType)
    }
}