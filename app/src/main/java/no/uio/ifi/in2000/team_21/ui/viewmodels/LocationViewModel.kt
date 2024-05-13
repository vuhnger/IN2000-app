package no.uio.ifi.in2000.team_21.ui.viewmodels

import android.Manifest
import android.app.Application
import android.content.Context
import android.content.pm.PackageManager
import android.location.Geocoder
import android.os.Looper
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.lifecycle.AndroidViewModel
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import com.mapbox.geojson.Point
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException
import java.util.Locale

class LocationViewModel(application: Application): AndroidViewModel(application) {
    private val _userLocation = MutableStateFlow<Point?>(null)
    val userLocation: StateFlow<Point?> = _userLocation.asStateFlow()

    private val _currentCityName = MutableStateFlow<String?>("")
    val currentCityName: StateFlow<String?> = _currentCityName.asStateFlow()

    init {
        fetchLocation()
    }

    private fun fetchLocation() {
        val fusedLocationClient = LocationServices.getFusedLocationProviderClient(getApplication<Application>().applicationContext)
        val locationRequest = LocationRequest.create().apply {
            interval = 10000
            fastestInterval = 5000
            priority = Priority.PRIORITY_HIGH_ACCURACY
        }

        val locationCallback = object : LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult) {
                locationResult.locations.firstOrNull()?.let { location ->
                    _userLocation.value = Point.fromLngLat(location.longitude, location.latitude)

                    // Fetch city name in a coroutine
                    CoroutineScope(Dispatchers.IO).launch {
                        val city = getCityName(location.latitude, location.longitude, getApplication())
                        withContext(Dispatchers.Main) {// TODO: Sjekk om dette er lurt
                            _currentCityName.value = city

                            Log.d("LOC_VM","found city name: $city for lat: ${location.latitude} long: ${location.longitude}")
                        }
                    }
                }
            }
        }

        if (ActivityCompat.checkSelfPermission(getApplication(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            fusedLocationClient.requestLocationUpdates(locationRequest, locationCallback, Looper.getMainLooper())
        } else {

        }
    }

    private fun getCityName(lat: Double, lon: Double, context: Context): String {
        val geocoder = Geocoder(context, Locale.getDefault())
        return try {
            val addresses = geocoder.getFromLocation(lat, lon, 1)

            if(addresses?.firstOrNull()?.subLocality == null && addresses?.firstOrNull()?.adminArea == null){
                "Kunne ikke hente områdenavn"
            }

            else if(addresses?.firstOrNull()?.subLocality == null){
                "${addresses?.firstOrNull()?.adminArea}"
            }

            else{
                "${addresses?.firstOrNull()?.adminArea} (${addresses?.firstOrNull()?.subLocality})"
            }


        } catch (e: IOException) {
            e.printStackTrace()
            "Kunne ikke hente stedstjenester"
        }
    }
}
