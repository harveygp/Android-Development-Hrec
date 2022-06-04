package com.example.hrec.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.hrec.presentation.applicantDetail.ApplicantDetail

fun NavGraphBuilder.applicantDetail(
    navController: NavHostController
){
    navigation(
        startDestination = Screen.ApplicantDetail.route,
        route = APPLICANTDETAIL_ROUTE
    ){
        composable(
            route = Screen.ApplicantDetail.route + "/{appId}"
        ){
            ApplicantDetail()
        }
    }
}