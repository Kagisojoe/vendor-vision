package com.example.vendorvision.ui.sidemenu

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.vendorvision.ui.theme.backgroundLime
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
fun ScaffoldBack(
    content: @Composable (contentPadding: PaddingValues) -> Unit,
    navigator: DestinationsNavigator
){
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = {
                        Text("")
                },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.Black,
                        modifier = Modifier.clickable {
                            navigator.popBackStack()
                        }
                            .size(50.dp)
                            .padding(horizontal = 10.dp)
                    )
                },
                backgroundColor = backgroundLime,
                elevation = 0.dp
            )
        },
        content = {
            content(it)
        }
    )
}