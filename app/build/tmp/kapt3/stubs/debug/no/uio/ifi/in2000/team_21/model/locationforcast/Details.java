package no.uio.ifi.in2000.team_21.model.locationforcast;

@kotlinx.serialization.Serializable
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\bi\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u0095\u00012\u00020\u0001:\u0004\u0094\u0001\u0095\u0001B\u00b9\u0002\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u001a\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u00a2\u0006\u0002\u0010\u001fB\u00a5\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010 J\u0010\u0010m\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010$J\u0010\u0010n\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010$J\u0010\u0010o\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010$J\u0010\u0010p\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010$J\u0010\u0010q\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010$J\u0010\u0010r\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010$J\u0010\u0010s\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010$J\u0010\u0010t\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010$J\u0010\u0010u\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010$J\u0010\u0010v\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010$J\u0010\u0010w\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010$J\u0010\u0010x\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010$J\u0010\u0010y\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010$J\u0010\u0010z\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010$J\u0010\u0010{\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010$J\u0010\u0010|\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010$J\u0010\u0010}\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010$J\u0010\u0010~\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010$J\u0010\u0010\u007f\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010$J\u0011\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010$J\u0011\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010$J\u0011\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010$J\u0011\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010$J\u0011\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010$J\u00b0\u0002\u0010\u0085\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001\u00a2\u0006\u0003\u0010\u0086\u0001J\u0016\u0010\u0087\u0001\u001a\u00030\u0088\u00012\t\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\n\u0010\u008a\u0001\u001a\u00020\u0003H\u00d6\u0001J\u000b\u0010\u008b\u0001\u001a\u00030\u008c\u0001H\u00d6\u0001J(\u0010\u008d\u0001\u001a\u00030\u008e\u00012\u0007\u0010\u008f\u0001\u001a\u00020\u00002\b\u0010\u0090\u0001\u001a\u00030\u0091\u00012\b\u0010\u0092\u0001\u001a\u00030\u0093\u0001H\u00c7\u0001R(\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0016\n\u0002\u0010\'\u0012\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R(\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0016\n\u0002\u0010\'\u0012\u0004\b(\u0010\"\u001a\u0004\b)\u0010$\"\u0004\b*\u0010&R(\u0010\u001b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0016\n\u0002\u0010\'\u0012\u0004\b+\u0010\"\u001a\u0004\b,\u0010$\"\u0004\b-\u0010&R(\u0010\u001c\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0016\n\u0002\u0010\'\u0012\u0004\b.\u0010\"\u001a\u0004\b/\u0010$\"\u0004\b0\u0010&R(\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0016\n\u0002\u0010\'\u0012\u0004\b1\u0010\"\u001a\u0004\b2\u0010$\"\u0004\b3\u0010&R(\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0016\n\u0002\u0010\'\u0012\u0004\b4\u0010\"\u001a\u0004\b5\u0010$\"\u0004\b6\u0010&R(\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0016\n\u0002\u0010\'\u0012\u0004\b7\u0010\"\u001a\u0004\b8\u0010$\"\u0004\b9\u0010&R(\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0016\n\u0002\u0010\'\u0012\u0004\b:\u0010\"\u001a\u0004\b;\u0010$\"\u0004\b<\u0010&R(\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0016\n\u0002\u0010\'\u0012\u0004\b=\u0010\"\u001a\u0004\b>\u0010$\"\u0004\b?\u0010&R(\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0016\n\u0002\u0010\'\u0012\u0004\b@\u0010\"\u001a\u0004\bA\u0010$\"\u0004\bB\u0010&R(\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0016\n\u0002\u0010\'\u0012\u0004\bC\u0010\"\u001a\u0004\bD\u0010$\"\u0004\bE\u0010&R(\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0016\n\u0002\u0010\'\u0012\u0004\bF\u0010\"\u001a\u0004\bG\u0010$\"\u0004\bH\u0010&R(\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0016\n\u0002\u0010\'\u0012\u0004\bI\u0010\"\u001a\u0004\bJ\u0010$\"\u0004\bK\u0010&R(\u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0016\n\u0002\u0010\'\u0012\u0004\bL\u0010\"\u001a\u0004\bM\u0010$\"\u0004\bN\u0010&R(\u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0016\n\u0002\u0010\'\u0012\u0004\bO\u0010\"\u001a\u0004\bP\u0010$\"\u0004\bQ\u0010&R(\u0010\u0019\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0016\n\u0002\u0010\'\u0012\u0004\bR\u0010\"\u001a\u0004\bS\u0010$\"\u0004\bT\u0010&R(\u0010\u001a\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0016\n\u0002\u0010\'\u0012\u0004\bU\u0010\"\u001a\u0004\bV\u0010$\"\u0004\bW\u0010&R(\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0016\n\u0002\u0010\'\u0012\u0004\bX\u0010\"\u001a\u0004\bY\u0010$\"\u0004\bZ\u0010&R(\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0016\n\u0002\u0010\'\u0012\u0004\b[\u0010\"\u001a\u0004\b\\\u0010$\"\u0004\b]\u0010&R(\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0016\n\u0002\u0010\'\u0012\u0004\b^\u0010\"\u001a\u0004\b_\u0010$\"\u0004\b`\u0010&R(\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0016\n\u0002\u0010\'\u0012\u0004\ba\u0010\"\u001a\u0004\bb\u0010$\"\u0004\bc\u0010&R(\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0016\n\u0002\u0010\'\u0012\u0004\bd\u0010\"\u001a\u0004\be\u0010$\"\u0004\bf\u0010&R(\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0016\n\u0002\u0010\'\u0012\u0004\bg\u0010\"\u001a\u0004\bh\u0010$\"\u0004\bi\u0010&R(\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0016\n\u0002\u0010\'\u0012\u0004\bj\u0010\"\u001a\u0004\bk\u0010$\"\u0004\bl\u0010&\u00a8\u0006\u0096\u0001"}, d2 = {"Lno/uio/ifi/in2000/team_21/model/locationforcast/Details;", "", "seen1", "", "air_pressure_at_sea_level", "", "air_temperature", "air_temperature_percentile_10", "air_temperature_percentile_90", "cloud_area_fraction", "cloud_area_fraction_high", "cloud_area_fraction_low", "cloud_area_fraction_medium", "dew_point_temperature", "fog_area_fraction", "relative_humidity", "ultraviolet_index_clear_sky", "wind_from_direction", "wind_speed", "wind_speed_of_gust", "wind_speed_percentile_10", "wind_speed_percentile_90", "precipitation_amount", "precipitation_amount_max", "precipitation_amount_min", "probability_of_precipitation", "probability_of_thunder", "air_temperature_max", "air_temperature_min", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;)V", "getAir_pressure_at_sea_level$annotations", "()V", "getAir_pressure_at_sea_level", "()Ljava/lang/Double;", "setAir_pressure_at_sea_level", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getAir_temperature$annotations", "getAir_temperature", "setAir_temperature", "getAir_temperature_max$annotations", "getAir_temperature_max", "setAir_temperature_max", "getAir_temperature_min$annotations", "getAir_temperature_min", "setAir_temperature_min", "getAir_temperature_percentile_10$annotations", "getAir_temperature_percentile_10", "setAir_temperature_percentile_10", "getAir_temperature_percentile_90$annotations", "getAir_temperature_percentile_90", "setAir_temperature_percentile_90", "getCloud_area_fraction$annotations", "getCloud_area_fraction", "setCloud_area_fraction", "getCloud_area_fraction_high$annotations", "getCloud_area_fraction_high", "setCloud_area_fraction_high", "getCloud_area_fraction_low$annotations", "getCloud_area_fraction_low", "setCloud_area_fraction_low", "getCloud_area_fraction_medium$annotations", "getCloud_area_fraction_medium", "setCloud_area_fraction_medium", "getDew_point_temperature$annotations", "getDew_point_temperature", "setDew_point_temperature", "getFog_area_fraction$annotations", "getFog_area_fraction", "setFog_area_fraction", "getPrecipitation_amount$annotations", "getPrecipitation_amount", "setPrecipitation_amount", "getPrecipitation_amount_max$annotations", "getPrecipitation_amount_max", "setPrecipitation_amount_max", "getPrecipitation_amount_min$annotations", "getPrecipitation_amount_min", "setPrecipitation_amount_min", "getProbability_of_precipitation$annotations", "getProbability_of_precipitation", "setProbability_of_precipitation", "getProbability_of_thunder$annotations", "getProbability_of_thunder", "setProbability_of_thunder", "getRelative_humidity$annotations", "getRelative_humidity", "setRelative_humidity", "getUltraviolet_index_clear_sky$annotations", "getUltraviolet_index_clear_sky", "setUltraviolet_index_clear_sky", "getWind_from_direction$annotations", "getWind_from_direction", "setWind_from_direction", "getWind_speed$annotations", "getWind_speed", "setWind_speed", "getWind_speed_of_gust$annotations", "getWind_speed_of_gust", "setWind_speed_of_gust", "getWind_speed_percentile_10$annotations", "getWind_speed_percentile_10", "setWind_speed_percentile_10", "getWind_speed_percentile_90$annotations", "getWind_speed_percentile_90", "setWind_speed_percentile_90", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;)Lno/uio/ifi/in2000/team_21/model/locationforcast/Details;", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "app_debug"})
public final class Details {
    @org.jetbrains.annotations.Nullable
    private java.lang.Double air_pressure_at_sea_level;
    @org.jetbrains.annotations.Nullable
    private java.lang.Double air_temperature;
    @org.jetbrains.annotations.Nullable
    private java.lang.Double air_temperature_percentile_10;
    @org.jetbrains.annotations.Nullable
    private java.lang.Double air_temperature_percentile_90;
    @org.jetbrains.annotations.Nullable
    private java.lang.Double cloud_area_fraction;
    @org.jetbrains.annotations.Nullable
    private java.lang.Double cloud_area_fraction_high;
    @org.jetbrains.annotations.Nullable
    private java.lang.Double cloud_area_fraction_low;
    @org.jetbrains.annotations.Nullable
    private java.lang.Double cloud_area_fraction_medium;
    @org.jetbrains.annotations.Nullable
    private java.lang.Double dew_point_temperature;
    @org.jetbrains.annotations.Nullable
    private java.lang.Double fog_area_fraction;
    @org.jetbrains.annotations.Nullable
    private java.lang.Double relative_humidity;
    @org.jetbrains.annotations.Nullable
    private java.lang.Double ultraviolet_index_clear_sky;
    @org.jetbrains.annotations.Nullable
    private java.lang.Double wind_from_direction;
    @org.jetbrains.annotations.Nullable
    private java.lang.Double wind_speed;
    @org.jetbrains.annotations.Nullable
    private java.lang.Double wind_speed_of_gust;
    @org.jetbrains.annotations.Nullable
    private java.lang.Double wind_speed_percentile_10;
    @org.jetbrains.annotations.Nullable
    private java.lang.Double wind_speed_percentile_90;
    @org.jetbrains.annotations.Nullable
    private java.lang.Double precipitation_amount;
    @org.jetbrains.annotations.Nullable
    private java.lang.Double precipitation_amount_max;
    @org.jetbrains.annotations.Nullable
    private java.lang.Double precipitation_amount_min;
    @org.jetbrains.annotations.Nullable
    private java.lang.Double probability_of_precipitation;
    @org.jetbrains.annotations.Nullable
    private java.lang.Double probability_of_thunder;
    @org.jetbrains.annotations.Nullable
    private java.lang.Double air_temperature_max;
    @org.jetbrains.annotations.Nullable
    private java.lang.Double air_temperature_min;
    @org.jetbrains.annotations.NotNull
    public static final no.uio.ifi.in2000.team_21.model.locationforcast.Details.Companion Companion = null;
    
    public Details(@org.jetbrains.annotations.Nullable
    java.lang.Double air_pressure_at_sea_level, @org.jetbrains.annotations.Nullable
    java.lang.Double air_temperature, @org.jetbrains.annotations.Nullable
    java.lang.Double air_temperature_percentile_10, @org.jetbrains.annotations.Nullable
    java.lang.Double air_temperature_percentile_90, @org.jetbrains.annotations.Nullable
    java.lang.Double cloud_area_fraction, @org.jetbrains.annotations.Nullable
    java.lang.Double cloud_area_fraction_high, @org.jetbrains.annotations.Nullable
    java.lang.Double cloud_area_fraction_low, @org.jetbrains.annotations.Nullable
    java.lang.Double cloud_area_fraction_medium, @org.jetbrains.annotations.Nullable
    java.lang.Double dew_point_temperature, @org.jetbrains.annotations.Nullable
    java.lang.Double fog_area_fraction, @org.jetbrains.annotations.Nullable
    java.lang.Double relative_humidity, @org.jetbrains.annotations.Nullable
    java.lang.Double ultraviolet_index_clear_sky, @org.jetbrains.annotations.Nullable
    java.lang.Double wind_from_direction, @org.jetbrains.annotations.Nullable
    java.lang.Double wind_speed, @org.jetbrains.annotations.Nullable
    java.lang.Double wind_speed_of_gust, @org.jetbrains.annotations.Nullable
    java.lang.Double wind_speed_percentile_10, @org.jetbrains.annotations.Nullable
    java.lang.Double wind_speed_percentile_90, @org.jetbrains.annotations.Nullable
    java.lang.Double precipitation_amount, @org.jetbrains.annotations.Nullable
    java.lang.Double precipitation_amount_max, @org.jetbrains.annotations.Nullable
    java.lang.Double precipitation_amount_min, @org.jetbrains.annotations.Nullable
    java.lang.Double probability_of_precipitation, @org.jetbrains.annotations.Nullable
    java.lang.Double probability_of_thunder, @org.jetbrains.annotations.Nullable
    java.lang.Double air_temperature_max, @org.jetbrains.annotations.Nullable
    java.lang.Double air_temperature_min) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double getAir_pressure_at_sea_level() {
        return null;
    }
    
    @kotlinx.serialization.SerialName(value = "air_pressure_at_sea_level")
    @java.lang.Deprecated
    public static void getAir_pressure_at_sea_level$annotations() {
    }
    
    public final void setAir_pressure_at_sea_level(@org.jetbrains.annotations.Nullable
    java.lang.Double p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double getAir_temperature() {
        return null;
    }
    
    @kotlinx.serialization.SerialName(value = "air_temperature")
    @java.lang.Deprecated
    public static void getAir_temperature$annotations() {
    }
    
    public final void setAir_temperature(@org.jetbrains.annotations.Nullable
    java.lang.Double p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double getAir_temperature_percentile_10() {
        return null;
    }
    
    @kotlinx.serialization.SerialName(value = "air_temperature_percentile_10")
    @java.lang.Deprecated
    public static void getAir_temperature_percentile_10$annotations() {
    }
    
    public final void setAir_temperature_percentile_10(@org.jetbrains.annotations.Nullable
    java.lang.Double p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double getAir_temperature_percentile_90() {
        return null;
    }
    
    @kotlinx.serialization.SerialName(value = "air_temperature_percentile_90")
    @java.lang.Deprecated
    public static void getAir_temperature_percentile_90$annotations() {
    }
    
    public final void setAir_temperature_percentile_90(@org.jetbrains.annotations.Nullable
    java.lang.Double p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double getCloud_area_fraction() {
        return null;
    }
    
    @kotlinx.serialization.SerialName(value = "cloud_area_fraction")
    @java.lang.Deprecated
    public static void getCloud_area_fraction$annotations() {
    }
    
    public final void setCloud_area_fraction(@org.jetbrains.annotations.Nullable
    java.lang.Double p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double getCloud_area_fraction_high() {
        return null;
    }
    
    @kotlinx.serialization.SerialName(value = "cloud_area_fraction_high")
    @java.lang.Deprecated
    public static void getCloud_area_fraction_high$annotations() {
    }
    
    public final void setCloud_area_fraction_high(@org.jetbrains.annotations.Nullable
    java.lang.Double p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double getCloud_area_fraction_low() {
        return null;
    }
    
    @kotlinx.serialization.SerialName(value = "cloud_area_fraction_low")
    @java.lang.Deprecated
    public static void getCloud_area_fraction_low$annotations() {
    }
    
    public final void setCloud_area_fraction_low(@org.jetbrains.annotations.Nullable
    java.lang.Double p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double getCloud_area_fraction_medium() {
        return null;
    }
    
    @kotlinx.serialization.SerialName(value = "cloud_area_fraction_medium")
    @java.lang.Deprecated
    public static void getCloud_area_fraction_medium$annotations() {
    }
    
    public final void setCloud_area_fraction_medium(@org.jetbrains.annotations.Nullable
    java.lang.Double p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double getDew_point_temperature() {
        return null;
    }
    
    @kotlinx.serialization.SerialName(value = "dew_point_temperature")
    @java.lang.Deprecated
    public static void getDew_point_temperature$annotations() {
    }
    
    public final void setDew_point_temperature(@org.jetbrains.annotations.Nullable
    java.lang.Double p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double getFog_area_fraction() {
        return null;
    }
    
    @kotlinx.serialization.SerialName(value = "fog_area_fraction")
    @java.lang.Deprecated
    public static void getFog_area_fraction$annotations() {
    }
    
    public final void setFog_area_fraction(@org.jetbrains.annotations.Nullable
    java.lang.Double p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double getRelative_humidity() {
        return null;
    }
    
    @kotlinx.serialization.SerialName(value = "relative_humidity")
    @java.lang.Deprecated
    public static void getRelative_humidity$annotations() {
    }
    
    public final void setRelative_humidity(@org.jetbrains.annotations.Nullable
    java.lang.Double p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double getUltraviolet_index_clear_sky() {
        return null;
    }
    
    @kotlinx.serialization.SerialName(value = "ultraviolet_index_clear_sky")
    @java.lang.Deprecated
    public static void getUltraviolet_index_clear_sky$annotations() {
    }
    
    public final void setUltraviolet_index_clear_sky(@org.jetbrains.annotations.Nullable
    java.lang.Double p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double getWind_from_direction() {
        return null;
    }
    
    @kotlinx.serialization.SerialName(value = "wind_from_direction")
    @java.lang.Deprecated
    public static void getWind_from_direction$annotations() {
    }
    
    public final void setWind_from_direction(@org.jetbrains.annotations.Nullable
    java.lang.Double p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double getWind_speed() {
        return null;
    }
    
    @kotlinx.serialization.SerialName(value = "wind_speed")
    @java.lang.Deprecated
    public static void getWind_speed$annotations() {
    }
    
    public final void setWind_speed(@org.jetbrains.annotations.Nullable
    java.lang.Double p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double getWind_speed_of_gust() {
        return null;
    }
    
    @kotlinx.serialization.SerialName(value = "wind_speed_of_gust")
    @java.lang.Deprecated
    public static void getWind_speed_of_gust$annotations() {
    }
    
    public final void setWind_speed_of_gust(@org.jetbrains.annotations.Nullable
    java.lang.Double p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double getWind_speed_percentile_10() {
        return null;
    }
    
    @kotlinx.serialization.SerialName(value = "wind_speed_percentile_10")
    @java.lang.Deprecated
    public static void getWind_speed_percentile_10$annotations() {
    }
    
    public final void setWind_speed_percentile_10(@org.jetbrains.annotations.Nullable
    java.lang.Double p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double getWind_speed_percentile_90() {
        return null;
    }
    
    @kotlinx.serialization.SerialName(value = "wind_speed_percentile_90")
    @java.lang.Deprecated
    public static void getWind_speed_percentile_90$annotations() {
    }
    
    public final void setWind_speed_percentile_90(@org.jetbrains.annotations.Nullable
    java.lang.Double p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double getPrecipitation_amount() {
        return null;
    }
    
    @kotlinx.serialization.SerialName(value = "precipitation_amount")
    @java.lang.Deprecated
    public static void getPrecipitation_amount$annotations() {
    }
    
    public final void setPrecipitation_amount(@org.jetbrains.annotations.Nullable
    java.lang.Double p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double getPrecipitation_amount_max() {
        return null;
    }
    
    @kotlinx.serialization.SerialName(value = "precipitation_amount_max")
    @java.lang.Deprecated
    public static void getPrecipitation_amount_max$annotations() {
    }
    
    public final void setPrecipitation_amount_max(@org.jetbrains.annotations.Nullable
    java.lang.Double p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double getPrecipitation_amount_min() {
        return null;
    }
    
    @kotlinx.serialization.SerialName(value = "precipitation_amount_min")
    @java.lang.Deprecated
    public static void getPrecipitation_amount_min$annotations() {
    }
    
    public final void setPrecipitation_amount_min(@org.jetbrains.annotations.Nullable
    java.lang.Double p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double getProbability_of_precipitation() {
        return null;
    }
    
    @kotlinx.serialization.SerialName(value = "probability_of_precipitation")
    @java.lang.Deprecated
    public static void getProbability_of_precipitation$annotations() {
    }
    
    public final void setProbability_of_precipitation(@org.jetbrains.annotations.Nullable
    java.lang.Double p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double getProbability_of_thunder() {
        return null;
    }
    
    @kotlinx.serialization.SerialName(value = "probability_of_thunder")
    @java.lang.Deprecated
    public static void getProbability_of_thunder$annotations() {
    }
    
    public final void setProbability_of_thunder(@org.jetbrains.annotations.Nullable
    java.lang.Double p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double getAir_temperature_max() {
        return null;
    }
    
    @kotlinx.serialization.SerialName(value = "air_temperature_max")
    @java.lang.Deprecated
    public static void getAir_temperature_max$annotations() {
    }
    
    public final void setAir_temperature_max(@org.jetbrains.annotations.Nullable
    java.lang.Double p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double getAir_temperature_min() {
        return null;
    }
    
    @kotlinx.serialization.SerialName(value = "air_temperature_min")
    @java.lang.Deprecated
    public static void getAir_temperature_min$annotations() {
    }
    
    public final void setAir_temperature_min(@org.jetbrains.annotations.Nullable
    java.lang.Double p0) {
    }
    
    public Details() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double component11() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double component12() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double component13() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double component14() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double component15() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double component16() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double component17() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double component18() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double component19() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double component20() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double component21() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double component22() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double component23() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double component24() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final no.uio.ifi.in2000.team_21.model.locationforcast.Details copy(@org.jetbrains.annotations.Nullable
    java.lang.Double air_pressure_at_sea_level, @org.jetbrains.annotations.Nullable
    java.lang.Double air_temperature, @org.jetbrains.annotations.Nullable
    java.lang.Double air_temperature_percentile_10, @org.jetbrains.annotations.Nullable
    java.lang.Double air_temperature_percentile_90, @org.jetbrains.annotations.Nullable
    java.lang.Double cloud_area_fraction, @org.jetbrains.annotations.Nullable
    java.lang.Double cloud_area_fraction_high, @org.jetbrains.annotations.Nullable
    java.lang.Double cloud_area_fraction_low, @org.jetbrains.annotations.Nullable
    java.lang.Double cloud_area_fraction_medium, @org.jetbrains.annotations.Nullable
    java.lang.Double dew_point_temperature, @org.jetbrains.annotations.Nullable
    java.lang.Double fog_area_fraction, @org.jetbrains.annotations.Nullable
    java.lang.Double relative_humidity, @org.jetbrains.annotations.Nullable
    java.lang.Double ultraviolet_index_clear_sky, @org.jetbrains.annotations.Nullable
    java.lang.Double wind_from_direction, @org.jetbrains.annotations.Nullable
    java.lang.Double wind_speed, @org.jetbrains.annotations.Nullable
    java.lang.Double wind_speed_of_gust, @org.jetbrains.annotations.Nullable
    java.lang.Double wind_speed_percentile_10, @org.jetbrains.annotations.Nullable
    java.lang.Double wind_speed_percentile_90, @org.jetbrains.annotations.Nullable
    java.lang.Double precipitation_amount, @org.jetbrains.annotations.Nullable
    java.lang.Double precipitation_amount_max, @org.jetbrains.annotations.Nullable
    java.lang.Double precipitation_amount_min, @org.jetbrains.annotations.Nullable
    java.lang.Double probability_of_precipitation, @org.jetbrains.annotations.Nullable
    java.lang.Double probability_of_thunder, @org.jetbrains.annotations.Nullable
    java.lang.Double air_temperature_max, @org.jetbrains.annotations.Nullable
    java.lang.Double air_temperature_min) {
        return null;
    }
    
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return null;
    }
    
    @kotlin.jvm.JvmStatic
    public static final void write$Self(@org.jetbrains.annotations.NotNull
    no.uio.ifi.in2000.team_21.model.locationforcast.Details self, @org.jetbrains.annotations.NotNull
    kotlinx.serialization.encoding.CompositeEncoder output, @org.jetbrains.annotations.NotNull
    kotlinx.serialization.descriptors.SerialDescriptor serialDesc) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tH\u00d6\u0001\u00a2\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002H\u00d6\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VX\u00d6\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0014"}, d2 = {"no/uio/ifi/in2000/team_21/model/locationforcast/Details.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lno/uio/ifi/in2000/team_21/model/locationforcast/Details;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "app_debug"})
    @java.lang.Deprecated
    public static final class $serializer implements kotlinx.serialization.internal.GeneratedSerializer<no.uio.ifi.in2000.team_21.model.locationforcast.Details> {
        @org.jetbrains.annotations.NotNull
        public static final no.uio.ifi.in2000.team_21.model.locationforcast.Details.$serializer INSTANCE = null;
        
        private $serializer() {
            super();
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public kotlinx.serialization.KSerializer<?>[] childSerializers() {
            return null;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public no.uio.ifi.in2000.team_21.model.locationforcast.Details deserialize(@org.jetbrains.annotations.NotNull
        kotlinx.serialization.encoding.Decoder decoder) {
            return null;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public kotlinx.serialization.descriptors.SerialDescriptor getDescriptor() {
            return null;
        }
        
        @java.lang.Override
        public void serialize(@org.jetbrains.annotations.NotNull
        kotlinx.serialization.encoding.Encoder encoder, @org.jetbrains.annotations.NotNull
        no.uio.ifi.in2000.team_21.model.locationforcast.Details value) {
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public kotlinx.serialization.KSerializer<?>[] typeParametersSerializers() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u00c6\u0001\u00a8\u0006\u0006"}, d2 = {"Lno/uio/ifi/in2000/team_21/model/locationforcast/Details$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lno/uio/ifi/in2000/team_21/model/locationforcast/Details;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final kotlinx.serialization.KSerializer<no.uio.ifi.in2000.team_21.model.locationforcast.Details> serializer() {
            return null;
        }
    }
}