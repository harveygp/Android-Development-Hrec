package com.example.hrec.presentation.onboardingScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.hrec.R
import com.example.hrec.presentation.navigation.Screen

@Composable
fun OnboardScreen(navController: NavHostController) {


    Column(
        modifier = Modifier
            .background(colorResource(id = R.color.primary))
            .fillMaxSize()
    ) {

        Text(
            modifier = Modifier

                .padding(
                    start = dimensionResource(id = R.dimen.large_to_huge),
                    top = dimensionResource(id = R.dimen.large_to_huge)
                ),
            style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.SemiBold,
            color = colorResource(id = R.color.white),
            text = stringResource(id = R.string.tv_GettingStarted)
        )

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .weight(4f)
                .padding(
                    bottom = dimensionResource(id = R.dimen.huge)
                ),

            color = colorResource(id = R.color.primary)
        ) {
            Column(
                modifier = Modifier,
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_getting_started01),
                    contentDescription = "SplashImage"
                )
            }

        }

//        Box(modifier = Modifier
//            .fillMaxWidth()
//            .weight(6f),
//          ) {
//            Column(modifier = Modifier, verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
//                Image(painter = painterResource(id = R.drawable.ic_getting_started01),
//                    contentDescription = "SplashImage")
//            }
//
//        }

        Surface(
            modifier = Modifier
                .clip(
                    RoundedCornerShape(
                        topStart = dimensionResource(id = R.dimen.large),
                        topEnd = dimensionResource(id = R.dimen.large)
                    )
                )
                .fillMaxWidth()
                .weight(6f),
            color = colorResource(id = R.color.white)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = dimensionResource(id = R.dimen.large))
                    .padding(24.dp)
            ) {

                Text(
                    text = stringResource
                        (id = R.string.tv_descGettingStarted),
                    style = MaterialTheme.typography.body1,
                )

                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.End
                ) {

                    Button(
                        colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.primary)),
                        modifier = Modifier
                            .size(60.dp),
                        shape = CircleShape,
                        onClick = {
                            navController.navigate(
                                route = Screen.OnboardingScreen3.route
                            )
                        }) {

                        Icon(
                            painter = painterResource(id = R.drawable.ic_arrow_right),
                            contentDescription = "Button_next",
                            tint = colorResource(id = R.color.white)
                        )

                    }

                }


            }


        }


    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    OnboardScreen(navController = rememberNavController())
}