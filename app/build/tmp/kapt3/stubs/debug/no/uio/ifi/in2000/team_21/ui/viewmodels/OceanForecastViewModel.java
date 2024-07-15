package no.uio.ifi.in2000.team_21.ui.viewmodels;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fJ\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lno/uio/ifi/in2000/team_21/ui/viewmodels/OceanForecastViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_oceanDataState", "Landroidx/lifecycle/MutableLiveData;", "Lno/uio/ifi/in2000/team_21/model/oceanforecast/OceanForecastResponse;", "oceanDataState", "Landroidx/lifecycle/LiveData;", "getOceanDataState", "()Landroidx/lifecycle/LiveData;", "repository", "Lno/uio/ifi/in2000/team_21/data/OceanForecastRepository;", "fetchOceanForecastByTime", "", "latitude", "", "longitude", "transformToOceanData", "Lno/uio/ifi/in2000/team_21/model/oceanforecast/OceanData;", "details", "Lno/uio/ifi/in2000/team_21/model/oceanforecast/Details;", "timeseries", "Lno/uio/ifi/in2000/team_21/model/oceanforecast/Timeseries;", "app_debug"})
public final class OceanForecastViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final no.uio.ifi.in2000.team_21.data.OceanForecastRepository repository = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<no.uio.ifi.in2000.team_21.model.oceanforecast.OceanForecastResponse> _oceanDataState = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<no.uio.ifi.in2000.team_21.model.oceanforecast.OceanForecastResponse> oceanDataState = null;
    
    public OceanForecastViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<no.uio.ifi.in2000.team_21.model.oceanforecast.OceanForecastResponse> getOceanDataState() {
        return null;
    }
    
    public final void fetchOceanForecastByTime(double latitude, double longitude) {
    }
    
    private final no.uio.ifi.in2000.team_21.model.oceanforecast.OceanData transformToOceanData(no.uio.ifi.in2000.team_21.model.oceanforecast.Details details, no.uio.ifi.in2000.team_21.model.oceanforecast.Timeseries timeseries) {
        return null;
    }
}