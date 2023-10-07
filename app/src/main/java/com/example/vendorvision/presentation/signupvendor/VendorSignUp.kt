package com.example.vendorvision.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vendorvision.R
import com.example.vendorvision.destinations.PersonalInformationDestination
import com.example.vendorvision.ui.sidemenu.ScaffoldBack
import com.example.vendorvision.ui.theme.backgroundLime
import com.example.vendorvision.ui.theme.lightGreen
import com.example.vendorvision.ui.theme.tealGreen
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun VendorSignUp(
    navigator: DestinationsNavigator
){
    ScaffoldBack(
       content = {
           Column(
               modifier = Modifier
                   .fillMaxSize()
                   .background(
                       color = backgroundLime
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
               GradientButton(
                   title = "Sign up",
                   modifier = Modifier.clickable {
                       navigator.navigate(
                           PersonalInformationDestination
                       )
                   }
               )
               Spacer(modifier = Modifier.height(30.dp))
               StandardButton(
                   title = "Login",
                   modifier = Modifier
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
       } ,
        navigator
    )

}