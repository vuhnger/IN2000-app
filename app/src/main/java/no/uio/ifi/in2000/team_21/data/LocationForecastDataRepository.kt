package no.uio.ifi.in2000.team_21.data

import no.uio.ifi.in2000.team_21.model.locationforecast.Response

class LocationForecastDataRepository(private val dataSource: LocationForecastDataSource = LocationForecastDataSource()) {

    suspend fun fetchForecast(): Response? {
        return dataSource.fetchForecast()
    }

}