package com.example.vendorvision.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class VendorSigUpViewModel @Inject constructor(): ViewModel(){
    var firstName = mutableStateOf("")
    var lastName = mutableStateOf("")
    var company = mutableStateOf("")
    var email = mutableStateOf("")
    var password = mutableStateOf("")
    var compyEmail = mutableStateOf("")
    var beee = mutableStateOf("")
    var service = mutableStateOf("Select a service")
    var services = mutableListOf("Software", "Resource", "Retail", "Transport", "Facility")
    var rate = mutableStateOf("Select a rate")
    var rates = mutableListOf("R50k - R75k", "R76k - R100k", "R101k - R125k", "R126k - R150k", "R151k - R200k")
}