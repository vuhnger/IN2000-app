package no.uio.ifi.in2000.team_21.container

import no.uio.ifi.in2000.team_21.data.AlertsDataSource
import no.uio.ifi.in2000.team_21.data.AlertsRepository

object RepositoryContainer {
    /*private var alertsRepository: AlertsRepository? = null

    fun getAlertsRepository(dataSource: AlertsDataSource): AlertsRepository {
        if (alertsRepository == null) {
            alertsRepository = AlertsRepository(dataSource)
        }
        return alertsRepository!!
    }*/

    val alertsDataSource by lazy {
        AlertsDataSource()
    }

    val alertsRepository by lazy {
        AlertsRepository(alertsDataSource)
    }
}