package no.uio.ifi.in2000.team_21.data

import android.util.Log
import no.uio.ifi.in2000.team_21.model.oceanforecast.Response
import no.uio.ifi.in2000.team_21.model.oceanforecast.Timeseries


class OceanForecastRepository(private val dataSource: OceanForecastDataSource = OceanForecastDataSource()) {

    suspend fun fetchOceanForecastResponse(): Response? {
        Log.d("OCEANFORCAST_REPO", "fetching OceanForecast responses...")
        return dataSource.fetchOceanForecastResponse()
    }

    suspend fun fetchOceanForecastTimeseries(): ArrayList<Timeseries>? {
        Log.d("OCEANFORECAST_REPO", "fetching OceanForecast timeseries...")
        return dataSource.fetchOceanForecastTimeseries()
    }

    fun setCoordinates(newLatitude: Double, newLongitude: Double) {
        Log.d("OCEANFORCAST_REPO", "Setting coordinates to lat: $newLatitude, lon: $newLongitude")
        dataSource.setCoordinates(newLatitude, newLongitude)
    }

    suspend fun fetchSeaWaterTemperatureAtTime(time: String): Double? {
        val timeseries = fetchOceanForecastTimeseries()
        return timeseries?.find { it.time == time }?.data?.instant?.details?.sea_water_temperature
    }

    suspend fun fetchSeaSurfaceWaveHeightAtTime(time: String): Double? {
        val timeseries = fetchOceanForecastTimeseries()
        return timeseries?.find { it.time == time }?.data?.instant?.details?.sea_surface_wave_height
    }

    suspend fun fetchTimeseriesForTimeRange(startTime: String, endTime: String): ArrayList<Timeseries>? {
        val allTimeseries = fetchOceanForecastTimeseries()
        return allTimeseries?.filter { it.time.toString() in startTime..endTime } as ArrayList<Timeseries>?
    }

    suspend fun fetchAverageWaveHeightAndSeaState(startTime: String, endTime: String): Pair<Double?, String> {
        val timeseries = fetchTimeseriesForTimeRange(startTime, endTime)
        val averageWaveHeight = timeseries?.mapNotNull { it.data?.instant?.details?.sea_surface_wave_height }?.average()

        val seaState = when {
            averageWaveHeight == null -> "No data"
            averageWaveHeight <= 0 -> "Havblikk"
            averageWaveHeight <= 0.1 -> "Småkruset sjø"
            averageWaveHeight <= 0.5 -> "Smul sjø"
            averageWaveHeight <= 1.25 -> "Svak sjø"
            averageWaveHeight <= 2.5 -> "Noe sjø"
            averageWaveHeight <= 4 -> "Mye sjø"
            averageWaveHeight <= 6 -> "Høy sjø"
            averageWaveHeight <= 9 -> "Svært hav"
            averageWaveHeight <= 14 -> "Veldig opprørt hav"
            else -> "Overordentlig opprørt hav"
        }

        return Pair(averageWaveHeight, seaState)
    }
}
