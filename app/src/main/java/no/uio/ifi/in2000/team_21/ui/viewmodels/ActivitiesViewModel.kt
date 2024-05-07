package no.uio.ifi.in2000.team_21.ui.viewmodels

import android.app.Application
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
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
    val favorites: LiveData<List<ActivityEntity>> = dao.getAllActivities()

    init {
        loadFavorites()
    }

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
        viewModelScope.launch {
            if (!dao.activityExists(activity.activityName)) {
                dao.addActivity(ActivityEntity(name = activity.activityName))
            }
        }
    }

    fun removeFavorite(activityName: String){
        viewModelScope.launch {
            if (dao.activityExists(activityName)) {
                dao.deleteByName(activityName)
            }
        }
    }

    fun isFavorite(activityName: String): LiveData<Boolean> {
        return favorites.map { favoritesList ->
            favoritesList.any { it.name == activityName }
        }
    }

    private fun loadFavorites() {
        viewModelScope.launch(Dispatchers.IO) {
           // _favorites.value = dao.getAllActivities()
        }
    }

    fun getActivityModelByName(activityName: String): ActivityModel? {
        return ActivityModels.find(activityName)
    }
}