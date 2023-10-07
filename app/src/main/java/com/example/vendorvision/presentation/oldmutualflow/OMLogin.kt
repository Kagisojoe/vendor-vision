package com.example.vendorvision.presentation.oldmutualflow

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.vendorvision.R
import com.example.vendorvision.destinations.OMHomeDestination
import com.example.vendorvision.destinations.TrendAnalysisDestination
import com.example.vendorvision.presentation.GradientButton
import com.example.vendorvision.presentation.StandardButton
import com.example.vendorvision.presentation.signupvendor.Title
import com.example.vendorvision.ui.components.reusableFormTextField
import com.example.vendorvision.ui.sidemenu.SideMenu
import com.example.vendorvision.ui.theme.backgroundLime
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun OMLogin(
    navigator: DestinationsNavigator
){
    val email = remember{
        mutableStateOf("")
    }
    val password = remember{
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = backgroundLime
            )
            .padding(vertical = 20.dp, horizontal = 20.dp),
    ) {
        Spacer(Modifier.weight(0.5f))
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "logo",
                modifier = Modifier
                    .size(120.dp)
            )
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.appname),
                contentDescription = "appname",
                modifier = Modifier
                    .size(200.dp)
            )
        }
        Spacer(modifier = Modifier.height(30.dp))
        Title("Email", color = Color.Black)
        reusableFormTextField(
            value = email.value,
            onValueChange = {
                email.value = it
            },
            placeholder = "Enter email",
            singleLine = true,
            width = 380.dp,
            height = 60.dp,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(10.dp))
        Title("Password", color = Color.Black)
        reusableFormTextField(
            value = password.value,
            onValueChange = {
                password.value = it
            },
            placeholder = "Enter password",
            singleLine = true,
            width = 380.dp,
            height = 60.dp,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(30.dp))
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            StandardButton(
                title = "Login",
                modifier = Modifier.clickable {
                    navigator.navigate(
                        OMHomeDestination
                    )
                }
            )
        }
        Spacer(Modifier.weight(1f))
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
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