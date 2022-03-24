package com.example.hrec.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.hrec.presentation.forgotPassword.ForgotPassword
import com.example.hrec.presentation.forgotPassword.ForgotPasswordNew
import com.example.hrec.presentation.notification.Notification

fun NavGraphBuilder.notificationGraph(
    navController: NavHostController
){
    navigation(
        startDestination = Screen.Notification.route,
        route = NOTIFICATION_ROUTE
    ){
        composable(
            route = Screen.Notification.route
        ){
            Notification(navController = navController)
        }
    }
}