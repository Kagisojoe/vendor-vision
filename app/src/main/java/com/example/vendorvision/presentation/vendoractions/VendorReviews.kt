package com.example.vendorvision

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator


import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import com.example.vendorvision.ui.sidemenu.ScaffoldBack


data class Review(
    val qualityRating: Float,
    val serviceRating: Float,
    val priceRating: Float,
    val comment: String
)
val CustomColors = darkColors(
    primary = Color(0xFF4CAF50), // Dark Green
    primaryVariant = Color(0xFF1B5E20), // Even Darker Green
    onPrimary = Color.Black, // Text color on primary color
    surface = Color.White, // White background for components like buttons
    onSurface = Color.Black, // Text color on white background
    background = Color.White, // Background color of the screen
    onBackground = Color.Black // Text color on the white background
)



@Destination(route = "rating")
@Composable
fun VendorReviewScreen(navController: DestinationsNavigator) {
    MaterialTheme(colors = CustomColors) {
    var qualityRating by remember { mutableStateOf(0f) }
    var serviceRating by remember { mutableStateOf(0f) }
    var priceRating by remember { mutableStateOf(0f) }
    var comment by remember { mutableStateOf("") }
    var overallRating by remember { mutableStateOf(3f) } // Example initial value

    val sampleReviews = listOf(
        Review(4f, 5f, 3f, "Great vendor, but a bit pricey."),
        Review(5f, 5f, 5f, "Absolutely perfect!"),
        Review(3f, 2f, 3f, "Average service."),

    )
        val scrollState = rememberScrollState()

        ScaffoldBack(
            content = {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(it)
                        .padding(16.dp)
                        .verticalScroll(scrollState),   // additional padding
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TopNavigationBar(navController)
                    // Vendor's Name Heading
                    Text(text = "Vendor's Name", style = MaterialTheme.typography.h5)
                    Spacer(modifier = Modifier.height(8.dp))

                    // Current Rating
                    Text(text = "Current Rating", style = MaterialTheme.typography.subtitle1)
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        RatingStars(overallRating)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = "$overallRating/5")
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Review Box
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                Color(0xFFC8E6C8),
                                shape = RoundedCornerShape(16.dp)
                            ) // darker green background with rounded corners
                            .padding(16.dp) // padding inside the box
                    ) {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            RatingInput("Quality", qualityRating) { qualityRating = it }
                            Spacer(modifier = Modifier.height(8.dp))
                            RatingInput("Service", serviceRating) { serviceRating = it }
                            Spacer(modifier = Modifier.height(8.dp))
                            RatingInput("Price", priceRating) { priceRating = it }
                            Spacer(modifier = Modifier.height(16.dp))
                            OutlinedTextField(
                                value = comment,
                                onValueChange = { comment = it },
                                label = { Text("Comment") },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(150.dp) // Increased height for the comment box
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                            Button(onClick = {
                                // Handle the review submission here
                                // For now, we'll just print the values
                                println("Quality: $qualityRating, Service: $serviceRating, Price: $priceRating, Comment: $comment")
                            }) {
                                Text("Post Review")
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Display previous reviews
                    Text(text = "Previous Reviews", style = MaterialTheme.typography.h6)
                    Spacer(modifier = Modifier.height(8.dp))
                    sampleReviews.forEach { review ->
                        ReviewItem(review)
                        Spacer(modifier = Modifier.height(8.dp))
                    }


                }
            },
            navController)
    }
}

@Composable
fun RatingStars(rating: Float) {
    // This is a simple placeholder for a star rating component.
    // You might want to use a custom star rating component for a more refined look.
    val GoldColor = Color(0xFFFFD700)

    repeat(5) { index ->
        if (index < rating) {
            Text(text = "★", color = GoldColor) // Filled star
        } else {
            Text(text = "☆") // Empty star
        }
    }
}

@Composable
fun RatingInput(label: String, rating: Float, onRatingChanged: (Float) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = label)
        Slider(
            value = rating,
            onValueChange = onRatingChanged,
            valueRange = 0f..5f,
            steps = 5
        )
    }
}

val sampleReviews = listOf(
    Review(4f, 5f, 3f, "Great vendor, but a bit pricey."),
    Review(5f, 5f, 5f, "Absolutely perfect!"),
    Review(3f, 2f, 3f, "Average service."),

)


@Composable
fun ReviewItem(review: Review) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Quality: ${review.qualityRating}/5")
                Text(text = "Service: ${review.serviceRating}/5")
                Text(text = "Price: ${review.priceRating}/5")
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = review.comment)
        }
    }
}



