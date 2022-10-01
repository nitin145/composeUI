package com.citocabs.uicompose

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class TopMenuViewTests {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun visibilityChecksColumns() {
        composeTestRule.waitForIdle()

        //Check all 4 columns displayed on screen
        composeTestRule
            .onNodeWithTag("FirstColumn")
            .assertIsDisplayed()
        composeTestRule
            .onNodeWithTag("SecondColumn")
            .assertIsDisplayed()
        composeTestRule
            .onNodeWithTag("ThirdColumn")
            .assertIsDisplayed()
        composeTestRule
            .onNodeWithTag("FourthColumn")
            .assertIsDisplayed()
    }

    @Test
    fun visibilityCheckForIcons() {
        composeTestRule.waitForIdle()

        composeTestRule.setContent {
            ToolbarView(
                onClickMenu = {},
                onClickSearch = {},
                onClickCart = {},
                title = "",
                showMenuIcon = true,
                showSearchIcon = true,
                showCartIcon = true
            )
        }

        composeTestRule.onNodeWithTag("Hamburger").assertIsDisplayed()
        composeTestRule.onNodeWithTag("Search").assertIsDisplayed()
        composeTestRule.onNodeWithTag("Cart").assertIsDisplayed()


    }

    @Test
    fun clickSelectionForIcons() {
        composeTestRule.waitForIdle()

        composeTestRule.setContent {
            ToolbarView(
                onClickMenu = {},
                onClickSearch = {},
                onClickCart = {},
                title = "",
                showMenuIcon = true,
                showSearchIcon = true,
                showCartIcon = true
            )
        }

        composeTestRule.onNodeWithTag("Hamburger").performClick()
        composeTestRule.onNodeWithTag("Search").performClick()
        composeTestRule.onNodeWithTag("Cart").performClick()


    }

}