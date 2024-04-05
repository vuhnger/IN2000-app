package no.uio.ifi.in2000.team_21.data
/*
import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import android.os.Looper
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationListener
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority

class LocationManager(context: Context) {

    private val fusedLocationClient: FusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context)
    private val locationData = MutableLiveData<Location>()
    private val appContext = context.applicationContext
    val currentLocation: LiveData<Location> = locationData

    private val locationCallback = object : LocationCallback() {
        override fun onLocationResult(locationResult: LocationResult) {
            locationResult ?: return
            for (location in locationResult.locations) {
                Log.d("LOCATION:MANAGER", "Location: $location")
                locationData.postValue(location)
            }
        }
    }

    @SuppressLint("MissingPermission")
    fun startLocationUpdates(locationUpdateListener: LocationListener) {
        Log.d("LOCATION MANAGER", "STARTING LOCATION UPDATES")
        val locationRequest = LocationRequest.Builder(1000L)
            .setMaxUpdateDelayMillis(5000L)
            .setPriority(Priority.PRIORITY_HIGH_ACCURACY)
            .build()
        fusedLocationClient.requestLocationUpdates(locationRequest, locationUpdateListener/*locationCallback*/, Looper.getMainLooper())
    }

    fun stopLocationUpdates(locationUpdateListener: LocationListener) {
        Log.d("LOCATION MANAGER", "STOPPING LOCATION UPDATES")
        fusedLocationClient.removeLocationUpdates(locationUpdateListener)
    }
}

 */