package com.example.hrec.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.hrec.presentation.forgotPassword.ForgotPassword
import com.example.hrec.presentation.forgotPassword.ForgotPasswordNew
import com.example.hrec.presentation.onboardingScreen.OnboardScreen
import com.example.hrec.presentation.onboardingScreen.OnboardScreen2
import com.example.hrec.presentation.onboardingScreen.OnboardScreen3

fun NavGraphBuilder.onboardScreenGraph(
    navController: NavHostController
){
    navigation(
        startDestination = Screen.OnboardingScreen.route,
        route = ONBOARD_ROUTE
    ){
        composable(
            route = Screen.OnboardingScreen.route
        ){
            OnboardScreen(navController = navController)
        }
//
//        composable(
//            route = Screen.OnboardingScreen2.route
//        ){
//            OnboardScreen2(navController = navController)
//        }

        composable(
            route = Screen.OnboardingScreen3.route
        ){
            OnboardScreen3(navController = navController)
        }
    }
}