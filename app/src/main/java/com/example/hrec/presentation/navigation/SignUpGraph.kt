package com.example.hrec.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.hrec.presentation.signUp.SignUp

fun NavGraphBuilder.signUpGraph(
    navController: NavHostController
){
    navigation(
        startDestination = Screen.SignUp.route,
        route = SIGN_UP_ROUTE
    ){
        composable(
            route = Screen.SignUp.route
        ){
            SignUp(navController = navController)
        }
    }
}