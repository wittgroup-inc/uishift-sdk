import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.gowittgroup.uishift.ScreenRenderingEngine
import com.gowittgroup.uishift.schema.testData
import org.junit.Rule
import org.junit.Test

class ScreenRenderingEngineTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testRegistrationScreen() {
        // Set the content with the registration JSON configuration
        composeTestRule.setContent {
            ScreenRenderingEngine(testData)
        }

        // Check if the header text is displayed correctly
        composeTestRule.onNodeWithText("User Registration")
            .assertIsDisplayed()

        // Input Name
        composeTestRule.onNodeWithText("Name")
            .performTextInput("John Doe")

        // Input Email
        composeTestRule.onNodeWithText("Email")
            .performTextInput("john.doe@example.com")

        // Check the checkbox label
        composeTestRule.onNodeWithText("I accept the terms and conditions")
            .performClick()

        // Click the Register button
        composeTestRule.onNodeWithText("Register")
            .performClick()

        // Verify that registration logic is executed
        // Example assertion (update according to your registration logic):
        // composeTestRule.onNodeWithText("Registration Successful").assertIsDisplayed()

        // Click the Cancel button
        composeTestRule.onNodeWithText("Cancel")
            .performClick()

        // Verify that navigation logic is executed
        // Example assertion (update according to your navigation logic):
        // composeTestRule.onNodeWithText("Home Screen").assertIsDisplayed()
    }
}
