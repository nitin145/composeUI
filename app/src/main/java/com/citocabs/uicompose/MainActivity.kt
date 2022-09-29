package com.citocabs.uicompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.citocabs.uicompose.ui.theme.UIComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UIComposeTheme {
                TopMenu(
                    onClickMenu = {},
                    onClickSearch = {},
                    onClickCart = {},
                )
            }
        }
    }
}

@Composable
fun TopMenu(onClickMenu: () -> Unit, onClickSearch: () -> Unit, onClickCart: () -> Unit) {
    Surface(
        modifier = Modifier.fillMaxSize().padding(horizontal = 10.dp),
        color = Color.LightGray
    ) {
        Column() {
            Row {
                Column(
                    Modifier
                        .weight(1f)
                        .wrapContentHeight()
                ) {
                    ToolbarView(
                        onClickMenu = { onClickMenu() },
                        onClickSearch = { onClickSearch() },
                        onClickCart = { onClickCart() },
                        "Android",
                        showMenuIcon = false
                    )
                }
                Spacer(modifier = Modifier.width(20.dp))
                Column(
                    Modifier.weight(1f)
                ) {
                    ToolbarView(onClickMenu = { onClickMenu() },
                        onClickSearch = { onClickSearch() },
                        onClickCart = { onClickCart() },"Android", showMenuIcon = true
                    )
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row {
                Column(
                    Modifier.weight(1f)
                ) {
                    ToolbarView(onClickMenu = { onClickMenu() },
                        onClickSearch = { onClickSearch() },
                        onClickCart = { onClickCart() },"Android"
                    )
                }


                Spacer(modifier = Modifier.width(20.dp))
                Column(
                    Modifier.weight(1f)
                ) {
                    ToolbarView(onClickMenu = { onClickMenu() },
                        onClickSearch = { onClickSearch() },
                        onClickCart = { onClickCart() },"Android", showMenuIcon = true
                    )
                }
            }
        }


    }
}

@Composable
fun ToolbarView(
    onClickMenu: () -> Unit,
    onClickSearch: () -> Unit,
    onClickCart: () -> Unit,
    title: String,
    showMenuIcon: Boolean = false,
    showSearchIcon: Boolean = true
) {

    Card() {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White)
                .padding(vertical = 10.dp)
        ) {
            val (hamburgerIcon, titleText, searchIcon, cartIcon, badgeIcon) = createRefs()

            if (showMenuIcon) {
                Image(
                    painter = painterResource(R.drawable.ic_baseline_dehaze_24),
                    contentDescription = "Hamburger",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .constrainAs(hamburgerIcon) {
                            start.linkTo(parent.start, 10.dp)
                            top.linkTo(parent.top)
                            bottom.linkTo(parent.bottom)
                        }
                        .clickable {
                            onClickMenu()
                        }
                        .width(24.dp)
                        .height(24.dp)
                )
            }
            Text(text = title,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .constrainAs(titleText) {
                        start.linkTo(hamburgerIcon.end)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    }

            )

            if (showSearchIcon) {
                Image(
                    painter = painterResource(R.drawable.ic_baseline_search_24),
                    colorFilter = ColorFilter.tint(colorResource(id = R.color.light_red)),
                    contentDescription = "Hamburger",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .constrainAs(searchIcon) {
                            end.linkTo(cartIcon.start, 20.dp)
                            top.linkTo(parent.top)
                            bottom.linkTo(parent.bottom)
                        }
                        .clickable {
                            onClickSearch()
                        }
                        .width(24.dp)
                        .height(24.dp)
                )
            }

            Image(
                painter = painterResource(R.drawable.ic_baseline_shopping_cart_24),
                contentDescription = "Hamburger",
                colorFilter = ColorFilter.tint(colorResource(id = R.color.light_red)),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .constrainAs(cartIcon) {
                        end.linkTo(parent.end, 10.dp)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    }.clickable {
                        onClickCart()
                    }
                    .width(24.dp)
                    .height(24.dp)
            )

            Text(
                modifier = Modifier
                    .constrainAs(badgeIcon) {
                        end.linkTo(cartIcon.end, (-1).dp)
                        top.linkTo(parent.top)
                    }
                    .drawBehind {
                        drawCircle(
                            color = Color.Red,
                            radius = this.size.maxDimension / 1.5F

                        )
                    },
                text = "14",
                fontSize = 8.sp,
                color = Color.White
            )

        }
    }


}

@Preview(showBackground = true, device = Devices.NEXUS_6)
@Composable
fun DefaultPreview() {
    UIComposeTheme {
        TopMenu(
            onClickMenu = {},
            onClickSearch = {},
            onClickCart = {},
        )
    }
}