package com.example.vendorvision.presentation.signupvendor

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.IosShare
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.outlined.IosShare
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.vendorvision.presentation.StandardButton
import com.example.vendorvision.ui.theme.backgroundLime
import com.example.vendorvision.ui.theme.lightGreen
import com.example.vendorvision.ui.theme.tealGreen
import com.example.vendorvision.viewmodels.VendorSigUpViewModel
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File
import java.util.*

@Preview
@Composable
fun Documents(
    vendorSigUpViewModel: VendorSigUpViewModel = hiltViewModel()
){

    val context = LocalContext.current

    var documents = Intent()
    documents = Intent(Intent.ACTION_OPEN_DOCUMENT)
    documents.addCategory(Intent.CATEGORY_OPENABLE)
    documents.type = "application/pdf"

    var beee by remember {
        mutableStateOf<Uri?>(null)
    }

    val launcherPersonal = rememberLauncherForActivityResult(contract =
    ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
        when (result.resultCode) {
            Activity.RESULT_OK -> {
                result.data?.data?.let { uri ->
                    beee = uri
                }
                Toast.makeText(context, "uploading file", Toast.LENGTH_LONG).show();
            }
            Activity.RESULT_CANCELED -> {
                Toast.makeText(context, "No file uploaded", Toast.LENGTH_LONG).show();
            }
            else -> {
                Toast.makeText(context, "Failed!!", Toast.LENGTH_LONG).show();
            }
        }
    }

    fun convertRequest(uri: Uri): MultipartBody.Part {
        val file = File(uri.path)
        val random = UUID.randomUUID().toString()

        context.contentResolver.openInputStream(uri).use { inputStream ->
            val requestFile = RequestBody.create(context.contentResolver.getType(uri)?.let { it.toMediaTypeOrNull() }, inputStream!!.readBytes())
            val body = MultipartBody.Part.createFormData("file", file.name.plus(random), requestFile)
            return body
        }
    }

    fun getFileName(uri: Uri) {
        val file = File(uri.path)
        Log.d("file path", file.toString())
    }

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
        Text(text = "Company Documents", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White)
        Column(
            verticalArrangement = Arrangement.spacedBy(3.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.padding(5.dp))
            Title(title = "BEEE")
            OutlinedButton(
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Transparent
                ),
                border = BorderStroke(1.dp, Color.White),
                shape = RoundedCornerShape(15.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                onClick = {
                    launcherPersonal.launch(documents)

                }) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    Text(
                        text = "upload document", fontSize = 12.sp,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.weight(1f),
                        color = Color.White
                    )

                    Icon(
                        imageVector = Icons.Outlined.IosShare,
                        contentDescription = "Toggle drawer",
                        modifier = Modifier
                            .padding(0.dp)
                            .size(20.dp),
                        tint = Color.White
                    )
                }
            }
            Spacer(modifier = Modifier.padding(5.dp))
            Title(title = "Tax Certificate")
            OutlinedButton(
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Transparent
                ),
                border = BorderStroke(1.dp, Color.White),
                shape = RoundedCornerShape(15.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                onClick = {
                    launcherPersonal.launch(documents)

                }) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    Text(
                        text = "upload document", fontSize = 12.sp,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.weight(1f),
                        color = Color.White
                    )

                    Icon(
                        imageVector = Icons.Outlined.IosShare,
                        contentDescription = "Toggle drawer",
                        modifier = Modifier
                            .padding(0.dp)
                            .size(20.dp),
                        tint = Color.White
                    )
                }
            }
            Spacer(modifier = Modifier.padding(5.dp))
            Title(title = "CIPC Certificate")
            OutlinedButton(
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Transparent
                ),
                border = BorderStroke(1.dp, Color.White),
                shape = RoundedCornerShape(15.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                onClick = {
                    launcherPersonal.launch(documents)

                }) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    Text(
                        text = "upload document", fontSize = 12.sp,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.weight(1f),
                        color = Color.White
                    )

                    Icon(
                        imageVector = Icons.Outlined.IosShare,
                        contentDescription = "Toggle drawer",
                        modifier = Modifier
                            .padding(0.dp)
                            .size(20.dp),
                        tint = Color.White
                    )
                }
            }
            Spacer(modifier = Modifier.padding(5.dp))
            Title(title = "Other")
            OutlinedButton(
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Transparent
                ),
                border = BorderStroke(1.dp, Color.White),
                shape = RoundedCornerShape(15.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                onClick = {
                    launcherPersonal.launch(documents)

                }) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    Text(
                        text = "upload document", fontSize = 12.sp,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.weight(1f),
                        color = Color.White
                    )

                    Icon(
                        imageVector = Icons.Outlined.IosShare,
                        contentDescription = "Toggle drawer",
                        modifier = Modifier
                            .padding(0.dp)
                            .size(20.dp),
                        tint = Color.White
                    )
                }
            }
        }
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