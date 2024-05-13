package no.uio.ifi.in2000.team_21

import junit.framework.TestCase.assertEquals
import no.uio.ifi.in2000.team_21.model.activity.ActivityModels
import org.junit.Test

class TestActivityModels {
    @Test
    fun testFlagDataForKayaking_ShouldReturnExpectedFlagData() {

        // Arrange
        val activity = ActivityModels.KAYAKING
        val expectedFlagColorId = R.drawable.svg_red_flag_icon
        val expectedFlagDescription = "Vær forsiktig og følg advarsler"

        // Act
        val (actualFlagColorId, actualFlagDescription) = activity.getFlagData()

        // Assert
        assertEquals(expectedFlagColorId, actualFlagColorId)
        assertEquals(expectedFlagDescription, actualFlagDescription)
    }
}