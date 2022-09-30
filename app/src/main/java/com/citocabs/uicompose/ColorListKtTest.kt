//package com.citocabs.uicompose
//
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.test.*
//import androidx.compose.ui.test.junit4.createAndroidComposeRule
//import androidx.compose.ui.test.junit4.createComposeRule
//import androidx.compose.ui.test.junit4.createEmptyComposeRule
//import com.safeway.andcoreuiapp.data.repo.DesignSystemHomeRepository
//import com.safeway.andcoreuiapp.data.repo.DesignSystemHomeRepositoryImpl
//import com.safeway.andcoreuiapp.util.TEST_TAG_COMPOSE_COLOR
//import com.safeway.andcoreuiapp.util.TEST_TAG_COMPOSE_COLOR_LIST
//import com.safeway.andcoreuiapp.util.ThemeType
//import com.safeway.andcoreuiapp.util.getColors
//import org.junit.Assert.*
//
//import org.junit.After
//import org.junit.Before
//import org.junit.Rule
//import org.junit.Test
//
//class ColorListKtTest {
//
//    @get:Rule
//    val composeTestRule = createComposeRule()
//
//    private lateinit var designSystemHomeRepositoryImpl: DesignSystemHomeRepository
//    private lateinit var colorsList: MutableMap<String, Color>
//
//
//    private val COLOR_NAME_CONTAINS="color"
//
//
//    @Before
//    fun setUp() {
//
//        designSystemHomeRepositoryImpl=DesignSystemHomeRepositoryImpl()
//        colorsList= designSystemHomeRepositoryImpl.getColors(ThemeType.BAKER)
//
//    }
//
//
//
//    @Test
//    fun testColorsList() {
//
//        val colorsListEntries=colorsList.entries.toList()
//
//        composeTestRule.setContent {
//            ColorsList(colors = colorsList)
//        }
//
//        composeTestRule.waitForIdle()
//        composeTestRule.onNodeWithTag(TEST_TAG_COMPOSE_COLOR_LIST).assertIsDisplayed().assert(
//            hasScrollAction())
//        composeTestRule.onAllNodesWithTag(TEST_TAG_COMPOSE_COLOR).assertCountEquals(colorsList.size).assertAll(
//            hasText(COLOR_NAME_CONTAINS, substring = true, ignoreCase = true))
//        composeTestRule.onNodeWithText(colorsListEntries[0].key).assertIsDisplayed()
//        composeTestRule.onNodeWithText(colorsListEntries[colorsListEntries.size-1].key).assertExists()
//    }
//
//    @Test
//    fun testColorItem() {
//
//        val colorsListEntries=colorsList.entries.toList()
//        val firstColor=colorsListEntries[0]
//
//        composeTestRule.setContent {
//            com.safeway.andcoreuiapp.ui.view.Color(name = firstColor.key, color = firstColor.value)
//
//        }
//        composeTestRule.waitForIdle()
//        composeTestRule.onNodeWithText(firstColor.key).assertIsDisplayed()
//    }
//}