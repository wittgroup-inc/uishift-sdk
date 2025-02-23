/**
 * Copyright © 2025 WITT Group.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at:
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */ 
package com.gowittgroup.uishift.sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gowittgroup.uishift.ScreenRenderingEngine
import com.gowittgroup.uishift.data.ApiRepository
import com.gowittgroup.uishift.data.ConfigRepositoryImpl
import com.gowittgroup.uishift.network.ApiService
import com.gowittgroup.uishift.sample.sampledata.local.detailScreenConfig
import com.gowittgroup.uishift.sample.sampledata.local.homeScreenConfig
import com.gowittgroup.uishift.sample.sampledata.sampleConfigJson
import com.gowittgroup.uishift.sample.theme.UIShiftTheme
import com.gowittgroup.uishift.screen.ScreenViewModel
import okhttp3.OkHttpClient
import registerScreenConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 *  val colorScheme = lightColorScheme(primaryButtonBackground = Color.Red)
 *  UiShift.initialize(colorScheme = colorScheme)
 */

/**
 *  Log.d("Design Config Using Kotlin", ConfigParser().toJson(config = homeScreenConfig))
 */


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UIShiftTheme {
                Scaffold(modifier = Modifier.fillMaxSize().background(color = Color.White)) { innerPadding ->
                    val navController = rememberNavController()
                    Box(modifier = Modifier.padding(innerPadding)){
                        NavHost(navController = navController, startDestination = "home") {
                            composable("register") { RegisterScreen(navController) }
                            composable("home") { HomeScreen(navController) }
                            composable("details") { DetailsScreen(navController) }
                        }
                    }

                }
            }
        }
    }


}

@Composable
private fun DetailsScreen(navController: NavHostController) {
    val configRepository = ConfigRepositoryImpl(detailScreenConfig)
    val apiRepository = ApiRepository(RetrofitInstance.apiService)
    ScreenRenderingEngine(
        ScreenViewModel(configRepository, apiRepository), navController
    )
}

@Composable
private fun RegisterScreen(navController: NavHostController) {
    val configRepository = ConfigRepositoryImpl(registerScreenConfig)
    ConfigRepositoryImpl(sampleConfigJson)
    val apiRepository = ApiRepository(RetrofitInstance.apiService)
    ScreenRenderingEngine(
        ScreenViewModel(configRepository, apiRepository), navController
    )
}

@Composable
private fun HomeScreen(navController: NavHostController) {
        val configRepository = ConfigRepositoryImpl(homeScreenConfig)
        val apiRepository = ApiRepository(RetrofitInstance.apiService)
        ScreenRenderingEngine(
            ScreenViewModel(configRepository, apiRepository), navController
        )
}


object RetrofitInstance {

    private const val BASE_URL = "https://yourapi.com/" // Replace with your base URL
    private val client = OkHttpClient.Builder().build()

    private val retrofit: Retrofit =
        Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .client(client).build()

    val apiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}