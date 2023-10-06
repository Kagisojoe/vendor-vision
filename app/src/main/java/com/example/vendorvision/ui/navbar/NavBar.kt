package com.example.vendorvision.ui.navbar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vendorvision.R

@Composable
fun NavBar(
    onNavClick: () -> Unit
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .shadow(
                elevation = 1.dp,
            )
    ){
        Icon(imageVector = Icons.Filled.Menu,
            contentDescription = "burger menu",
        modifier = Modifier
            .clickable {
                onNavClick()
            })
        Image(painter = painterResource(id = R.drawable.logo),
            contentDescription = "logo"
        )
        Icon(imageVector = Icons.Filled.Notifications,
            contentDescription = "notification")
    }
}


