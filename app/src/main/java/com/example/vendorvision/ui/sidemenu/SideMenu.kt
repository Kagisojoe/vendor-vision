package com.example.vendorvision.ui.sidemenu

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vendorvision.R
import com.example.vendorvision.destinations.TrendAnalysisDestination
import com.example.vendorvision.destinations.VendorManagementDestination
import com.example.vendorvision.ui.navbar.NavBar
import com.example.vendorvision.ui.theme.DarkGreen
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)

@Composable
fun SideMenu(
    content: @Composable (contentPadding: PaddingValues) -> Unit,
    navigator: DestinationsNavigator
){
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            NavBar(
                onNavClick = {
                    scope.launch {
                        scaffoldState.drawerState.open()
                    }
                }
            )
        },
        drawerContent = {
            DrawerHeader(
                onNavClick = {
                    scope.launch {
                        scaffoldState.drawerState.close()
                    }
                }
            )
            DrawerBody(
                items = listOf(
                    MenuItem(
                        id = "home",
                        title = "Home",
                        icon = R.drawable.home
                    ),
                    MenuItem(
                        id = "vendors",
                        title = "Vendors",
                        icon = R.drawable.shop
                    ),
                    MenuItem(
                        id = "analytics",
                        title = "Analytics",
                        icon = R.drawable.chart
                    ),
                    MenuItem(
                        id = "approval",
                        title = "Approval",
                        icon = R.drawable.approval
                    )
                ),
                onItemClick = {
                    when(it.id){
                        "vendors" -> {
                            navigator.navigate(
                                VendorManagementDestination
                            )
                        }
                        "analytics" -> {
                            navigator.navigate(
                                TrendAnalysisDestination
                            )
                        }
                    }
                }
            )
        },
        content = {
            content(it)
        }
    )
}

@Composable
fun DrawerHeader(
    onNavClick: () -> Unit
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp)
    ) {
        Icon(imageVector = Icons.Filled.Menu,
            contentDescription = "burger menu",
            modifier = Modifier
                .clickable {
                    onNavClick()
                }
                .size(30.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(65.dp)
                .background(
                    color = DarkGreen
                )
                .padding(horizontal = 10.dp)
        ){
            Image(painter = painterResource(R.drawable.avatar), contentDescription = "icon" )
            Column(
            ) {
                Text(text = "Joe Doe", fontWeight = FontWeight.SemiBold, color = Color.White)
                Text(text = "doejoe@gmail.com", fontSize = 12.sp, color = Color.White)
                Text(text = "Manager", fontSize = 12.sp, color = Color.White)
            }
        }
        Spacer(modifier = Modifier.width(16.dp))
    }
}

@Composable
fun DrawerBody(
    items: List<MenuItem>,
    modifier: Modifier = Modifier,
    itemTextStyle: TextStyle = TextStyle(fontSize =18.sp),
    onItemClick: (MenuItem) -> Unit
){
    LazyColumn(modifier){
        items(items){ item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onItemClick(item)
                    }
                    .padding(16.dp)
            ){
                Image(painter = painterResource(item.icon), contentDescription = "icon" )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = item.title,
                    modifier = Modifier.weight(1f),
                    style = itemTextStyle
                )
            }

        }
    }
}

data class MenuItem(
    val id: String,
    val title: String,
    val icon: Int
)