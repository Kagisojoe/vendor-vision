package com.example.vendorvision.viewmodels

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amplifyframework.core.Amplify
import com.amplifyframework.datastore.generated.model.Vendor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

enum class UserStatus{
     Saved,
     Failed,
    Non
}
@HiltViewModel
class VendorSigUpViewModel @Inject constructor(): ViewModel(){
    var firstName = mutableStateOf("")
    var lastName = mutableStateOf("")
    var company = mutableStateOf("")
    var email = mutableStateOf("")
    var password = mutableStateOf("")
    var compyEmail = mutableStateOf("")
    var companyAddress = mutableStateOf("")
    var companyNumber = mutableStateOf("")
    var companyCountry = mutableStateOf("")
    var companyCity = mutableStateOf("")
    var postalCode = mutableStateOf("")
    var beee = mutableStateOf("")
    var taxCertificate = mutableStateOf("")
    var cipcCertificate = mutableStateOf("")
    var otherCertificate = mutableStateOf("")
    var service = mutableStateOf("Select a service")
    var services = mutableListOf("Software", "Resource", "Retail", "Transport", "Facility")
    var rate = mutableStateOf("Select a rate")
    var rates = mutableListOf("R50k - R75k", "R76k - R100k", "R101k - R125k", "R126k - R150k", "R151k - R200k")

    var userSaved = mutableStateOf(UserStatus.Non)


    suspend fun saveVendor(){
        viewModelScope.launch {
            val vendor = Vendor.Builder()
                .firstName(firstName.value)
                .lastName(lastName.value)
                .email(email.value)
                .password(password.value)
                .companyName(company.value)
                .companyEmail(compyEmail.value)
                .companyAddress(companyAddress.value)
                .companyNumber(companyNumber.value)
                .companyCountry(companyCountry.value)
                .companyCity(companyCity.value)
                .postalCode(postalCode.value)
                .beeeCertificate(beee.value)
                .taxCertificate(taxCertificate.value)
                .cipcCertificate(cipcCertificate.value)
                .otherCertificate(otherCertificate.value)
                .build()

            Amplify.DataStore.save(vendor,
                { Log.i("Tutorial", "Saved item: ${vendor.firstName}")
                    userSaved.value = UserStatus.Saved
                },
                { Log.e("Tutorial", "Could not save item to DataStore", it)
                    userSaved.value = UserStatus.Failed
                }
            )
        }
    }

    suspend fun getVendor() {
        viewModelScope.launch {
            Amplify.DataStore.query(Vendor::class.java,
                { vendors ->
                    while (vendors.hasNext()) {
                        val vendor: Vendor = vendors.next()
                        Log.i("Tutorial", "Name: ${vendor.firstName}")
                    }
                },
                { Log.e("Tutorial", "Could not query DataStore", it) }
            )
        }
    }
}