package no.uio.ifi.in2000.team_21.ui.viewmodels

import android.app.Application
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import no.uio.ifi.in2000.team_21.data.database.ActivityEntity
import no.uio.ifi.in2000.team_21.data.database.DatabaseBuilder
import no.uio.ifi.in2000.team_21.model.activity.ActivityLog
import no.uio.ifi.in2000.team_21.model.activity.ActivityModel
import no.uio.ifi.in2000.team_21.model.activity.ActivityModels


data class ActivitiesUIState(
    val activities: List<ActivityModel>,
    val favorites: MutableList<ActivityModel>,
    val activityLog: MutableList<ActivityLog>
)

class ActivitiesViewModel(application: Application) : AndroidViewModel(application) {
    private val database = DatabaseBuilder.getDatabase(application)
    private val dao = database.activitiesDao()
    val activities: LiveData<List<ActivityEntity>> = dao.getAllActivities()
    var activityUIstate by mutableStateOf(
        ActivitiesUIState(
            activities = ActivityModels.allActivities,
            favorites = mutableListOf(),
            activityLog = mutableListOf()
        )
    )
        private set

    fun log(
        time: String,
        activity: ActivityModel
    ){
        viewModelScope.launch {

            Log.d(
                "ACTIVITY_VIEW_MODEL",
                "logged activity: ${activity.activityName} at time: $time"
            )

            activityUIstate.activityLog.add(
                ActivityLog(
                    time = time,
                    activity = activity
                )
            )
        }
    }

    fun addFavorite(activity: ActivityModel){

        if (activity in activityUIstate.favorites ){

        }else{
            activityUIstate.favorites.add(activity)
        }

        Log.d(
            "ACTIVITY_VIEW_MODEL",
            "added ${activity.activityName}, favorites: ${activityUIstate.favorites}"
        )
    }

    fun removeFavorite(activity: ActivityModel){
        if (activity in activityUIstate.favorites){
            activityUIstate.favorites.remove(activity)
        }else{

        }

        Log.d(
            "ACTIVITY_VIEW_MODEL",
            "removed: ${activity.activityName}, favorites: ${activityUIstate.favorites}"
        )
    }

}