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

/*
class OilRigViewModel : ViewModel() {

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
        val markers = listOilrigs.map { rig ->
            Marker(mapView).apply {
                position = GeoPoint(rig.latitude, rig.longitude)
                title = rig.name
                icon = scaledDrawable
            }
        }

        // Legg markørene til kartets overlay liste
        mapView.overlays.addAll(markers)

        return markers
    }
}
 */