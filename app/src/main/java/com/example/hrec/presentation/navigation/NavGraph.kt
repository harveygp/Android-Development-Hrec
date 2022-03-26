package com.example.hrec.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.hrec.presentation.navigation.dashboardGraph
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

        // Dashboard
        dashboardGraph(navController = navController)
    }
}
