package com.example.vendorvision
import android.widget.Toast
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.platform.LocalContext

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.vendorvision.ui.sidemenu.ScaffoldBack
import com.example.vendorvision.ui.sidemenu.SideMenu
import com.ramcosta.composedestinations.annotation.Destination

import com.ramcosta.composedestinations.navigation.DestinationsNavigator
@Destination(route = "VendorSpending")
@Composable
fun VendorSpendingScreen(navController: DestinationsNavigator) {
    ScaffoldBack(
        content = {
            Column(
                modifier = Modifier.padding(it)
            ) {
                TopNavigationBar(navController)
                Spacer(modifier = Modifier.height(16.dp))
                BarGraph()
            }
        },
        navController
    )
}


@Composable
fun BarGraph() {
    val months = listOf("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec").takeLast(6) // Taking the last 6 months
    val expenditures = listOf(100000, 150000, 80000, 200000, 170000, 220000, 90000, 110000, 140000, 180000, 160000, 190000).takeLast(6) // Taking the last 6 expenditure values

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp), // Added horizontal padding to make the column narrower
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(text = "Expenditure to Vendor", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .background(Color(0xFFE0E0E0), shape = RoundedCornerShape(16.dp)) // Grey background with rounded corners
                .padding(16.dp) // Padding around the content
                .fillMaxWidth() // Fill the available width
        ) {
            BarChart(months, expenditures)
        }
    }
}






@Composable
fun BarChart(months: List<String>, expenditures: List<Int>) {
    val maxExpenditure = expenditures.maxOrNull() ?: 0
    val barWidth = 30.dp
    val barSpacing = 8.dp
    val maxBarHeight = 200.dp
    val greenShades = listOf(
        Color(0xFFE8F5E9),
        Color(0xFFC8E6C8),
        Color(0xFFA5D6A7),
        Color(0xFF81C784),
        Color(0xFF66BB6A),
        Color(0xFF4CAF50)
    )

    val context = LocalContext.current

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        months.forEachIndexed { index, month ->
            val expenditure = expenditures[index]
            val ratio = expenditure.toFloat() / maxExpenditure
            val barHeight = maxBarHeight * ratio
            val colorIndex = (ratio * (greenShades.size - 1)).toInt()
            val barColor = greenShades[colorIndex]

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Spacer(modifier = Modifier.height(maxBarHeight - barHeight))
                Box(
                    modifier = Modifier
                        .height(barHeight)
                        .width(barWidth)
                        .background(barColor)
                        .clickable {  // Make the bar clickable
                            // Display the value using a Toast
                            Toast.makeText(context, "R$expenditure", Toast.LENGTH_SHORT).show()
                        }
                )
                Spacer(modifier = Modifier.height(barSpacing))
                Text(text = month)
            }
        }
    }
}
