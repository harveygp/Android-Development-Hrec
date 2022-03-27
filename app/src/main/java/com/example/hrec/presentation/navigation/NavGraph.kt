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
        startDestination = SPLASH_ROUTE
    ){
        forgotPasswordGraph(navController = navController)
        profileGraph(navController = navController)
<<<<<<< HEAD
<<<<<<< HEAD
=======
        <<<<<<< HEAD
=======

>>>>>>> 415502e1b709cb6af62c2d4972f31475ef4acaa2
//        Notification
        notificationGraph(navController = navController)

//      Sign In
        signInGraph(navController = navController)

//      Sign Up
        signUpGraph(navController = navController)

        //splash screen
        splashScreenGraph(navController = navController)

        //onboard screen
        onboardScreenGraph(navController = navController)

        //Dashboard Graph
        dashboardGraph(navController = navController)
>>>>>>> cf1db6205633696024a218af047939ad66e4b9a3
    }
}
