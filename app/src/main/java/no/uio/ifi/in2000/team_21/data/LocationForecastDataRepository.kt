package no.uio.ifi.in2000.team_21.data

import android.util.Log
import no.uio.ifi.in2000.team_21.model.locationforecast.Response
import no.uio.ifi.in2000.team_21.model.locationforecast.Timeseries

class LocationForecastDataRepository(private val dataSource: LocationForecastDataSource = LocationForecastDataSource()) {


    suspend fun fetchForecast(): Response? {
        return dataSource.fetchForecast()
    }

    // Timeseries er værmeldinger
    suspend fun fetchTimeseries(): ArrayList<Timeseries>? {
        return dataSource.fetchForecast()?.properties?.timeseries
    }

    suspend fun fetchImageIcons(): ArrayList<String> {
        val timeseries = fetchTimeseries()
        val icons = ArrayList<String>()

        Log.d("LOCATION_REPO", "timeseries: ${timeseries?.size}")

        timeseries?.forEach { timeseries ->
            timeseries.data?.next_1_hours?.summary?.symbol_code?.let { symbolCode ->
                println(symbolCode)
                // Add only if symbolCode is not null
                icons.add(symbolCode)
            }
        }
        Log.d("LOCATION_REPO","fetched ${icons.size} icons")
        return icons
    }

}