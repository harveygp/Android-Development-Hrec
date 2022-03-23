package com.example.hrec.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.hrec.presentation.navigation.*

@Composable
fun SetupNavGraph(
    navController : NavHostController
){
    NavHost(
        navController = navController ,
        startDestination = FORGOT_PASSWORD_ROUTE
    ){
        forgotPasswordGraph(navController = navController)
        profileGraph(navController = navController)

<<<<<<< HEAD
//      Sign In
        signInGraph(navController = navController)

//      Sign Up
        signUpGraph(navController = navController)
=======
        //splash screen
        splashScreenGraph(navController = navController)

        //onboard screen
        onboardScreenGraph(navController = navController)
>>>>>>> 4a208073cac62e6583c4eda7eb03d9368a4d1a3f
    }
}
