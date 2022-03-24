package com.example.hrec.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.hrec.presentation.forgotPassword.ForgotPassword
import com.example.hrec.presentation.forgotPassword.ForgotPasswordNew

fun NavGraphBuilder.forgotPasswordGraph(
    navController: NavHostController
) {
    navigation(
        startDestination = Screen.ForgotPassword.route,
        route = FORGOT_PASSWORD_ROUTE
    ) {
        composable(
            route = Screen.ForgotPassword.route
        ) {
            ForgotPassword(navController = navController)
        }
        composable(
            route = Screen.ForgotPasswordNew.route
        ) {
            ForgotPasswordNew(navController = navController)
        }
    }
}