package no.uio.ifi.in2000.team_21.data

import no.uio.ifi.in2000.team_21.model.Alert
import no.uio.ifi.in2000.team_21.model.AlertsInfo

class AlertsRepository(private val dataSource: AlertsDataSource) {
    suspend fun fetchAlerts(parameters: AlertsInfo): Alert? {
        // Vet ikke om det er behov for noe ekstra manipulering av data enda, men det gjøres her.
        return dataSource.fetchAlerts(parameters)
    }
}