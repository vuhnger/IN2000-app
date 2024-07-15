package no.uio.ifi.in2000.team_21.ui.home;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u001a@\u0010\b\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0007\u001a(\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u0005H\u0007\u001a_\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u0015H\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b \u0010!\u001a\u0010\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020$H\u0002\u0082\u0002\u000b\n\u0005\b\u00a1\u001e0\u0001\n\u0002\b\u0019\u00a8\u0006%"}, d2 = {"ActivityFavorites", "", "viewModel", "Lno/uio/ifi/in2000/team_21/ui/viewmodels/ActivitiesViewModel;", "navController", "Landroidx/navigation/NavController;", "activityConditionCheckerViewModel", "Lno/uio/ifi/in2000/team_21/ui/viewmodels/ActivityConditionCheckerViewModel;", "HomeScreen", "activitiesViewModel", "forecastViewModel", "Lno/uio/ifi/in2000/team_21/ui/viewmodels/ForecastViewModel;", "alertsViewModel", "Lno/uio/ifi/in2000/team_21/ui/map/AlertsViewModel;", "locationViewModel", "Lno/uio/ifi/in2000/team_21/ui/viewmodels/LocationViewModel;", "oceanForecastViewModel", "Lno/uio/ifi/in2000/team_21/ui/viewmodels/OceanForecastViewModel;", "RecommendationSection", "WeatherCard", "cityName", "", "temperature", "alertColor", "Landroidx/compose/ui/graphics/Color;", "isAlertActive", "", "icon", "cloudCoverDescription", "waveheight", "windSpeed", "time", "WeatherCard-FU0evQE", "(Ljava/lang/String;Ljava/lang/String;JZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "isInternetAvailable", "context", "Landroid/content/Context;", "app_debug"})
public final class HomeScreenKt {
    
    private static final boolean isInternetAvailable(android.content.Context context) {
        return false;
    }
    
    @androidx.compose.runtime.Composable
    public static final void ActivityFavorites(@org.jetbrains.annotations.NotNull
    no.uio.ifi.in2000.team_21.ui.viewmodels.ActivitiesViewModel viewModel, @org.jetbrains.annotations.NotNull
    androidx.navigation.NavController navController, @org.jetbrains.annotations.NotNull
    no.uio.ifi.in2000.team_21.ui.viewmodels.ActivityConditionCheckerViewModel activityConditionCheckerViewModel) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void RecommendationSection(@org.jetbrains.annotations.NotNull
    no.uio.ifi.in2000.team_21.ui.viewmodels.ActivitiesViewModel viewModel, @org.jetbrains.annotations.NotNull
    no.uio.ifi.in2000.team_21.ui.viewmodels.ActivityConditionCheckerViewModel activityConditionCheckerViewModel, @org.jetbrains.annotations.NotNull
    no.uio.ifi.in2000.team_21.ui.viewmodels.LocationViewModel locationViewModel, @org.jetbrains.annotations.NotNull
    androidx.navigation.NavController navController) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void HomeScreen(@org.jetbrains.annotations.NotNull
    androidx.navigation.NavController navController, @org.jetbrains.annotations.NotNull
    no.uio.ifi.in2000.team_21.ui.viewmodels.ActivitiesViewModel activitiesViewModel, @org.jetbrains.annotations.NotNull
    no.uio.ifi.in2000.team_21.ui.viewmodels.ForecastViewModel forecastViewModel, @org.jetbrains.annotations.NotNull
    no.uio.ifi.in2000.team_21.ui.map.AlertsViewModel alertsViewModel, @org.jetbrains.annotations.NotNull
    no.uio.ifi.in2000.team_21.ui.viewmodels.LocationViewModel locationViewModel, @org.jetbrains.annotations.NotNull
    no.uio.ifi.in2000.team_21.ui.viewmodels.ActivityConditionCheckerViewModel activityConditionCheckerViewModel, @org.jetbrains.annotations.NotNull
    no.uio.ifi.in2000.team_21.ui.viewmodels.OceanForecastViewModel oceanForecastViewModel) {
    }
}