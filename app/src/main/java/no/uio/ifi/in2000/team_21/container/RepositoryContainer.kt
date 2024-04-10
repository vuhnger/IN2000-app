package no.uio.ifi.in2000.team_21.container

import no.uio.ifi.in2000.team_21.data.AlertsDataSource
import no.uio.ifi.in2000.team_21.data.AlertsRepository

object RepositoryContainer {
    val alertsDataSource by lazy {
        AlertsDataSource()
    }

    val alertsRepository by lazy {
        AlertsRepository(alertsDataSource)
    }
}