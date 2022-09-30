//package com.citocabs.uicompose
//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.rememberScrollState
//import androidx.compose.foundation.verticalScroll
//import androidx.compose.material.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.platform.testTag
//import androidx.compose.ui.res.dimensionResource
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import com.safeway.andcoreuiapp.R
//import com.safeway.andcoreuiapp.util.TEST_TAG_COMPOSE_COLOR
//import com.safeway.andcoreuiapp.util.TEST_TAG_COMPOSE_COLOR_LIST
//
//
///**
// * This file contains all composable functions related to colors screen
// */
//
//@Composable
//fun ColorsList(colors: MutableMap<String, Color>?) {
//    Column(modifier = Modifier
//        .verticalScroll(rememberScrollState())
//        .testTag(
//            TEST_TAG_COMPOSE_COLOR_LIST
//        )){
//        colors?.forEach { color ->
//            Color(color.key,color.value)
//        }
//    }
//}
//
//@Composable
//fun Color(name: String, color: Color){
//    Text(text = name, modifier = Modifier
//        .background(color = color)
//        .fillMaxWidth()
//        .padding(dimensionResource(id = R.dimen.padding_15))
//        .testTag(TEST_TAG_COMPOSE_COLOR))
//}
//
//@Preview(showBackground = true)
//@Composable
//fun PreviewOfColor() {
//  Color(name = "Preview", color =Color.White )
//}