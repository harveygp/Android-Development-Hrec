package com.example.hrec.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.hrec.presentation.profile.Profile

fun NavGraphBuilder.profileGraph(
    navController: NavHostController
){
    navigation(
        startDestination = Screen.Profile.route,
        route = PROFILE_ROUTE
    ){
        composable(
            route = Screen.Profile.route
        ){
            Profile(navController = navController)
        }
    }
}