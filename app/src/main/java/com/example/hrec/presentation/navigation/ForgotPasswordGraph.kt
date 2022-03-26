package com.example.hrec.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.hrec.presentation.forgotPassword.ForgotPassword
import com.example.hrec.presentation.forgotPassword.ForgotPasswordNew

fun NavGraphBuilder.forgotPasswordGraph(
    navController: NavHostController
<<<<<<< HEAD
){
    navigation(
        startDestination = Screen.ForgotPassword.route,
        route = FORGOT_PASSWORD_ROUTE
    ){
        composable(
            route = Screen.ForgotPassword.route
        ){
            ForgotPassword(navController = navController)
        }
        composable(
            route = Screen.ForgotPasswordNew.route
        ){
            ForgotPasswordNew(navController = navController)
        }
    }
}
=======
    <<<<<<< HEAD
) {
    navigation(
        startDestination = Screen.ForgotPassword.route,
        route = FORGOT_PASSWORD_ROUTE
    ) {
        composable(
            route = Screen.ForgotPassword.route
        ) {
            =======
            ){
            navigation(
                startDestination = Screen.ForgotPassword.route,
                route = FORGOT_PASSWORD_ROUTE
            ){
                composable(
                    route = Screen.ForgotPassword.route
                ){
                    >>>>>>> 49787092dedc400239df3c43477617fbd043402a
                    ForgotPassword(navController = navController)
                }
                composable(
                    route = Screen.ForgotPasswordNew.route
                            <<<<<<< HEAD
                ) {
                    ForgotPasswordNew(navController = navController)
                }
            }
        }
            =======
            ){
            ForgotPasswordNew(navController = navController)
        }
        }
    }
    >>>>>>> 49787092dedc400239df3c43477617fbd043402a
>>>>>>> cf1db6205633696024a218af047939ad66e4b9a3
