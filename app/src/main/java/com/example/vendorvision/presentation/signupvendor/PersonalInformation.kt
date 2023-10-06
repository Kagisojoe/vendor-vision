package com.example.vendorvision.presentation.signupvendor

import android.app.Person
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.vendorvision.presentation.StandardButton
import com.example.vendorvision.ui.components.reusableFormTextField
import com.example.vendorvision.ui.theme.backgroundLime
import com.example.vendorvision.ui.theme.lightGreen
import com.example.vendorvision.ui.theme.tealGreen
import com.example.vendorvision.viewmodels.VendorSigUpViewModel

@Preview
@Composable
fun PersonalInformation(
    vendorSigUpViewModel: VendorSigUpViewModel = hiltViewModel()
){
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
        Text(text = "Personal Information", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White)
        Spacer(modifier = Modifier.padding(5.dp))
        Title("First Name")
        reusableFormTextField(
            value = vendorSigUpViewModel.firstName.value,
            onValueChange = {
                vendorSigUpViewModel.firstName.value = it
            },
            placeholder = "Enter first name",
            singleLine = true,
            width = 380.dp,
            height = 60.dp
        )
        Spacer(modifier = Modifier.padding(5.dp))
        Title("Last Name")
        reusableFormTextField(
            value = vendorSigUpViewModel.lastName.value,
            onValueChange = {
                vendorSigUpViewModel.lastName.value = it
            },
            placeholder = "Enter last name",
            singleLine = true,
            width = 380.dp,
            height = 60.dp
        )
        Spacer(modifier = Modifier.padding(5.dp))
        Title("Email")
        reusableFormTextField(
            value = vendorSigUpViewModel.email.value,
            onValueChange = {
                vendorSigUpViewModel.email.value = it
            },
            placeholder = "Enter email",
            singleLine = true,
            width = 380.dp,
            height = 60.dp
        )
        Spacer(modifier = Modifier.padding(5.dp))
        Title("Password")
        reusableFormTextField(
            value = vendorSigUpViewModel.password.value,
            onValueChange = {
                vendorSigUpViewModel.password.value = it
            },
            placeholder = "Enter password",
            singleLine = true,
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
                height = 50.dp
            )
        }
    }
}

@Composable
fun Title(
    title: String,
){
    Text(title, color = Color.White)
}