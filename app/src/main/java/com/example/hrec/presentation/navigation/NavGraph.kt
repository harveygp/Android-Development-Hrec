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
=======
        <<<<<<< HEAD
//        Notification
        notificationGraph(navController = navController)
        =======

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
        >>>>>>> 49787092dedc400239df3c43477617fbd043402a

        //Dashboard Graph
        dashboardGraph(navController = navController)
>>>>>>> cf1db6205633696024a218af047939ad66e4b9a3
    }
}
