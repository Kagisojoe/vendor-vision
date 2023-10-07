package com.example.vendorvision

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

object Routes {
    const val SPENDING = "VendorSpending"
    const val TIMING = "timing"
    const val RATING = "rating"
}

@Composable
fun TopNavigationBar(navController: DestinationsNavigator) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = { navController.navigate(Routes.SPENDING) },
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Gray)
        ) {
            Text(text = "Spending")
        }

        Spacer(modifier = Modifier.width(8.dp))
        Button(
            onClick = { navController.navigate(Routes.TIMING) },
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Gray)
        ) {
            Text(text = "Timing")
        }
        Spacer(modifier = Modifier.width(8.dp))
        Button(
            onClick = { navController.navigate(Routes.RATING) },
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Gray)
        ) {
            Text(text = "Rating")
        }
    }
}
