package com.example.hrec.presentation.splashScreen

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.hrec.R
import com.example.hrec.presentation.navigation.SIGN_IN_ROUTE
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavHostController
) {
    var startAnimation by remember {
        mutableStateOf(false)
    }
    val alphaAnim = animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(
            durationMillis = 3000
        ))

    LaunchedEffect(key1 = true) {
        startAnimation = true
        delay(4000)
        navController.navigate(SIGN_IN_ROUTE)
    }
    Splash(alpha = alphaAnim.value)
}


@Composable
fun Splash(alpha: Float) {
    // logo
    Box(
        modifier = Modifier
            .background(colorResource(id = R.color.white))
            .fillMaxSize()
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .alpha(alpha = alpha),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = "SplashImage"
            )
        }
    }
}

@Composable
@Preview
fun SplashScreenPreview() {
    Splash(alpha = 1f)
}
//
//@Composable
//@Preview(uiMode = UI_MODE_NIGHT_YES)
//fun SplashScreenDarkPreview() {
//    Splash(alpha = 1f)
//}



