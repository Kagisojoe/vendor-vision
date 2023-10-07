package com.example.vendorvision.presentation.signupvendor

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.vendorvision.destinations.CompanyInformationDestination
import com.example.vendorvision.destinations.DocumentsDestination
import com.example.vendorvision.presentation.StandardButton
import com.example.vendorvision.ui.components.reusableFormTextField
import com.example.vendorvision.ui.sidemenu.ScaffoldBack
import com.example.vendorvision.ui.theme.backgroundLime
import com.example.vendorvision.ui.theme.lightGreen
import com.example.vendorvision.ui.theme.tealGreen
import com.example.vendorvision.viewmodels.VendorSigUpViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator


@Destination
@Composable
fun CompanyInformation(
    vendorSigUpViewModel: VendorSigUpViewModel,
    navigator: DestinationsNavigator
){

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
                Text(text = "Company Profile", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White)
                Spacer(modifier = Modifier.padding(5.dp))
                Title("Company Name")
                reusableFormTextField(
                    value = vendorSigUpViewModel.company.value,
                    onValueChange = {
                        vendorSigUpViewModel.company.value = it
                    },
                    placeholder = "Enter company name",
                    singleLine = true,
                    width = 380.dp,
                    height = 60.dp
                )
                Spacer(modifier = Modifier.padding(5.dp))
                Title("Company Email")
                reusableFormTextField(
                    value = vendorSigUpViewModel.compyEmail.value,
                    onValueChange = {
                        vendorSigUpViewModel.compyEmail.value = it
                    },
                    placeholder = "Enter company email",
                    singleLine = true,
                    width = 380.dp,
                    height = 60.dp
                )
                Title("Company PhoneNumber")
                reusableFormTextField(
                    value = vendorSigUpViewModel.companyNumber.value,
                    onValueChange = {
                        vendorSigUpViewModel.companyNumber.value = it
                    },
                    placeholder = "Enter company number",
                    singleLine = true,
                    width = 380.dp,
                    height = 60.dp
                )
                Spacer(modifier = Modifier.padding(5.dp))
                Title("Company Address")
                reusableFormTextField(
                    value = vendorSigUpViewModel.companyAddress.value,
                    onValueChange = {
                        vendorSigUpViewModel.companyAddress.value = it
                    },
                    placeholder = "Enter company address",
                    singleLine = false,
                    width = 380.dp,
                    height = 60.dp
                )
                Title("Company Country")
                reusableFormTextField(
                    value = vendorSigUpViewModel.companyCountry.value,
                    onValueChange = {
                        vendorSigUpViewModel.companyCountry.value = it
                    },
                    placeholder = "Enter company country",
                    singleLine = false,
                    width = 380.dp,
                    height = 60.dp
                )
                Title("Company City")
                reusableFormTextField(
                    value = vendorSigUpViewModel.companyCity.value,
                    onValueChange = {
                        vendorSigUpViewModel.companyCity.value = it
                    },
                    placeholder = "Enter company city",
                    singleLine = false,
                    width = 380.dp,
                    height = 60.dp
                )
                Title("Company Postal Code")
                reusableFormTextField(
                    value = vendorSigUpViewModel.postalCode.value,
                    onValueChange = {
                        vendorSigUpViewModel.postalCode.value = it
                    },
                    placeholder = "Enter company postal code",
                    singleLine = false,
                    width = 380.dp,
                    height = 60.dp
                )
                Spacer(Modifier.weight(1f))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ){
                    StandardButton(
                        title = "Next",
                        width = 150.dp,
                        height = 50.dp,
                        modifier = Modifier.clickable {
                            navigator.navigate(
                                DocumentsDestination
                            )
                        }
                    )
                }
            }
        } ,
        navigator
    )
}