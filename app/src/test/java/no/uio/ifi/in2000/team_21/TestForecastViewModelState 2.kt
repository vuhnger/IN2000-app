package no.uio.ifi.in2000.team_21

import no.uio.ifi.in2000.team_21.ui.viewmodels.ForecastViewModel
import org.junit.Test
import java.time.LocalDate
import java.time.LocalTime

class TestForecastViewModelState {

    private val viewModel: ForecastViewModel = ForecastViewModel()
    @Test
    fun testTimeState(){

        val initial_state = viewModel.selected_time.value

        viewModel.update_selected_time(
            LocalDate.now(),
            LocalTime.now()
        )

        val result_state = viewModel.selected_time.value

        assert(initial_state == result_state)

    }


}