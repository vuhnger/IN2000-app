package no.uio.ifi.in2000.team_21

import junit.framework.TestCase.assertEquals
import no.uio.ifi.in2000.team_21.data.LocationForecastDataRepository
import org.junit.Test
import kotlin.math.roundToInt


// Vi skal implementere en funksjon som konverterer et objekt med noen få værdata fra eu til american verdier

class TestForecastConversion {
    data class AmericanForecast(
        val temperature: Double,
        val wind_speed: Double,
        val perspication_amount: Double
    )

    @Test
    fun convertTemperatureToFarenheit() {


    }

}

