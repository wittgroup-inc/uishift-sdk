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
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gowittgroup.uishift.ScreenRenderingEngine
import com.gowittgroup.uishift.constants.ButtonStyleToken
import com.gowittgroup.uishift.constants.ComponentType
import com.gowittgroup.uishift.constants.TextStyleToken
import com.gowittgroup.uishift.data.ApiRepository
import com.gowittgroup.uishift.data.ConfigRepositoryImpl
import com.gowittgroup.uishift.data.ConfigRepositoryImpl2
import com.gowittgroup.uishift.models.ScreenConfiguration
import com.gowittgroup.uishift.models.components.ButtonComponent
import com.gowittgroup.uishift.models.components.CheckBoxComponent
import com.gowittgroup.uishift.models.components.RowComponent
import com.gowittgroup.uishift.models.components.TextComponent
import com.gowittgroup.uishift.models.components.TextFieldComponent
import com.gowittgroup.uishift.models.properties.Action
import com.gowittgroup.uishift.models.properties.ActionFlow
import com.gowittgroup.uishift.models.properties.ActionSequence
import com.gowittgroup.uishift.models.properties.Field
import com.gowittgroup.uishift.models.properties.Request
import com.gowittgroup.uishift.models.properties.Validation
import com.gowittgroup.uishift.models.properties.common.Padding
import com.gowittgroup.uishift.models.properties.common.SizeOption
import com.gowittgroup.uishift.network.ApiService
import com.gowittgroup.uishift.parser.ConfigParser
import com.gowittgroup.uishift.sample.sampledata.sampleConfigJson
import com.gowittgroup.uishift.sample.theme.UIShiftTheme
import com.gowittgroup.uishift.screen.ScreenViewModel
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 *  val colorScheme = lightColorScheme(primaryButtonBackground = Color.Red)
 *  UiShift.initialize(colorScheme = colorScheme)
 */



val homeScreenConfig = ScreenConfiguration(
    listOf(
        TextComponent(
            content = "Registration", style = TextStyleToken.MAIN_TITLE, id = "screenTitle"
        ),

        TextFieldComponent(
            width = SizeOption.FillMaxSpace,
            padding = Padding(top = 8),
            id = "fullNameField",
            label = "Full name",
            hint = "Enter full name"
        ), TextFieldComponent(
            width = SizeOption.FillMaxSpace,
            padding = Padding(top = 8),
            id = "emailField", label = "Email",
            hint = "email@domain",
            validation = Validation.Text(regex = "^[^@]+@[^@]+\\.[^@]+\$")
        ),

        TextFieldComponent(
            width = SizeOption.FillMaxSpace,
            padding = Padding(top = 8),
            id = "password", label = "Password",
            hint = "password"
        ),
        CheckBoxComponent(
            width = SizeOption.FillMaxSpace,
            padding = Padding(top = 8),
            id = "termsAndCondition",
            label = "Accept the terms and condition."
        ),
        RowComponent(
            id = "buttons",
            width = SizeOption.FillMaxSpace,
            padding = Padding(start = 16, end = 16),
            children = listOf(
                ButtonComponent(
                    id = "registerButton",
                    style = ButtonStyleToken.PRIMARY_BUTTON,
                    height = SizeOption.Fixed(value = 60),
                    label = "Register",
                    onClickAction = ActionFlow.Sequence(
                        sequence = ActionSequence(
                                    core = Action.ApiRequest(
                                        requestModel = Request.Command(
                                            action = "",
                                            parameters = mapOf(),
                                            headers = mapOf(),
                                            endpoint = "register"
                                        ),
                                        retryCount = 0
                                    ),
                            prefixes = listOf(
                                Action.Validate(
                                    field = Field(
                                        id = "emailField",
                                        type = ComponentType.TEXT_FIELD
                                    ),
                                    validation = Validation.Text(regex = "^[^@]+@[^@]+\\.[^@]+\$")
                                ),
                                Action.Validate(
                                    field = Field(
                                        id = "termsAndCondition",
                                        type = ComponentType.CHECKBOX
                                    ),
                                    validation = Validation.Binary(required = true)
                                )
                            ),
                            postfixes = listOf(
                                Action.Navigate(
                                    destination = "details"
                                )
                            )
                        )
                    )
                ),
                ButtonComponent(
                    id = "cancelButton",
                    label = "Cancel",
                    style = ButtonStyleToken.TERTIARY_BUTTON,
                    onClickAction = ActionFlow.Single(
                        action = Action.Navigate(destination = "home")
                    )
                )
            )
        )
    )
)

val detailsScreenConfig = ScreenConfiguration(
    listOf(
        TextComponent(
            content = "Detail Screen", style = TextStyleToken.MAIN_TITLE, id = "screenTitle"
        ),

        TextComponent(
            content = "You successfully logged in!", style = TextStyleToken.MAIN_CONTENT, id = "description"
        )

    )
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        setContent {
            UIShiftTheme {
                Scaffold(modifier = Modifier.fillMaxSize().background(color = Color.White)) { innerPadding ->
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "home") {
                        composable("home") { HomeScreen(navController) }
                        composable("details") { DetailsScreen(navController) }
                    }
                }
            }
        }
    }


}

@Composable
private fun DetailsScreen(navController: NavHostController) {
    Log.d("Pawan>>>>>", ConfigParser().toJson(config = detailsScreenConfig))
    val configRepository = ConfigRepositoryImpl2(detailsScreenConfig)
    //ConfigRepositoryImpl(sampleConfigJson)
    val apiRepository = ApiRepository(RetrofitInstance.apiService)
    ScreenRenderingEngine(
        ScreenViewModel(configRepository, apiRepository), navController
    )
}

@Composable
private fun HomeScreen(navController: NavHostController) {


         Log.d("Pawan>>>>>", ConfigParser().toJson(config = homeScreenConfig))
        val configRepository = ConfigRepositoryImpl2(homeScreenConfig)
        ConfigRepositoryImpl(sampleConfigJson)
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