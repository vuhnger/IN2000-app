package no.uio.ifi.in2000.team_21

import junit.framework.TestCase.assertEquals
import no.uio.ifi.in2000.team_21.model.activity.ActivityModel
import no.uio.ifi.in2000.team_21.model.activity.ActivityModels
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
}