package no.uio.ifi.in2000.team_21.ui.home

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import no.uio.ifi.in2000.team_21.model.activity.ActivityLog
import no.uio.ifi.in2000.team_21.model.activity.ActivityModel
import no.uio.ifi.in2000.team_21.model.activity.ActivityModels


data class ActivitiesUIState(
    val activities: List<ActivityModel>,
    val favorites: MutableList<ActivityModel>,
    val activityLog: MutableList<ActivityLog>
)

class ActivitiesViewModel(

) : ViewModel() {

    var activityUIstate by mutableStateOf(
        ActivitiesUIState(
            activities = ActivityModels.allActivities,
            favorites = mutableListOf(),
            activityLog = mutableListOf()
        )
    )
        private set

    // TODO: Lage konstruktør som henter værdata


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
            "favorites: ${activityUIstate.favorites}"
        )
    }
    fun getWeatherData(){
        viewModelScope.launch {
            // TODO: Hent relevant værdata og legg det i kortene

            activityUIstate = activityUIstate.copy(
                activities = mutableListOf()// TODO: Oppdater aktivitetene med værdata i
            )
        }
    }
}