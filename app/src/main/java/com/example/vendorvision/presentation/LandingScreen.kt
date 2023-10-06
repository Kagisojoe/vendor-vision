package com.example.vendorvision.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.vendorvision.R
import com.example.vendorvision.ui.theme.DarkGreen
import com.example.vendorvision.ui.theme.backgroundLime
import com.example.vendorvision.ui.theme.lightGreen
import com.example.vendorvision.ui.theme.tealGreen

@Preview
@Composable
fun LandingScreen(

){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        lightGreen,
                        lightGreen,
                        tealGreen
                    )
                )
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Spacer(Modifier.weight(0.5f))
        Image(painter = painterResource(id = R.drawable.logo),
            contentDescription = "logo",
            modifier = Modifier
                .size(120.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))
        Image(painter = painterResource(id = R.drawable.appname),
            contentDescription = "appname",
            modifier = Modifier
                .size(200.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))
        Text("Sign in as",
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start,
            modifier = Modifier.padding(end = 150.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        GradientButton(
            title = "Vendor"
        )
        Spacer(modifier = Modifier.height(30.dp))
        StandardButton(
            title = "Old Mutual"
        )
        Spacer(Modifier.weight(1f))
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text("Powered by Old Mutual ")
            Spacer(modifier = Modifier.height(5.dp))
            Image(painter = painterResource(id = R.drawable.logo),
                contentDescription = "logo",
                modifier = Modifier
                    .size(20.dp)
            )
        }
    }
}


@Composable
fun GradientButton(
    title: String,
    width: Dp = 230.dp,
    height: Dp = 40.dp
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .width(width)
            .height(height)
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        lightGreen,
                        lightGreen,
                        tealGreen
                    )
                ),
                shape = RoundedCornerShape(
                    12.dp
                )
            )
    ) {
        Text(
            text = title,
            color = Color.White
        )
    }
}

@Composable
fun StandardButton(
    title: String,
    width: Dp = 230.dp,
    height: Dp = 40.dp
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .width(width)
            .height(height)
            .background(
                color = DarkGreen,
                shape = RoundedCornerShape(
                    12.dp
                )
            )
    ) {
        Text(
            text = title,
            color = Color.White
        )
    }
}