package no.uio.ifi.in2000.team_21.ui.viewmodels

import android.app.Application
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asFlow
import androidx.lifecycle.asLiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import no.uio.ifi.in2000.team_21.data.database.ActivityEntity
import no.uio.ifi.in2000.team_21.data.database.DatabaseBuilder
import no.uio.ifi.in2000.team_21.data.database.UserLogEntity
import no.uio.ifi.in2000.team_21.model.activity.ActivityLog
import no.uio.ifi.in2000.team_21.model.activity.ActivityModel
import no.uio.ifi.in2000.team_21.model.activity.ActivityModels
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter


data class ActivitiesUIState(
    val activities: List<ActivityModel>,
    val favorites: MutableList<ActivityModel>,
    val activityLog: MutableList<ActivityLog>
)
@OptIn(ExperimentalCoroutinesApi::class)
class ActivitiesViewModel(application: Application) : AndroidViewModel(application) {
    private val database = DatabaseBuilder.getDatabase(application)
    private val dao = database.activitiesDao()
    private val logDao = database.userLogDao()
    private val userDao = database.userDao()
    private val _userLogs = MutableLiveData<List<UserLogEntity>>()
    private val _currentUser = userDao.getCurrentUser().asFlow()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), null)
    val userLogs: LiveData<List<UserLogEntity>> = _currentUser.flatMapLatest { user ->
        if (user != null) {
            logDao.getUserLogs(user.userName).asFlow()
        } else {
            flowOf(emptyList())
        }
    }.asLiveData(viewModelScope.coroutineContext)
    val favorites: LiveData<List<ActivityEntity>> = dao.getAllActivities()

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

    fun logActivity(username: String, activity: ActivityModel) {
        val norwayZone = ZoneId.of("Europe/Oslo")
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm").withZone(norwayZone)
        val time = ZonedDateTime.now(norwayZone).format(formatter)
        viewModelScope.launch {
            val logEntry = UserLogEntity(
                username = username,
                activityName = activity.activityName,
                timestamp = time
            )
            logDao.logActivity(logEntry)
        }
    }

    fun getActivityLogs(username: String) {
        viewModelScope.launch {
            val logs = logDao.getUserLogs(username).value ?: emptyList()
            _userLogs.postValue(logs)
        }
    }

    fun loadUserLogs() {
        userDao.getCurrentUser().observeForever { user ->
            if (user != null) {
                getActivityLogs(user.userName)
            }
        }
    }
}