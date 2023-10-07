package com.example.vendorvision.presentation.oldmutualflow

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vendorvision.R
import com.example.vendorvision.destinations.TrendAnalysisDestination
import com.example.vendorvision.destinations.VendorManagementDestination
import com.example.vendorvision.ui.sidemenu.SideMenu
import com.example.vendorvision.ui.theme.DarkGreen
import com.example.vendorvision.ui.theme.backgroundLime
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

//@Preview(
//    showBackground = true
//)
@Destination
@Composable
fun OMHome(
navigator: DestinationsNavigator
){
//    val imageLoader = ImageLoader.Builder(LocalContext.current)
//        .components {
//            add(SvgDecoder.Factory())
//        }
//        .build()

    SideMenu(
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        horizontal = 20.dp, vertical = 20.dp
                    ),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Column{
                   Row(
                       modifier = Modifier
                           .fillMaxWidth(),
                       verticalAlignment = Alignment.CenterVertically,
                       horizontalArrangement = Arrangement.End
                   ) {
                       Row(
                           verticalAlignment = Alignment.CenterVertically,
                           horizontalArrangement = Arrangement.Center,
                           modifier = Modifier
                               .background(
                                   color = backgroundLime,
                                   shape =  RoundedCornerShape(12.dp)
                               )
                               .border(
                                   width = 1.dp,
                                   brush = Brush.linearGradient(
                                       listOf(
                                           DarkGreen,
                                           DarkGreen,
                                           DarkGreen
                                       )
                                   ),
                                   shape = RoundedCornerShape(12.dp)
                               )
                               .padding()
                               .width(100.dp)
                               .height(40.dp)
                               .clickable {
                                   navigator.navigate(
                                       VendorManagementDestination
                                   )
                               }
                       ){
                           Text(
                               text = "See all",
                           )
                       }
                   }
                    Image(painter = painterResource(id = R.drawable.mainhine),
                        contentDescription = "main",
                        modifier = Modifier
                            .height(190.dp)
                    )
                }
                Column {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .background(
                                    color = backgroundLime,
                                    shape = RoundedCornerShape(12.dp)
                                )
                                .border(
                                    width = 1.dp,
                                    brush = Brush.linearGradient(
                                        listOf(
                                            DarkGreen,
                                            DarkGreen,
                                            DarkGreen
                                        )
                                    ),
                                    shape = RoundedCornerShape(12.dp)
                                )
                                .padding()
                                .width(100.dp)
                                .height(40.dp)
                                .clickable {
                                    navigator.navigate(
                                        TrendAnalysisDestination
                                    )
                                }
                        ) {
                            Text(
                                text = "See all",
                            )
                        }
                    }
                    Image(
                        painter = painterResource(id = R.drawable.budget),
                        contentDescription = "budget",
                        modifier = Modifier
                            .size(400.dp)
                    )
                }
            }
        },
        navigator = navigator
    )
}