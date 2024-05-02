package no.uio.ifi.in2000.team_21.data

import android.util.Log
import no.uio.ifi.in2000.team_21.model.oceanforecast.OceanForecastResponse
import no.uio.ifi.in2000.team_21.model.oceanforecast.Timeseries



class OceanForecastRepository(
    private val dataSource: OceanForecastDataSource = OceanForecastDataSource()
) {

    suspend fun fetchOceanForecastResponse(latitude: Double, longitude: Double): OceanForecastResponse? {
        Log.d("OCEANFORCAST_REPO", "fetching OceanForecast responses...")
        return dataSource.fetchOceanForecastResponse(latitude, longitude)
    }

    suspend fun fetchOceanForecastTimeseries(latitude: Double, longitude: Double): List<Timeseries>? {
        Log.d("OCEANFORECAST_REPO", "fetching OceanForecast timeseries...")
        return dataSource.fetchOceanForecastTimeseries(latitude, longitude)
    }

    suspend fun fetchOceanForecastTimeseriesByTime(time: String, latitude: Double, longitude: Double): Timeseries? {
        return dataSource.fetchOceanForecastByTime(time, latitude, longitude)
    }
}
