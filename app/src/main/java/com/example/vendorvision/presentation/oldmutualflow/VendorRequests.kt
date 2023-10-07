package com.example.vendorvision.presentation.oldmutualflow

import VendorsPage
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.amplifyframework.datastore.generated.model.Vendor
import com.example.vendorvision.ui.sidemenu.SideMenu
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun VendorRequests(
    navigator: DestinationsNavigator
){
    SideMenu(
        content = {
            VendorsPage(
                navigator
            )
        },
        navigator)
}