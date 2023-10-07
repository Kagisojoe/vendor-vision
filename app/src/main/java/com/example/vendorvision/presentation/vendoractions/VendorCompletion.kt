package com.example.vendorvision

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin
import androidx.compose.material.Text
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp
import com.example.vendorvision.ui.sidemenu.ScaffoldBack
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination(route = "timing")
@Composable
fun VendorCompletionScreen(navController: DestinationsNavigator) {
    val segments = listOf(
        DonutChartSegment("On Time", 60, Color(0xFF66BB6A)),
        DonutChartSegment("Slightly Delayed", 30, Color(0xFFC8E6C8)),
        DonutChartSegment("Delayed", 10, Color(0xFFBDBDBD)) // Grey color for delayed
    )
    ScaffoldBack(content = {
        TopNavigationBar(navController)
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(text = "Vendor Completion Overview", fontSize = 24.sp, fontWeight = FontWeight.Bold) // Added heading
            Spacer(modifier = Modifier.height(16.dp))
            Box(
                modifier = Modifier
                    .height(500.dp)
                    .fillMaxWidth(0.9f) // Fill 90% of the screen width
                    .background(Color(0xFFE0E0E0), shape = RoundedCornerShape(16.dp))
                    .padding(16.dp),
                contentAlignment = Alignment.Center // This ensures the content inside the box is centered
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    DonutChartWithLabels(segments)
                    Spacer(modifier = Modifier.height(16.dp))
                    Legend(segments)
                }
            }
        }
    }, navigator = navController)
}








@Composable
fun DonutChartWithLabels(segments: List<DonutChartSegment>) {
    val strokeWidth = 40.dp
    val styles = segments.map { segment ->
        SegmentStyle(segment.color, strokeWidth)
    }

    Box(
        modifier = Modifier.size(250.dp),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.matchParentSize()) {
            var startAngle = 0f
            segments.forEachIndexed { index, segment ->
                val sweep = segment.percentage * 3.6f
                drawArc(
                    color = styles[index].color,
                    startAngle = startAngle,
                    sweepAngle = sweep,
                    useCenter = false,
                    style = Stroke(width = styles[index].strokeWidth.toPx(), cap = StrokeCap.Round),
                    size = size,
                    topLeft = Offset.Zero
                )
                startAngle += sweep
            }
        }


    }
}


@Composable
fun Legend(segments: List<DonutChartSegment>) {
    Column(
        modifier = Modifier.padding(start = 32.dp) // Added padding to move the legend more to the left
    ) {
        segments.forEach { segment ->
            Row(
                modifier = Modifier.padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(16.dp)
                        .background(segment.color)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "${segment.label} (${segment.percentage}%)", fontSize = 16.sp) // Added percentage to the label
            }
        }
    }
}




data class DonutChartSegment(val label: String, val percentage: Int, val color: Color)
data class SegmentStyle(val color: Color, val strokeWidth: Dp)


