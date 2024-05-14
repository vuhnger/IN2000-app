package no.uio.ifi.in2000.team_21

import junit.framework.TestCase.assertEquals
import no.uio.ifi.in2000.team_21.model.activity.ActivityModels
import no.uio.ifi.in2000.team_21.model.activity.ConditionStatus
import no.uio.ifi.in2000.team_21.ui.viewmodels.ActivityConditionCheckerViewModel
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class TestConditionChecker {
    lateinit var viewModel: ActivityConditionCheckerViewModel

    @Before
    fun setUp() {
        viewModel = ActivityConditionCheckerViewModel()
    }

    @Test
    fun testActivityListSize_ShouldContainNineActivities() {

        // Arrange
        val expectedSize = 9

        // Act
        val actualSize = viewModel.activities.value?.size

        // Assert
        assertEquals(expectedSize, actualSize)
    }

    @Test
    fun testGetActivityByName_ShouldReturnKayakingActivity() {

        // Arrange
        val activityName = "Kajakk"
        val expectedActivity = ActivityModels.KAYAKING

        // Act
        val actualActivity = viewModel.get(activityName)

        // Assert
        assertEquals(expectedActivity, actualActivity)
    }

    @Test
    fun testWeatherOptimalForActivity_ShouldReturnAllMet() {

        // Arrange
        val activity = ActivityModels.KAYAKING
        val allMetWeatherDetails = WeatherDetailsMockData.favorableWeather

        // Act
        val conditionsMet = viewModel.getWeatherConditionsMet(allMetWeatherDetails, activity)
        val conditionStatus = viewModel.isWeatherOptimalForActivity(conditionsMet)

        // Assert
        assertEquals(ConditionStatus.ALL_MET, conditionStatus)
    }

    @Test
    fun testWeatherOptimalForActivity_ShouldReturnSomeMet() {

        // Arrange
        val activity = ActivityModels.KAYAKING
        val someMetWeatherDetails = WeatherDetailsMockData.unfavorableWeather

        // Act
        val conditionsMet = viewModel.getWeatherConditionsMet(someMetWeatherDetails, activity)
        val conditionStatus = viewModel.isWeatherOptimalForActivity(conditionsMet)

        // Assert
        assertEquals(ConditionStatus.SOME_MET, conditionStatus)
    }

    @Test
    fun testWeatherOptimalForActivity_ShouldReturnNoneMet() {

        // Arrange
        val activity = ActivityModels.KAYAKING
        val nonMetWeatherDetails = WeatherDetailsMockData.noneMetWeather

        // Act
        val conditionsMet = viewModel.getWeatherConditionsMet(nonMetWeatherDetails, activity)
        val conditionStatus = viewModel.isWeatherOptimalForActivity(conditionsMet)

        // Assert
        assertEquals(ConditionStatus.NONE_MET, conditionStatus)
    }
}