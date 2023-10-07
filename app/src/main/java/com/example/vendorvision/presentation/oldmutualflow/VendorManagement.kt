package com.example.vendorvision.presentation.oldmutualflow

import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vendorvision.presentation.GradientButton
import com.example.vendorvision.presentation.StandardButton
import com.example.vendorvision.ui.sidemenu.SideMenu
import com.example.vendorvision.ui.theme.Morning
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun VendorManagement(
    navigator: DestinationsNavigator
){
    SideMenu(
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
                    .padding(vertical = 50.dp, horizontal = 20.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    GradientButton(
                        title = "Vendor Requests",
                        modifier = Modifier.clickable {

                        },
                        width = 330.dp,
                        height = 60.dp
                    )
                }
                Spacer(modifier = Modifier.height(30.dp))
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    StandardButton(
                        title = "Existing Vendors",
                        modifier = Modifier.clickable {

                        },
                        width = 330.dp,
                        height = 60.dp
                    )
                }
                Spacer(modifier = Modifier.height(30.dp))
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    GradientButton(
                        title = "Vendor Analysis",
                        modifier = Modifier.clickable {

                        },
                        width = 330.dp,
                        height = 60.dp
                    )
                }
            }
        },
        navigator
    )
}
