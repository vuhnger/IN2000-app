package no.uio.ifi.in2000.team_21.data

import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.ViewModel
import no.uio.ifi.in2000.team_21.R


data class OilRig(val name: String, val location: GeoPoint)

class OilRigViewModel : ViewModel() {
    // Liste over oljeplattformer
    val oilRigs = listOf(
        OilRig("Ekofisk", GeoPoint(56.5462, 3.2500)),
        OilRig("Troll A", GeoPoint(60.66667, 3.66667)),
        OilRig("Snorre", GeoPoint(61.5, 2.2)),
        OilRig("Statfjord", GeoPoint(61.247222, 1.859167)),
        OilRig("Gullfaks", GeoPoint(61.35, 2.2)),
        OilRig("Oseberg", GeoPoint(60.860833, 2.353333)),
        OilRig("Sleipner", GeoPoint(58.433333, 1.883333)),
        OilRig("Ivar Aasen", GeoPoint(58.5457,2.1204))


    )

    fun initializeRigs(mapView: MapView): List<Marker> {
        val drawable: Drawable? = ResourcesCompat.getDrawable(mapView.context.resources, R.drawable.oil_rig_icon, null)

        // Create a bitmap from the drawable
        val bitmap = Bitmap.createBitmap(drawable!!.intrinsicWidth, drawable.intrinsicHeight, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        drawable.setBounds(0, 0, canvas.width, canvas.height)
        drawable.draw(canvas)

        // Skalerer bitmapet
        val scaledBitmap = Bitmap.createScaledBitmap(bitmap, 90, 90, false)

        // Lag en drawble
        val scaledDrawable = BitmapDrawable(mapView.context.resources, scaledBitmap)

        // Opprett markører for hver oljeplattform
        val markers = oilRigs.map { rig ->
            Marker(mapView).apply {
                position = rig.location
                title = rig.name
                icon = scaledDrawable
            }
        }

        // Legg markørene til kartets overlays
        mapView.overlays.addAll(markers)

        return markers
    }
}