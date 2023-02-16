package com.example.app3

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import com.example.app3.ui.theme.Seng22243Theme
import org.junit.Rule
import org.junit.Test

class EchoLogicTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testUi() {
        composeTestRule.setContent {
            Seng22243Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    EchoDetail()
                }
            }
        }

        composeTestRule.onNodeWithText("Echo").performClick()
        composeTestRule.onNodeWithText("Please enter your details.").assertIsDisplayed()
    }

    @Test
    fun it_should_show_message_for_no_name() {
        composeTestRule.setContent {
            Seng22243Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    EchoDetail()
                }
            }
        }

        composeTestRule.onNodeWithText("Age").performTextInput("23")
        composeTestRule.onNodeWithText("Echo").performClick()
        composeTestRule.onNodeWithText("Please enter your name.").assertIsDisplayed()
    }

    @Test
    fun it_should_show_message_for_no_age() {
        composeTestRule.setContent {
            Seng22243Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    EchoDetail()
                }
            }
        }

        composeTestRule.onNodeWithText("Name").performTextInput("Seyon")
        composeTestRule.onNodeWithText("Echo").performClick()
        composeTestRule.onNodeWithText("Please enter your age.").assertIsDisplayed()
    }

    @Test
    fun it_should_show_welcome_message_for_name_and_age() {
        composeTestRule.setContent {
            Seng22243Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    EchoDetail()
                }
            }
        }

        composeTestRule.onNodeWithText("Name").performTextInput("Seyon")
        composeTestRule.onNodeWithText("Age").performTextInput("23")
        composeTestRule.onNodeWithText("Echo").performClick()
        composeTestRule.onNodeWithText("Hello, Seyon!, you are 23 years old.").assertIsDisplayed()
    }
}