package no.uio.ifi.in2000.team_21

import junit.framework.TestCase.assertEquals
import no.uio.ifi.in2000.team_21.ui.viewmodels.ForecastViewModel
import org.junit.Test


class TestCloudFractionConversion {
    val viewModel: ForecastViewModel = ForecastViewModel()

    @Test
    fun test_valid_values_return_exptected_results() {

        val testCases = listOf(
            Pair(0.0, "Skyfritt"),
            Pair(9.9, "Skyfritt"),
            Pair(10.0, "Nesten skyfritt"),
            Pair(19.9, "Nesten skyfritt"),
            Pair(20.0, "Litt spredte skyer"),
            Pair(29.9, "Litt spredte skyer"),
            Pair(30.0, "Delvis solrikt"),
            Pair(39.9, "Delvis solrikt"),
            Pair(40.0, "Mest sol, noen skyer"),
            Pair(49.9, "Mest sol, noen skyer"),
            Pair(50.0, "Halvveis skydekket, like mye sol som skyer"),
            Pair(59.9, "Halvveis skydekket, like mye sol som skyer"),
            Pair(60.0, "Lett skyet, mer skyer enn sol"),
            Pair(69.9, "Lett skyet, mer skyer enn sol"),
            Pair(70.0, "Hovedsaklig skyet, lite sol"),
            Pair(79.9, "Hovedsaklig skyet, lite sol"),
            Pair(80.0, "Nesten helt skydekket, knapt noe sol"),
            Pair(89.9, "Nesten helt skydekket, knapt noe sol"),
            Pair(90.0, "Helt skydekket, ingen synlig sol"),
            Pair(100.0, "Helt skydekket, ingen synlig sol"),
        )

        for (testCase in testCases) {
            val cloudAreaFraction = testCase.first
            val expectedDescription = testCase.second

            val actualDescription = viewModel.describeCloudCover(cloudAreaFraction)

            assertEquals(expectedDescription, actualDescription)
        }
    }

    @Test
    fun test_invalid_value() {

        val invalidCloudFractions = listOf(-1.0, 101.0, 150.0)

        for (invalidCloudFraction in invalidCloudFractions) {
            val expectedErrorMessage = "Ugyldig verdi: $invalidCloudFraction"

            val actualDescription = viewModel.describeCloudCover(invalidCloudFraction)

            assertEquals(expectedErrorMessage, actualDescription)
        }
    }

}
