import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performScrollTo
import androidx.compose.ui.test.performTextInput
import com.gowittgroup.uishift.ScreenRenderingEngine
import com.gowittgroup.uishift.data.ConfigRepositoryImpl
import com.gowittgroup.uishift.screen.ScreenViewModel
import com.gowittgroup.uishift.testData
import org.junit.Rule
import org.junit.Test

class ScreenRenderingEngineTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testSampleConfigScreen() {
        // Set the content with the sample JSON configuration
        composeTestRule.setContent {
            val configRepository = ConfigRepositoryImpl(testData)
            ScreenRenderingEngine(ScreenViewModel(configRepository))
        }

        // Verify the welcome text is displayed
        composeTestRule.onNodeWithText("Welcome to Your Application")
            .assertIsDisplayed()

        // Verify the app description is displayed
        composeTestRule.onNodeWithText("This application helps you manage your tasks efficiently.")
            .assertIsDisplayed()

        // Verify the app image is displayed
        composeTestRule.onNodeWithContentDescription("App screenshot")
            .assertIsDisplayed()

        // Check that the Start Now button is displayed and clickable
        composeTestRule.onNodeWithText("Start Now")
            .assertIsDisplayed()
            .performClick()

        // Check that the More Info button is displayed and clickable
        composeTestRule.onNodeWithText("More Info")
            .assertIsDisplayed()
            .performClick()

        // Verify the User Name input field
        composeTestRule.onNodeWithText("Your Name")
            .performTextInput("John Doe")

        // Verify the Email input field
        composeTestRule.onNodeWithText("Email Address")
            .performTextInput("john.doe@example.com")

        // Scroll to the parent of the checkbox and then interact with it
        composeTestRule.onNodeWithText("I accept the terms and conditions")
            .performScrollTo() // This scrolls the parent if necessary
            .performClick() // Click to check the checkbox

        // Scroll to the parent of the red radio button and then interact with it
        composeTestRule.onNodeWithText("Red")
            .performScrollTo()
            .performClick() // Click to select the radio button

        // Scroll to the parent of the switch for enabling the bot and then verify it
        // TODO: Need to check assertDisplay not working 
        composeTestRule.onNodeWithText("Enable bot")
            .performScrollTo()


        // Scroll to the Submit button and verify it
        composeTestRule.onNodeWithText("Submit")
            .performScrollTo()
            .assertIsDisplayed()
            .performClick()

        // Scroll to the Cancel button and verify it
        composeTestRule.onNodeWithText("Cancel")
            .performScrollTo()
            .assertIsDisplayed()
            .performClick()

        // Verify the footer text is displayed
        composeTestRule.onNodeWithText("Thank you for using our app!")
            .assertIsDisplayed()
    }
}



