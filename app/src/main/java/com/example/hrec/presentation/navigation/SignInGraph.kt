package com.example.hrec.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.hrec.presentation.signIn.SignIn

fun NavGraphBuilder.signInGraph(
    navController: NavHostController
){
    navigation(
        startDestination = Screen.SignIn.route,
        route = SIGN_IN_ROUTE
    ){
        composable(
            route = Screen.SignIn.route
        ){
            SignIn(navController = navController)
        }
    }
}