package com.example.hrec.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.hrec.presentation.forgotPassword.ForgotPassword
import com.example.hrec.presentation.forgotPassword.ForgotPasswordNew
import com.example.hrec.presentation.splashScreen.SplashScreen


fun NavGraphBuilder.splashScreenGraph(
    navController: NavHostController
){
    navigation(
        startDestination = Screen.splashScreen.route,
        route = SPLASH_ROUTE
    ){
        composable(
            route = Screen.splashScreen.route
        ){
            SplashScreen(navController = navController)
        }
    }
}