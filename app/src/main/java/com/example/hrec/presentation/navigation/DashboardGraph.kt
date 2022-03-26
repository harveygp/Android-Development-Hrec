package com.example.hrec.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.hrec.presentation.dashboard.Dashboard

fun NavGraphBuilder.dashboardGraph(
    navController: NavHostController
){
    navigation(
        startDestination = Screen.Dashboard.route,
        route = DASHBOARD_ROUTE
    ){
        composable(
            route = Screen.Dashboard.route
        ){
            Dashboard(navController = navController)
        }
    }
}