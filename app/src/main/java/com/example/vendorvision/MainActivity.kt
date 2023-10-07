package com.example.vendorvision

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.amplifyframework.AmplifyException
import com.amplifyframework.core.Amplify
import com.amplifyframework.datastore.AWSDataStorePlugin
import com.example.vendorvision.ui.theme.VendorVisionTheme
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.navigation.material.ModalBottomSheetLayout
import com.google.accompanist.navigation.material.rememberBottomSheetNavigator
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.rememberNavHostEngine
import com.amplifyframework.datastore.generated.model.AmplifyModelProvider;
import com.example.vendorvision.viewmodels.VendorSigUpViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.dependency
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class, ExperimentalMaterialNavigationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            try {
                Amplify.addPlugin(AWSDataStorePlugin())
                Amplify.configure(applicationContext)

                Log.i("Tutorial", "Initialized Amplify")
            } catch (error: AmplifyException) {
                Log.e("Tutorial", "Could not initialize Amplify", error)
            }

            CompositionLocalProvider(){
                VendorVisionTheme {
                    val navController = rememberAnimatedNavController()
                    val bottomSheetNavigator = rememberBottomSheetNavigator()
                    navController.navigatorProvider.addNavigator(bottomSheetNavigator)
                    ModalBottomSheetLayout(bottomSheetNavigator = bottomSheetNavigator ) {
                        DestinationsNavHost(
                            navGraph = NavGraphs.root,
                            navController = navController,
                            engine = rememberNavHostEngine(),
                            dependenciesContainerBuilder = {
                                //dependency(hiltViewModel<OTPViewModel>())

                                dependency(NavGraphs.root) {
                                    val parentEntry = remember(navBackStackEntry) {
                                        navController.getBackStackEntry(NavGraphs.root.route)
                                    }
                                    hiltViewModel<VendorSigUpViewModel>(parentEntry)
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}

//@RootNavGraph(start = true)
@Destination()
@Composable
fun Greeting() {
    Text(text = "Hello!")
}
