package com.myfirstcompose

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.myfirstcompose.ui.theme.MyFirstComposeTheme
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class RobolectricTest() {
//    @Test
//    fun showResult(){
//
//        val scnerio=launch(MainActivity::class.java)
//        scnerio.moveToState(Lifecycle.State.RESUMED)
//        scnerio.onActivity { activity ->
//            activity.findViewById<EditText>(R.id.).setText(5.toString)
//        }
//    }


    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun messageListTest() {
        // Set up the content for testing
        composeTestRule.setContent {
            MyFirstComposeTheme {
                MessageList(generateSampleMessages())
            }
        }

        // Verify that the first item in the list has the correct content
        composeTestRule.onNodeWithText("John Doe").assertExists()
        composeTestRule.onNodeWithText("This is the message body 1").assertExists()

        // Scroll to the bottom of the list
       // composeTestRule.onNodeWithTag("MessageList").performScrollTo()

        // Verify that the last item in the list has the correct content
        composeTestRule.onNodeWithText("Bob Smith").assertExists()
        composeTestRule.onNodeWithText("This is the message body 3").assertExists()
    }

    @Test
    fun messageCardTest() {
        // Set up the content for testing
        val message = MessageCard("John Doe", "This is the message body")

        composeTestRule.setContent {
            MyFirstComposeTheme {
                MessageCard(msg = message)
            }
        }

        // Verify that the MessageCard displays the correct content
        composeTestRule.onNodeWithText("John Doe").assertExists()
//        composeTestRule.onNodeWithText("Bob Smith").assertExists()
        composeTestRule.onNodeWithText("This is the message body").assertExists()
//        composeTestRule.onNodeWithText("This is the message body 2").assertExists()
//        composeTestRule.onNodeWithText("This is the message body 3").assertExists()
    }
}