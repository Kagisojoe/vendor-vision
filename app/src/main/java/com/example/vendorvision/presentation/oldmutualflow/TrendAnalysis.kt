package com.example.vendorvision.presentation.oldmutualflow

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vendorvision.R
import com.example.vendorvision.ui.components.GradientDropDownMenu
import com.example.vendorvision.ui.sidemenu.SideMenu
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun TrendAnalysis(
    navigator: DestinationsNavigator
){
    var chartSelected = remember {
        mutableStateOf("Trend")
    }

    fun returnImage(): Int{
        when(chartSelected.value){
            "Trend" -> {
                return R.drawable.trendanalysis
            }
            "Service Spend" -> {
                return R.drawable.bars
            }
            "Service Usage" -> {
                return R.drawable.linechart
            }
            "Product Spend" -> {
                return R.drawable.product
            }
        }

        return 0
    }
    SideMenu(content = {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 10.dp, horizontal = 20.dp)
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            Image(painter = painterResource(id = returnImage()),
                contentDescription = "chart",
                modifier = Modifier
                    .size(500.dp)
            )
            Spacer(modifier = Modifier.height(30.dp))
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                GradientDropDownMenu(
                    chartSelected = chartSelected
                )
            }
        }
    }, navigator = navigator)
}