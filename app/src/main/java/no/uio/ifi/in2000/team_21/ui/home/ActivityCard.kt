package no.uio.ifi.in2000.team_21.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Card
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Add
import androidx.compose.material3.Icon
import no.uio.ifi.in2000.team_21.model.Activity

data class ActivityInfo(
    val name: String,
    val temperature: Double,
    val temperatureUnit: String,
    val wind: Double? = 0.0,
    val windUnit: String,
    val precipitation: Double? = 0.0,
    val imageId: Int,
    val icons: List<String> = listOf()
)
@Composable
fun ActivityCard(
    activity: Activity
) {
    // Determine the aspect ratio for your image. For instance, 16:9 would be 16f / 9f.
    val aspectRatio = 4f / 2f // Replace with your image's aspect ratio

    Card(
        modifier = Modifier
            .fillMaxWidth(0.5f)
            .padding(2.dp), // Halved padding
        elevation = 2.dp // Halved elevation
    ) {
        Column(
            modifier = Modifier
                .background(Color.White)
        ) {

            Row(
                modifier = Modifier
                    .padding(5.dp) // Halved padding
            ) {
                Text(
                    text = activity.name,
                    fontSize = 12.sp, // Halved font size
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .weight(1f) // Changed weight to 1f for title
                        .align(Alignment.CenterVertically) // Vertically center the text
                )

                Icon(
                    imageVector = Icons.Sharp.Add,
                    contentDescription = "Add Activity",
                    modifier = Modifier
                        .size(12.dp) // Halved size for the icon
                        .align(Alignment.CenterVertically) // Align the icon to center vertically
                        .fillMaxWidth(0.2f)
                )
            }
            Image(
                painter = painterResource(id = activity.imageId),
                contentDescription = "Picture of ${activity.name}",
                modifier = Modifier
                    .fillMaxWidth(0.5f) // Image will fill the width of the card
                    .aspectRatio(aspectRatio) // Set the aspect ratio
            )
            Text(
                text = "I dag er forholdene gode for ${activity.name.lowercase()}.\n" +
                        "De neste 1, 6 og 12 timene:",
                fontSize = 8.sp, // Halved font size
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 4.dp) // Halved padding
            )
            // Simulated weather icons container
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(horizontal = 8.dp) // Halved padding
            ) {
                if (activity.icons?.isNotEmpty() == true) {
                    activity.icons?.forEach { icon ->
                        WeatherIcon(element = icon, size = 30)
                        Spacer(modifier = Modifier.width(4.dp)) // Halved space width
                    }
                }
            }
            Button(
                onClick = { /* Handle click */ },
                modifier = Modifier
                    .padding(8.dp) // Halved padding
            ) {
                Text("Start", fontSize = 12.sp) // Halved font size
            }
        }
    }
}
@Composable
fun ActivityCardGrid(
    activities: List<Activity>
) {
    // Define the layout of the grid, specifying that it should have two columns
    LazyVerticalGrid(
        columns = GridCells.Fixed(2), // Fixed number of columns (2 in this case)
        modifier = Modifier.padding(8.dp), // Padding around the entire grid
        horizontalArrangement = Arrangement.spacedBy(8.dp), // Space between columns
        verticalArrangement = Arrangement.spacedBy(8.dp) // Space between rows
    ) {
        // Use items to create a card for each activity in the list
        items(activities) { activity ->
            ActivityCard(activity = activity)
        }
    }
}
