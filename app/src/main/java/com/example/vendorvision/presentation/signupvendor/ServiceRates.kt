package com.example.vendorvision.presentation.signupvendor

import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.vendorvision.R
import com.example.vendorvision.destinations.CompanyInformationDestination
import com.example.vendorvision.destinations.PersonalInformationDestination
import com.example.vendorvision.destinations.VendorSignUpDestination
import com.example.vendorvision.presentation.GradientButton
import com.example.vendorvision.presentation.StandardButton
import com.example.vendorvision.ui.components.dropDownMenu
import com.example.vendorvision.ui.sidemenu.ScaffoldBack
import com.example.vendorvision.ui.theme.backgroundLime
import com.example.vendorvision.ui.theme.lightGreen
import com.example.vendorvision.ui.theme.tealGreen
import com.example.vendorvision.viewmodels.UserStatus
import com.example.vendorvision.viewmodels.VendorSigUpViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.launch


@Destination
@Composable
fun ServiceRates(
    vendorSigUpViewModel: VendorSigUpViewModel,
    navigator: DestinationsNavigator
){
    val serviceRateArray = remember{
        mutableStateOf(ArrayList<ServiceRate>())
    }

    val serviceNameEdited = remember {
        mutableStateOf("")
    }
    val rateNameEdited = remember {
        mutableStateOf("")
    }

    val scope = rememberCoroutineScope()

    val context = LocalContext.current

    ScaffoldBack(
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(
                                lightGreen,
                                lightGreen,
                                tealGreen
                            )
                        )
                    )
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 15.dp, vertical = 20.dp),
            ){
                Text(text = "Services Rendered", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White)
                Spacer(modifier = Modifier.padding(5.dp))
                Title(title = "Select services and rates")
                Spacer(modifier = Modifier.padding(5.dp))
                serviceRateArray.value.forEachIndexed { index, serviceRate ->
                    serviceNameEdited.value = serviceRate.service
                    rateNameEdited.value = serviceRate.rate
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()
                    ){
                        Column{
                            Text(text = "Service", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color.White)
                            dropDownMenu(
                                label = serviceNameEdited,
                                options = vendorSigUpViewModel.services,
                                onValueChange = {
                                    vendorSigUpViewModel.service.value = it
                                },
                                width = 160.dp,
                                height = 40.dp
                            )
                        }
                        Column {
                            Text(
                                text = "Rate",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                            dropDownMenu(
                                label = rateNameEdited,
                                options = vendorSigUpViewModel.rates,
                                onValueChange = {
                                    vendorSigUpViewModel.rate.value = it
                                },
                                width = 160.dp,
                                height = 40.dp
                            )
                        }
                    }
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                ){
                    Column{
                        Text(text = "Service", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color.White)
                        dropDownMenu(
                            label = vendorSigUpViewModel.service,
                            options = vendorSigUpViewModel.services,
                            onValueChange = {
                                vendorSigUpViewModel.service.value = it
                            },
                            width = 160.dp,
                            height = 40.dp
                        )
                    }
                    Column {
                        Text(
                            text = "Rate",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        dropDownMenu(
                            label = vendorSigUpViewModel.rate,
                            options = vendorSigUpViewModel.rates,
                            onValueChange = {
                                vendorSigUpViewModel.rate.value = it
                            },
                            width = 160.dp,
                            height = 40.dp
                        )
                    }
                }
                Spacer(modifier = Modifier.padding(5.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ){
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .background(
                                color = Color.Black,
                                shape = RoundedCornerShape(12.dp)
                            )
                            .width(60.dp)
                            .height(40.dp)
                            .padding()
                            .clickable {
                                serviceRateArray.value.add(
                                    ServiceRate(
                                        vendorSigUpViewModel.service.value,
                                        vendorSigUpViewModel.rate.value
                                    )
                                )
                            }
                    ){
                        Icon(imageVector = Icons.Outlined.Add, contentDescription = "Add", tint = Color.White)
                        Title("Add")
                    }
                }
                Spacer(Modifier.weight(1f))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ){
                    StandardButton(
                        title = "Save",
                        width = 150.dp,
                        height = 50.dp,
                        modifier = Modifier.clickable {
                            scope.launch {
                                vendorSigUpViewModel.saveVendor()
                            }
                        }
                    )
                }

                vendorSigUpViewModel.userSaved.value.let {
                    when(it){
                        UserStatus.Failed -> {
                            Toast.makeText(
                                context,
                                "failed to make request",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                        UserStatus.Saved -> {
                            Toast.makeText(
                                context,
                                "Vendor added successfully!",
                                Toast.LENGTH_LONG
                            ).show()
                            navigator.navigate(
                                VendorSignUpDestination
                            )
                        }
                        UserStatus.Non -> {
                        }
                    }
                }
            }
        } ,
        navigator
    )
}

data class ServiceRate(
    val service: String,
    val rate: String
)