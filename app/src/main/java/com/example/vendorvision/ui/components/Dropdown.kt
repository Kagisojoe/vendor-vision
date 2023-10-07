package com.example.vendorvision.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import com.example.vendorvision.ui.theme.lightGreen
import com.example.vendorvision.ui.theme.tealGreen
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
fun dropDownMenu(label: MutableState<String>, options: List<String>, width: Dp, height: Dp, onValueChange: (String) -> Unit= {}){
    var expanded by remember { mutableStateOf(false) }
    var textFieldSize by  remember { mutableStateOf(Size.Zero) }

    val icon = if (expanded){
        Icons.Filled.KeyboardArrowUp
    }else {
        Icons.Filled.KeyboardArrowDown
    }

    Column(
    ) {
        Row(
            modifier = Modifier
                .width(width)
                .height(height)
                .border(
                    width = 1.dp,
                    color = Color.White,
                    shape = RoundedCornerShape(12)
                )
                .padding(PaddingValues(horizontal = 8.dp, vertical = 8.dp))
                .onGloballyPositioned { coordinates ->
                    textFieldSize = coordinates.size.toSize()
                }
            ,
            horizontalArrangement = Arrangement.SpaceBetween,
        ){
            Text(
                text = label.value, color =Color.Black, fontSize = 13.sp, modifier = Modifier.clickable {
                    expanded = !expanded
                })
            Icon(icon, contentDescription = "Icon", Modifier.clickable {
                expanded = !expanded
            }, tint = Color.Black)
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .width(with(LocalDensity.current) { textFieldSize.width.toDp() })
                .background(Color.White)
        ) {
            options.forEach{ item ->
                DropdownMenuItem(onClick = {
                    label.value = item
                    expanded = false
                    onValueChange(item)
                }) {
                    Text(
                        text = item, fontSize = 11.sp)
                }
            }
        }
    }
}

@Composable
fun GradientDropDownMenu(
    chartSelected: MutableState<String>,
    chartType: List<String> = listOf("Trend", "Service Spend", "Service Usage", "Product Spend")
){
    var expanded by remember { mutableStateOf(false) }
    var textFieldSize by  remember { mutableStateOf(Size.Zero) }

    val icon = if (expanded){
        Icons.Filled.KeyboardArrowUp
    }else {
        Icons.Filled.KeyboardArrowDown
    }

    Column(
    ) {
        Row(
            modifier = Modifier
                .width(230.dp)
                .height(40.dp)
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
                .padding(PaddingValues(horizontal = 8.dp, vertical = 8.dp))
                .onGloballyPositioned { coordinates ->
                    textFieldSize = coordinates.size.toSize()
                }
            ,
            horizontalArrangement = Arrangement.SpaceBetween,
        ){
            Text(
                text = "Change Analysis Tool", color =Color.Black, fontSize = 13.sp, modifier = Modifier.clickable {
                    expanded = !expanded
                })
            Icon(icon, contentDescription = "Icon", Modifier.clickable {
                expanded = !expanded
            }, tint = Color.Black)
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .width(with(LocalDensity.current) { textFieldSize.width.toDp() })
                .background(Color.White)
        ) {
            chartType.forEach{ item ->
                DropdownMenuItem(onClick = {
                    expanded = false
                    chartSelected.value = item
                }) {
                    Text(
                        text = item, fontSize = 11.sp)
                }
            }
        }
    }
}