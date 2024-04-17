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
}
